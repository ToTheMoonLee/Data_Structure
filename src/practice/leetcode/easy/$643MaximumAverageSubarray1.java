package practice.leetcode.easy;

/**
 * Given an array consisting of n integers, find the contiguous subarray of given length k
 * that has the maximum average value. And you need to output the maximum average value.
 *
 * Example 1:
 *
 * Input: [1,12,-5,-6,50,3], k = 4
 * Output: 12.75
 * Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75
 *
 *
 * Note:
 *
 * 1 <= k <= n <= 30,000.
 * Elements of the given array will be in the range [-10,000, 10,000].
 */
public class $643MaximumAverageSubarray1 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 12, -5, -6, 50, 3};
        System.out.println(findMaxAverage(nums, 4));
    }

    /**
     * my solution of this problem
     * @param nums
     * @param k
     * @return
     */
    static double findMaxAverage(int[] nums, int k) {
        double sum =0;
        for (int i=0;i<k;i++) {
            sum+=nums[i];
        }
        double max = sum;
        for (int i=k;i<nums.length;i++) {
            sum = sum-nums[i-k]+nums[i];
            max = Math.max(max,sum);
        }
        return max/k;
    }
}
