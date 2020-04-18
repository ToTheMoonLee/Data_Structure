package practice.leetcode.easy;

/**
 * Given an array of integers nums, write a method that returns the "pivot" index of this array.
 *
 * We define the pivot index as the index where the sum of the numbers to the left of the index
 * is equal to the sum of the numbers to the right of the index.
 *
 * If no such index exists, we should return -1. If there are multiple pivot indexes,
 * you should return the left-most pivot index.
 *
 * Example 1:
 *
 * Input:
 * nums = [1, 7, 3, 6, 5, 6]
 * Output: 3
 * Explanation:
 * The sum of the numbers to the left of index 3 (nums[3] = 6)
 * is equal to the sum of numbers to the right of index 3.
 * Also, 3 is the first index where this occurs.
 *
 *
 * Example 2:
 *
 * Input:
 * nums = [1, 2, 3]
 * Output: -1
 * Explanation:
 * There is no index that satisfies the conditions in the problem statement.
 *
 *
 * Note:
 *
 * The length of nums will be in the range [0, 10000].
 * Each element nums[i] will be an integer in the range [-1000, 1000].
 */
public class $724FindPivotIndex {

    public static void main(String[] args) {
        System.out.println(pivotIndex(new int[]{1,7,3,6,5,6}));
        System.out.println(pivotIndex2(new int[]{1,7,3,6,5,6}));
    }

    /**
     * their faster and concise solution of this problem
     * @param nums
     * @return
     */
    static int pivotIndex2(int[] nums) {
        int total = 0, sum = 0;
        for (int num : nums) total += num;
        for (int i = 0; i < nums.length; sum += nums[i++])
            if (sum * 2 == total - nums[i]) return i;
        return -1;
    }

    /**
     * my first solution of this problem
     * @param nums
     * @return
     */
    static int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] sum1 = new int[n];
        int[] sum2 = new int[n];
        for (int i=0;i<nums.length;i++) {
            if (i==0) {
                sum1[i] = nums[i];
                sum2[n-i-1] = nums[n-i-1];
            } else {
                sum1[i] = sum1[i-1] + nums[i];
                sum2[n-i-1] = sum2[n-i] + nums[n-i-1];
            }
        }
        for (int i=0;i<sum1.length;i++) {
            if (sum1[i] == sum2[i]) return i;
        }
        return -1;
    }
}
