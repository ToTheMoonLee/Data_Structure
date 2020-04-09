package practice.leetcode.easy;

import java.util.Arrays;

/**
 * Given an array of 2n integers, your task is to group these integers into n pairs of integer,
 * say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.
 *
 * Example 1:
 * Input: [1,4,3,2]
 *
 * Output: 4
 * Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).
 * Note:
 * n is a positive integer, which is in the range of [1, 10000].
 * All the integers in the array will be in the range of [-10000, 10000].
 */
public class $561ArrayPartition1 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 4, 3, 2};
        System.out.println(arrayPairSum(nums));
        System.out.println(arrayPairSum2(nums));
    }

    /**
     * their faster solution of this problem
     * @param nums
     * @return
     */
    static int arrayPairSum2(int[] nums) {
        int[] bucket = new int[20001];
        for (int i=0;i<nums.length;i++) {
            bucket[nums[i]+10000]++;
        }
        int sum=0;
        boolean odd = true;
        for (int i=0;i<bucket.length;i++) {
            while (bucket[i] > 0) {
                if (odd) {
                    sum = sum + i - 10000;
                }
                odd = !odd;
                bucket[i]--;
            }
        }
        return sum;
    }

    /**
     * my solution of this problem
     * @param nums
     * @return
     */
    static int arrayPairSum(int[] nums) {
        if (nums.length==0 || nums.length == 1) return 0;
        Arrays.sort(nums);
        int sum = 0;
        for (int i=0;i<nums.length;i+=2) {
            sum+=nums[i];
        }
        return sum;
    }
}
