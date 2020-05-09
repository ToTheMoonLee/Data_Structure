package practice.leetcode.easy;

/**
 * There are 2N people a company is planning to interview.
 * The cost of flying the i-th person to city A is costs[i][0],
 * and the cost of flying the i-th person to city B is costs[i][1].
 *
 * Return the minimum cost to fly every person to a city such that exactly N people arrive in each city.
 *
 *
 *
 * Example 1:
 *
 * Input: [[10,20],[30,200],[400,50],[30,20]]
 * Output: 110
 * Explanation:
 * The first person goes to city A for a cost of 10.
 * The second person goes to city A for a cost of 30.
 * The third person goes to city B for a cost of 50.
 * The fourth person goes to city B for a cost of 20.
 *
 * The total minimum cost is 10 + 30 + 50 + 20 = 110 to have half the people interviewing in each city.
 *
 *
 * Note:
 *
 * 1 <= costs.length <= 100
 * It is guaranteed that costs.length is even.
 * 1 <= costs[i][0], costs[i][1] <= 1000
 */
public class $1029TwoCityScheduling {

    public static void main(String[] args) {
        System.out.println(twoCitySchedCost(new int[][]{new int[]{10, 20}, new int[]{30, 200}, new int[]{400, 50}, new int[]{30, 20}}));
        System.out.println(twoCitySchedCost2(new int[][]{new int[]{10, 20}, new int[]{30, 200}, new int[]{400, 50}, new int[]{30, 20}}));
    }

    /**
     * their dp solution of this problem
     * @param costs
     * @return
     */
    static int twoCitySchedCost2(int[][] costs) {
        int N = costs.length / 2;
        int[][] dp = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            dp[i][0] = dp[i - 1][0] + costs[i - 1][0];
        }
        for (int j = 1; j <= N; j++) {
            dp[0][j] = dp[0][j - 1] + costs[j - 1][1];
        }
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i][j] = Math.min(dp[i - 1][j] + costs[i + j - 1][0], dp[i][j - 1] + costs[i + j - 1][1]);
            }
        }
        return dp[N][N];
    }

    /**
     * my solution of this problem
     * @param costs
     * @return
     */
    static int twoCitySchedCost(int[][] costs) {
        quickSort(costs,0,costs.length-1);
        int ans = 0;
        for (int i=0;i<costs.length/2;i++) {
            ans+=costs[i][0];
        }
        for (int i=costs.length/2;i<costs.length;i++) {
            ans+=costs[i][1];
        }
        return ans;
    }

    static void quickSort(int[][] nums,int start,int end) {
        if (start >= end) return;
        int[] pivot = nums[end];
        int i = start;
        int j = start;
        while (j<end) {
            if (nums[j][1]-nums[j][0]>pivot[1]-pivot[0]) {
                int[] temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                i++;
            }
            j++;
        }
        nums[end] = nums[i];
        nums[i] = pivot;
        quickSort(nums,start,i-1);
        quickSort(nums,i+1,end);
    }
}
