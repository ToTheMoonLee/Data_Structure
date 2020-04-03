package practice.leetcode.easy;

import java.util.TreeSet;

/**
 * Given a non-empty array of integers, return the third maximum number in this array.
 * If it does not exist, return the maximum number. The time complexity must be in O(n).
 *
 * Example 1:
 * Input: [3, 2, 1]
 *
 * Output: 1
 *
 * Explanation: The third maximum is 1.
 * Example 2:
 * Input: [1, 2]
 *
 * Output: 2
 *
 * Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
 * Example 3:
 * Input: [2, 2, 3, 1]
 *
 * Output: 1
 *
 * Explanation: Note that the third maximum here means the third maximum distinct number.
 * Both numbers with value 2 are both considered as second maximum.
 */
public class $414ThirdMaxinumNumber {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 2, 3, 1};
        System.out.println(thirdMax(nums));
        System.out.println(thirdMax2(nums));
    }

    /**
     * their solution of this problem
     * @param nums
     * @return
     */
    static int thirdMax2(int[] nums) {
        Integer first = null;
        Integer second = null;
        Integer third = null;
        for (Integer n : nums) {
            if (n.equals(first) || n.equals(second) || n.equals(third)) continue;
            if (first == null || n > first) {
                third = second;
                second = first;
                first = n;
            } else if (second == null || n > second) {
                third = second;
                second = n;
            } else if (third == null || n > third) {
                third = n;
            }
        }
        if (third == null) return first;
        return third;
    }

    /**
     * their first solution of this problem
     * @param nums
     * @return
     */
    static int thirdMax(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for(int i=0; i<nums.length; i++) {
            set.add(nums[i]);
        }

        if(set.size() < 3)
            return set.last();

        set.remove(set.last());
        set.remove(set.last());
        return set.last(); //return highest
    }
}
