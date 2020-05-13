package practice.datastructure.dynamicprogramming;

public class $0_1BagDPUpgraded extends $0_1BagDP{

    public static void main(String[] args) {
        System.out.println("max is " + getMaxValue());
        System.out.println("max is " + knapsack3(items,values,5,9));
    }

    static int[] values = {3, 4, 8, 9, 6};

    /**
     * using a one-dimensional array to solve this problem
     * @return
     */
    static int getMaxValue() {
        int[] dp = new int[max+1];
        for (int i=0;i<dp.length;i++) dp[i] = -1;

        dp[0] = 0;
        if (items[0]<=max) {
            dp[items[0]] = values[0];
        }

        for (int i=1;i<n;i++) {
            for (int j=max-items[i];j>=0;j--) {
                if (dp[j]>=0 && dp[j]+values[i] > dp[j+items[i]]) {
                    dp[j+items[i]] = dp[j]+values[i];
                }
            }
        }
        int max = 0;
        for (int aDp : dp) {
            max = Math.max(max, aDp);
        }
        return max;
    }

    /**
     * <a href="https://time.geekbang.org/column/article/74788?utm_source=web&utm_medium=pinpaizhuanqu&utm_campaign=baidu&utm_term=pinpaizhuanqu&utm_content=0427"/>
     * @param weight
     * @param value
     * @param n
     * @param w
     * @return
     */
    public static int knapsack3(int[] weight, int[] value, int n, int w) {
        int[][] states = new int[n][w+1];
        for (int i = 0; i < n; ++i) { // 初始化states
            for (int j = 0; j < w+1; ++j) {
                states[i][j] = -1;
            }
        }
        states[0][0] = 0;
        if (weight[0] <= w) {
            states[0][weight[0]] = value[0];
        }
        for (int i = 1; i < n; ++i) { //动态规划，状态转移
            for (int j = 0; j <= w; ++j) { // 不选择第i个物品
                if (states[i-1][j] >= 0) states[i][j] = states[i-1][j];
            }
            for (int j = 0; j <= w-weight[i]; ++j) { // 选择第i个物品
                if (states[i-1][j] >= 0) {
                    int v = states[i-1][j] + value[i];
                    if (v > states[i][j+weight[i]]) {
                        states[i][j+weight[i]] = v;
                    }
                }
            }
        }
        // 找出最大值
        int maxvalue = -1;
        for (int j = 0; j <= w; ++j) {
            if (states[n-1][j] > maxvalue) maxvalue = states[n-1][j];
        }
        return maxvalue;
    }
}
