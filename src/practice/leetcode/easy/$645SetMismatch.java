package practice.leetcode.easy;

import practice.datastructure.util.PrintUtil;

import java.util.HashSet;

/**
 * The set S originally contains numbers from 1 to n. But unfortunately,
 * due to the data error, one of the numbers in the set got duplicated to another number in the set,
 * which results in repetition of one number and loss of another number.
 *
 * Given an array nums representing the data status of this set after the error.
 * Your task is to firstly find the number occurs twice and then find the number that is missing.
 * Return them in the form of an array.
 *
 * Example 1:
 * Input: nums = [1,2,2,4]
 * Output: [2,3]
 * Note:
 * The given array size will in the range [2, 10000].
 * The given array's numbers won't have any order.
 */
public class $645SetMismatch {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2, 4};
        PrintUtil.printArr(findErrorNums(nums));
        System.out.println("-------------------");
        PrintUtil.printArr(findErrorNums2(nums));
        System.out.println("-------------------");
        PrintUtil.printArr(findErrorNums3(nums));
    }

    /**
     * their Space O(1) solution of this problem, beats 86%
     * @param nums
     * @return
     */
    static int[] findErrorNums3(int[] nums) {
        int[] result = new int[2];
        for (int i=0;i<nums.length;i++) {
            if (nums[Math.abs(nums[i])-1] < 0) result[0] = Math.abs(nums[i]);
            else nums[Math.abs(nums[i])-1]*=-1;
        }
        for (int i=0;i<nums.length;i++) {
            if (nums[i]>0) result[1] = i+1;
        }
        return result;
    }

    /**
     * my second solution of this problem,beats 100%
     * @param nums
     * @return
     */
    static int[] findErrorNums2(int[] nums) {
        int[] arr = new int[nums.length+1];
        for (int i=0;i<nums.length;i++) {
            arr[nums[i]]++;
        }
        int[] result = new int[2];
        for (int i=1;i<arr.length;i++) {
            if (arr[i] == 2) result[0] = i;
            if (arr[i] == 0) result[1] = i;
        }
        return result;
    }

    /**
     * my first solution of this problem
     * @param nums
     * @return
     */
    static int[] findErrorNums(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int sum = 0;
        int duplication = 0;
        for (int i : nums) {
            if (!set.add(i)) duplication = i;
            sum+=i;
        }
        return new int[] {duplication,(1+nums.length)*nums.length/2-(sum-duplication)};
    }
}
