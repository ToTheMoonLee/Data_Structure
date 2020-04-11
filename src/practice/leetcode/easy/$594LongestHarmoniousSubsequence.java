package practice.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * We define a harmounious array as an array where the difference
 * between its maximum value and its minimum value is exactly 1.
 *
 * Now, given an integer array, you need to find the length
 * of its longest harmonious subsequence among all its possible subsequences.
 *
 * Example 1:
 *
 * Input: [1,3,2,2,5,2,3,7]
 * Output: 5
 * Explanation: The longest harmonious subsequence is [3,2,2,2,3].
 *
 *
 * Note: The length of the input array will not exceed 20,000.
 */
public class $594LongestHarmoniousSubsequence {

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,2,2,5,2,3,7};
        System.out.println(findLHS(nums));
        System.out.println(findLHS2(nums));
        System.out.println(findLHS3(nums));
    }

    /**
     * the official solution of this problem
     * @param nums
     * @return
     */
    static int findLHS3(int[] nums) {
        Arrays.sort(nums);
        int prev_count = 1, res = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = 1;
            if (i > 0 && nums[i] - nums[i - 1] == 1) {
                while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                    count++;
                    i++;
                }
                res = Math.max(res, count + prev_count);
                prev_count = count;
            } else {
                while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                    count++;
                    i++;
                }
                prev_count = count;
            }
        }
        return res;
    }

    /**
     * their faster solution of this problem
     * @param nums
     * @return
     */
    static int findLHS2(int[] nums) {
        Map<Long, Integer> map = new HashMap<>();
        for (long num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int result = 0;
        for (long key : map.keySet()) {
            if (map.containsKey(key + 1)) {
                result = Math.max(result, map.get(key + 1) + map.get(key));
            }
        }
        return result;
    }

    /**
     * my first solution of this problem
     * @param nums
     * @return
     */
    static int findLHS(int[] nums) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for (Integer i : nums) {
            map.put(i,map.getOrDefault(i,0)+1);
        }
        if (map.size() == 0 || map.size() == 1) return 0;
        int i=0;
        int pre = 0;
        int count = 0;
        for (Integer key : map.keySet()) {
            if (i++ == 0) {
                pre = key;
            } else {
                if (key - pre == 1) {
                    count = Math.max(map.get(key)+map.get(pre),count);
                }
                pre = key;
            }
        }
        return count;
    }
}
