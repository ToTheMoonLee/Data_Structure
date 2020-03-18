package practice.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Given an array of integers that is already sorted in ascending order,
 * find two numbers such that they add up to a specific target number.
 * <p>
 * The function twoSum should return indices of the two numbers such that they add up to the target,
 * where index1 must be less than index2.
 * <p>
 * Note:
 * <p>
 * Your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution and you may not use the same element twice.
 * Example:
 * <p>
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 */
public class $167TwoSum2 {

    public static void main(String[] args) {
        int[] numbers = new int[]{2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(numbers, target)));
        System.out.println(Arrays.toString(twoSum2(numbers, target)));
    }

    /**
     * their solution of this problem
     * @param numbers
     * @param target
     * @return
     */
    static int[] twoSum2(int[] numbers, int target) {
        int[] result = new int[2];
        if (numbers == null || numbers.length < 1) return result;
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            if (numbers[left] + numbers[right] == target) {
                result[0] = left + 1;
                result[1] = right + 1;
                break;
            }
            if (numbers[left] + numbers[right] > target) {
                right--;
            } else {
                left++;
            }
        }
        return result;
    }

    /**
     * my solution of this problem
     * @param numbers
     * @param target
     * @return
     */
    static int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> targetMap = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (targetMap.get(numbers[i]) == null) {
                targetMap.put(target - numbers[i], i + 1);
            } else {
                return new int[]{targetMap.get(numbers[i]), i + 1};
            }
        }
        return new int[]{};
    }
}
