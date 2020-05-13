package practice.datastructure.dynamicprogramming;

public class ChooseMerchandise {

    public static void main(String[] args) {

    }

    static void choose(int[] merchandises,int threshold) {
        int max = threshold*3;
        boolean[][] dp = new boolean[merchandises.length][max+1];
        dp[0][0] = true;
        if (merchandises[0] <= max) {
            dp[0][merchandises[0]] = true;
        }
        for (int i=1;i<merchandises.length;i++) {
            for (int j=0;j<dp.length;j++) {
                if (dp[i-1][j]) dp[i][j] = true;
            }
            for (int j=0;j<=max-merchandises[i];j++) {
                if (dp[i-1][j]) dp[i][j+merchandises[i]] = true;
            }
        }
        int total = 0;
        for (total=threshold;total<dp.length;total++) {
            if (dp[merchandises.length-1][total]) {
                break;
            }
        }
        if (total == max+1) return;
        for (int i=merchandises.length-1;i>=1;i--) {
            if (total-merchandises[i] >=0 && dp[i-1][total-merchandises[i]]) {
                System.out.println(" i is " + i);
                total = total - merchandises[i];
            }
        }
        if (total!=0) System.out.println(" i is " + 0);
    }
}
