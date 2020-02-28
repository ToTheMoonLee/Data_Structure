package practice.leetcode.easy;

/**
 * Given an integer array nums,
 * find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 * Example:
 *
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 */
public class $53MaximumSubarray {

    public static void main(String[] args) {
        int[] arr = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(arr));

    }

    /**
     * their solution of this problem,and I haven't solved it.
     * <a href="https://leetcode.com/problems/maximum-subarray/discuss/20211/Accepted-O(n)-solution-in-java"/>
     * @param nums
     * @return
     */
    static int maxSubArray(int[] nums) {
        int maxEnding = nums[0];
        int maxSoFar = nums[0];
        for (int i = 1;i<nums.length;i++) {
            maxEnding = Math.max(maxEnding + nums[i],nums[i]);
            maxSoFar = Math.max(maxEnding,maxSoFar);
        }
        return maxSoFar;
    }
}
