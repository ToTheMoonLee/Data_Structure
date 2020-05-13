package practice.datastructure.dynamicprogramming;

public class $0_1BagDP {

    public static void main(String[] args) {
        System.out.println("the ans is " + put());;
    }

    protected static int[] items = new int[]{2, 2, 4, 6, 3};
    protected static int n = 5; // the number of values
    protected static int max = 9; // the bag's max value;
    protected static boolean[] dp = new boolean[max+1];

    /**
     * solving this problem with dynamic programming
     * the time compelexity of this methed is n*max
     */
    static int put() {
        dp[0] = true;
        if (items[0] <= max) dp[items[0]] = true;

        for (int i=1;i<n;i++) {
            for (int j=max-items[i];j>=0;j--) {
                if (dp[j]) dp[j+items[i]] = true;
            }
        }

        for (int i=dp.length-1;i>=0;i--) {
            if (dp[i]) {
                return i;
            }
        }
        return 0;
    }
}
