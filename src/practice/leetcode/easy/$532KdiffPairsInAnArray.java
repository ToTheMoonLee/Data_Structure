package practice.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Given an array of integers and an integer k, you need to find the number of unique k-diff pairs in the array.
 * Here a k-diff pair is defined as an integer pair (i, j),
 * where i and j are both numbers in the array and their absolute difference is k.
 *
 * Example 1:
 * Input: [3, 1, 4, 1, 5], k = 2
 * Output: 2
 * Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
 * Although we have two 1s in the input, we should only return the number of unique pairs.
 * Example 2:
 * Input:[1, 2, 3, 4, 5], k = 1
 * Output: 4
 * Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).
 * Example 3:
 * Input: [1, 3, 1, 5, 4], k = 0
 * Output: 1
 * Explanation: There is one 0-diff pair in the array, (1, 1).
 * Note:
 * The pairs (i, j) and (j, i) count as the same pair.
 * The length of the array won't exceed 10,000.
 * All the integers in the given input belong to the range: [-1e7, 1e7].
 */
public class $532KdiffPairsInAnArray {

    public static void main(String[] args) {
        System.out.println(findPairs(new int[]{3, 1, 4, 1, 5}, 2));
        System.out.println(findPairs2(new int[]{3, 1, 4, 1, 5}, 2));
        System.out.println(findPairs3(new int[]{3, 1, 4, 1, 5}, 2));
    }

    /**
     * their faster solution of this problem,beat 96.56%
     * @param nums
     * @param k
     * @return
     */
    static int findPairs3(int[] nums, int k) {
        if (nums.length < 2 || k < 0) {
            return 0;
        }
        int count = 0;
        Arrays.sort(nums);
        int right = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            right = Math.max(right, i + 1);
            while (right < nums.length) {
                if (nums[right] - k == nums[i]) {
                    count++;
                    break;
                } else if (nums[right] - k < nums[i]) {
                    right++;
                } else {
                    break;
                }
            }
        }
        return count;
    }


    /**
     * their solution of this problem ,beat 78.96%
     * @param nums
     * @param k
     * @return
     */
    static int findPairs2(int[] nums, int k) {
        if (k < 0) return 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        int result = 0;
        for (int i=0;i<nums.length;i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for (Integer key: map.keySet()) {
            if (k == 0) {
                if (map.get(key) > 1) {
                    result++;
                }
            } else {
                if (map.containsKey(key+k)) {
                    result++;
                }
            }

        }
        return result;
    }


    /**
     * my solution of this problem, beat only 20%
     * @param nums
     * @param k
     * @return
     */
    static int findPairs(int[] nums, int k) {
        if (k < 0) return 0;
        HashMap<Integer,Integer> map1 = new HashMap<>();
        HashMap<Integer,Integer> map2 = new HashMap<>();
        int result = 0;
        if (k == 0) {
            for (int i=0;i<nums.length;i++) {
                map1.put(nums[i],map1.getOrDefault(nums[i],0)+1);
            }
            for (Integer key: map1.keySet()) {
                if (map1.get(key) > 1) {
                    result++;
                }
            }
            return result;
        }
        for (int i=0;i<nums.length;i++) {
            map1.put(nums[i],nums[i]+k);
            map2.put(nums[i],nums[i]-k);
        }
        for (int i=0;i<nums.length;i++) {
            if (map1.get(nums[i]-k)!=null && map1.get(nums[i]-k)==nums[i]) {
                result++;
                map1.remove(nums[i]-k);
                map2.remove(nums[i]);
            }
            if (map2.get(nums[i]+k) != null && map2.get(nums[i]+k) == nums[i]) {
                result++;
                map2.remove(nums[i]+k);
                map1.remove(nums[i]);
            }
        }
        return result;
    }
}
