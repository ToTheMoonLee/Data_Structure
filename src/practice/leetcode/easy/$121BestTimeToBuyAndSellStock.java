package practice.leetcode.easy;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 *
 * If you were only permitted to complete at most one transaction
 * (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 *
 * Note that you cannot sell a stock before you buy one.
 *
 * Example 1:
 *
 * Input: [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 *              Not 7-1 = 6, as selling price needs to be larger than buying price.
 * Example 2:
 *
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */
public class $121BestTimeToBuyAndSellStock {

    public static void main(String[] args) {
        int[] prices = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
        System.out.println(maxProfit2(prices));
        System.out.println(maxProfit3(prices));
        System.out.println(maxProfit4(prices));
    }

    /**
     * their amazing solution of this problem
     * @param prices
     * @return
     */
    static int maxProfit4(int[] prices) {
        int maxProfit = 0;
        int curMax = 0;
        for (int i = 1; i < prices.length; i++) {
            curMax = Math.max(0, curMax + prices[i] - prices[i - 1]);
            maxProfit = Math.max(maxProfit, curMax);
        }
        return maxProfit;
    }

    /**
     * the official solution of this problem
     * @param prices
     * @return
     */
    static int maxProfit3(int[] prices) {
        int minProfit = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minProfit) {
                minProfit = prices[i];
            } else if (prices[i] - minProfit > maxProfit) {
                maxProfit = prices[i] - minProfit;
            }
        }
        return maxProfit;
    }


    /**
     * my second solution of this problem
     *
     * @param prices
     * @return
     */
    static int maxProfit2(int[] prices) {
        if (prices == null || prices.length == 0 || prices.length == 1) return 0;
        int profit = 0;
        int i = prices.length - 2;
        int high = prices.length - 1;
        int low = prices.length - 2;
        while (i >= 0) {
            if (prices[i] > prices[high]) high = i;
            if (high < low) low = high;
            if (prices[i] < prices[low]) low = i;
            if (high > low && prices[high] - prices[low] > profit) profit = prices[high] - prices[low];
            i--;
        }
        return profit;
    }

    /**
     * my first solution of this problem
     *
     * @param prices
     * @return
     */
    static int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] - prices[i] > profit) {
                    profit = prices[j] - prices[i];
                }
            }
        }
        return profit;
    }
}
