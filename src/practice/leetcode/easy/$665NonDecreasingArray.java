package practice.leetcode.easy;

/**
 * Given an array nums with n integers, your task is to check if it could become non-decreasing
 * by modifying at most 1 element.
 *
 * We define an array is non-decreasing if nums[i] <= nums[i + 1] holds for every i (0-based)
 * such that (0 <= i <= n - 2).
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [4,2,3]
 * Output: true
 * Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
 * Example 2:
 *
 * Input: nums = [4,2,1]
 * Output: false
 * Explanation: You can't get a non-decreasing array by modify at most one element.
 *
 *
 * Constraints:
 *
 * 1 <= n <= 10 ^ 4
 * - 10 ^ 5 <= nums[i] <= 10 ^ 5
 */
public class $665NonDecreasingArray {

    public static void main(String[] args) {
        int[] nums = new int[]{4, 2, 3};
        System.out.println(checkPossibility(nums));
        System.out.println(checkPossibility2(nums));
    }

    /**
     * their greedy solution of this problem
     * @param nums
     * @return
     */
    static boolean checkPossibility2(int[] nums) {
        int count = 0;
        for (int i=1;i<nums.length && count<=1;i++) {
            if (nums[i-1] > nums[i]) {
                count++;
                if (i-2 < 0 || nums[i] >= nums[i-2]) nums[i-1] = nums[i];
                else nums[i] = nums[i-1];
            }
        }
        return count<=1;
    }

    /**
     * my solution of this problem
     * @param nums
     * @return
     */
    static boolean checkPossibility(int[] nums) {
        int count = 0;
        int count2 = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int n = nums.length;
        for (int i=0;i<nums.length;i++) {
            max = Math.max(max,nums[i]);
            min = Math.min(min,nums[n-i-1]);
            if (nums[i] < max) count++;
            if (nums[n-i-1] > min) count2++;
            if (count >= 2&&count2 >= 2) return false;
        }
        return true;
    }
}
