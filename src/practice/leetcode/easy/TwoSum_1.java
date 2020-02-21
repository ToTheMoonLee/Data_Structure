package practice.leetcode.easy;

import java.util.HashMap;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class TwoSum_1 {

    public static void main(String[] args) {
        int[] result = new Solution().twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println("result is [" + result[0] + ", " + result[1] + "]");
    }

    static class Solution {
        public int[] twoSum(int[] nums, int target) {
            HashMap<Integer,Integer> hash = new HashMap<>();
            int[] result = new int[2];
            for (int i=0;i<nums.length;i++) {
                if (hash.get(nums[i]) == null) {
                    hash.put(target - nums[i],i);
                } else {
                    result[0] = hash.get(nums[i]);
                    result[1] = i;
                    return result;
                }
            }
            return result;
        }
    }
}
