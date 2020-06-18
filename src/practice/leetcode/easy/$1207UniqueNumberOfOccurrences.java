package practice.leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Given an array of integers arr,
 * write a function that returns true if and
 * only if the number of occurrences of each value in the array is unique.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [1,2,2,1,1,3]
 * Output: true
 * Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.
 * Example 2:
 *
 * Input: arr = [1,2]
 * Output: false
 * Example 3:
 *
 * Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
 * Output: true
 */
public class $1207UniqueNumberOfOccurrences {

    public static void main(String[] args) {
        System.out.println(uniqueOccurrences(new int[]{-3, 0, 1, -3, 1, 1, 1, -3, 10, 0}));
        System.out.println(uniqueOccurrences2(new int[]{-3, 0, 1, -3, 1, 1, 1, -3, 10, 0}));
    }

    /**
     * their solution of this problem
     * @param arr
     * @return
     */
    static boolean uniqueOccurrences2(int[] arr) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int a : arr)
            count.put(a, 1 + count.getOrDefault(a, 0));
        return count.size() == new HashSet<>(count.values()).size();
    }

    /**
     * my solution of this problem
     * @param arr
     * @return
     */
    static boolean uniqueOccurrences(int[] arr) {
        int[] nums = new int[2001];
        for (int i=0;i<arr.length;i++) {
            nums[arr[i]+1000]++;
        }
        boolean[] occurs = new boolean[1001];
        for (int i=0;i<nums.length;i++) {
            if (nums[i]!=0 && occurs[nums[i]]) {
                return false;
            }
            occurs[nums[i]] = true;
        }
        return true;
    }
}
