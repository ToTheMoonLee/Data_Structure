package practice.leetcode.easy;

import practice.datastructure.util.PrintUtil;

import java.util.HashSet;
import java.util.Iterator;

/**
 * Given two arrays, write a function to compute their intersection.
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 * Example 2:
 *
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 * Note:
 *
 * Each element in the result must be unique.
 * The result can be in any order.
 */
public class $349IntersectionOfTwoArrays {

    public static void main(String[] args) {
        int[] nums1 = new int[]{4, 9, 5};
        int[] nums2 = new int[]{9,4,9,8,4};

        PrintUtil.printArr(intersection(nums1, nums2));
    }

    /**
     * my solution of this problem
     * @param nums1
     * @param nums2
     * @return
     */
    static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        for (Integer i : nums1) {
            set.add(i);
        }
        for (Integer i : nums2) {
            if (set.contains(i)) set2.add(i);
        }
        int[] result = new int[set2.size()];
        int i=0;
        Iterator<Integer> it = set2.iterator();
        while (it.hasNext()) {
            result[i++] = it.next();
        }
        return result;
    }
}
