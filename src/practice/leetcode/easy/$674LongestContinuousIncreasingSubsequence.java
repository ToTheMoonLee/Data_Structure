package practice.leetcode.easy;

/**
 * Given an unsorted array of integers, find the length of longest continuous increasing subsequence (subarray).
 *
 * Example 1:
 * Input: [1,3,5,4,7]
 * Output: 3
 * Explanation: The longest continuous increasing subsequence is [1,3,5], its length is 3.
 * Even though [1,3,5,7] is also an increasing subsequence,
 * it's not a continuous one where 5 and 7 are separated by 4.
 * Example 2:
 * Input: [2,2,2,2,2]
 * Output: 1
 * Explanation: The longest continuous increasing subsequence is [2], its length is 1.
 * Note: Length of the array will not exceed 10,000.
 */
public class $674LongestContinuousIncreasingSubsequence {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 4, 7};
        System.out.println(findLengthOfLCIS(nums));
        System.out.println(findLengthOfLCIS2(nums));
    }

    /**
     * their concise solution of this problem
     * @param nums
     * @return
     */
    static int findLengthOfLCIS2(int[] nums) {
        int res = 0, cnt = 0;
        for(int i = 0; i < nums.length; i++){
            if(i == 0 || nums[i-1] < nums[i]) res = Math.max(res, ++cnt);
            else cnt = 1;
        }
        return res;
    }

    /**
     * my solution of this problem
     * @param nums
     * @return
     */
    static int findLengthOfLCIS(int[] nums) {
        if (nums.length == 0) return 0;
        int count = 1;
        int max = 1;
        for (int i=0;i<nums.length-1;i++) {
            if (nums[i]<nums[i+1]) {
                count++;
            } else {
                max = Math.max(max,count);
                count = 1;
            }
        }
        return Math.max(max,count);
    }
}
