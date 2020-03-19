package practice.leetcode.easy;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Given an array of size n, find the majority element.
 * The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 * <p>
 * You may assume that the array is non-empty and the majority element always exist in the array.
 * <p>
 * Example 1:
 * <p>
 * Input: [3,2,3]
 * Output: 3
 * Example 2:
 * <p>
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 */
public class $169MajorityElement {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorityElement(nums));
        System.out.println(majorityElement2(nums));
        System.out.println(majorityElement3(nums));
    }

    /**
     * their very amazing solution of this problem
     *
     * @param nums
     * @return
     */
    static int majorityElement3(int[] nums) {
        int count = 1;
        int cur = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                cur = nums[i];
                count++;
            } else if (cur == nums[i]) {
                count++;
            } else {
                count--;
            }
        }
        return cur;
    }

    /**
     * their amazing solution one of this problem
     *
     * @param nums
     * @return
     */
    static int majorityElement2(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    /**
     * my solution of this problem
     *
     * @param nums
     * @return
     */
    static int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == null) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
            if (map.get(nums[i]) > nums.length / 2) {
                return nums[i];
            }
        }
        return 0;
    }
}
