package practice.leetcode.medium;

import java.util.Arrays;

/**
 * You are given coins of different denominations and a total amount of money amount.
 * Write a function to compute the fewest number of coins that you need to make up that amount.
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 *
 * Example 1:
 *
 * Input: coins = [1, 2, 5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 * Example 2:
 *
 * Input: coins = [2], amount = 3
 * Output: -1
 * Note:
 * You may assume that you have an infinite number of each kind of coin.
 */
public class $322CoinChange {

    public static void main(String[] args) {
        int[] coins = new int[]{1, 2, 5};
        System.out.println(coinChange(coins,11));
        System.out.println(coinChange2(coins,11));
        System.out.println(coinChange3(coins,11));
    }

    /**
     * their second dp solution of this problem
     * @param coins
     * @param amount
     * @return
     */
    static int coinChange3(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount+1];
        Arrays.fill(dp,max);
        dp[0] = 0;
        for (int i=1;i<=amount;i++) {
            for (int j=0;j<coins.length;j++) {
                if (coins[j]<=i) {
                    dp[i] = Math.min(dp[i],dp[i-coins[j]]+1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];

    }

    /**
     * their dp solution of this problem
     * @param coins
     * @param amount
     * @return
     */
    static int coinChange2(int[] coins, int amount) {
        if (amount < 1) return 0;

        return getCount(coins,amount,new int[amount]);

    }

    static int getCount(int[] coins,int amount,int[] dp) {
        if (amount < 0) return -1;
        if (amount == 0) return 0;
        if (dp[amount-1] !=0) return dp[amount-1];
        int min = Integer.MAX_VALUE;
        for (int i=0;i<coins.length;i++) {
            int res = getCount(coins,amount-coins[i],dp);
            if (res>=0 && min > res) {
                min = res+1;
            }
        }
        dp[amount-1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return dp[amount-1];
    }

    /**
     * my first solution of this problem
     */
    static int ans = Integer.MAX_VALUE;
    static int[][] memo;

    static int coinChange(int[] coins, int amount) {
        memo = new int[coins.length][amount + 1];
        get(0, coins, amount, 0, 0);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    static void get(int p, int[] coins, int amount, int curAmount, int count) {
        if (p == coins.length || curAmount == amount) {
            if (curAmount == amount && ans > count) {
                ans = count;
            }
            return;
        }
        if (memo[p][curAmount] != 0 && memo[p][curAmount] < count) return;
        memo[p][curAmount] = count;

        get(p + 1, coins, amount, curAmount, count);
        while (curAmount + coins[p] <= amount) {
            curAmount = curAmount + +coins[p];
            count++;
            get(p + 1, coins, amount, curAmount, count);
        }
    }
}
