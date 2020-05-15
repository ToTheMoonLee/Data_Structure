package practice.datastructure.dynamicprogramming;

/**
 * 假设我们有一个 n 乘以 n 的矩阵 w[n][n]。矩阵存储的都是正整数。
 * 棋子起始位置在左上角，终止位置在右下角。我们将棋子从左上角移动到右下角。
 * 每次只能向右或者向下移动一位。从左上角到右下角，会有很多不同的路径可以走。
 * 我们把每条路径经过的数字加起来看作路径的长度。那从左上角移动到右下角的最短路径长度是多少呢？
 *
 * -----------------
 * | 1 | 3 | 5 | 9 |
 * -----------------
 * | 2 | 1 | 3 | 4 |
 * -----------------
 * | 5 | 2 | 6 | 7 |
 * -----------------
 * | 6 | 8 | 4 | 3 |
 * -----------------
 *
 */
public class MinDistance {

    private static int ans = Integer.MAX_VALUE;
    private static int[][] memo ;

    public static void main(String[] args) {
        int[][] w = new int[][]{
                new int[]{1, 3, 5, 9},
                new int[]{2, 1, 3, 4},
                new int[]{5, 2, 6, 7},
                new int[]{6, 8, 4, 3}
        };
        getMin(0, 0, 0, w.length, w);
        System.out.println("ans is " + (ans + w[w.length-1][w.length-1]));
        System.out.println("ans is " + getMin(w));
        memo = new int[w.length][w[0].length];
        System.out.println("ans is " + getMin(w.length - 1, w[0].length - 1, w));

    }

    /**
     * the other dynamic programming
     * @param i
     * @param j
     * @param w
     * @return
     */
    static int getMin(int i, int j,int[][] w) {
        if (i==0 && j==0) return w[0][0];
        if (memo[i][j]>0) return memo[i][j];
        int leftMin = Integer.MAX_VALUE;
        if (i-1>=0) {
            leftMin = getMin(i - 1, j, w);
        }
        int topMin = Integer.MAX_VALUE;
        if (j - 1 >= 0) {
            topMin = getMin(i, j - 1, w);
        }
        int curMin = w[i][j] + Math.min(leftMin, topMin);
        memo[i][j] = curMin;
        return curMin;
    }

    /**
     * dynamic programming
     * @param w the matrix
     */
    static int getMin(int[][] w) {
        int[][] dp = new int[w.length][w[0].length];
        for (int i=0;i<dp.length;i++) {
            if (i==0) dp[0][i] = w[0][i];
            else dp[0][i] = w[0][i] + dp[0][i-1];
        }
        for (int i=0;i<dp.length;i++) {
            if (i==0) dp[i][0] = w[i][0];
            else dp[i][0] = w[i][0] + dp[i-1][0];
        }

        for (int i=1;i<w.length;i++) {
            for (int j=1;j<w[i].length;j++) {
                dp[i][j] = w[i][j] + Math.min(dp[i-1][j],dp[i][j-1]);
            }
        }
        return dp[w.length - 1][w[0].length-1];
    }

    /**
     * force solution
     * @param i 第i行
     * @param j 第j列
     * @param n 矩阵的长度
     * @param cur 走到(i,j)的步数
     */
    static void getMin(int i, int j,int cur,int n,int[][] w) {
        if (i==n-1 && j==n-1) {
            if (ans > cur) {
                ans = cur;
            }
            return;
        }
        if (i<n-1) {
            getMin(i + 1, j, cur + w[i][j], n, w);
        }
        if (j<n-1) {
            getMin(i, j + 1, cur + w[i][j], n, w);
        }
    }

}
