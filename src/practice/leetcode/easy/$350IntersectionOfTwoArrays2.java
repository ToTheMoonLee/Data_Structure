package practice.leetcode.easy;

import practice.datastructure.util.PrintUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Given two arrays, write a function to compute their intersection.
 * <p>
 * Example 1:
 * <p>
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 * Example 2:
 * <p>
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [4,9]
 * Note:
 * <p>
 * Each element in the result should appear as many times as it shows in both arrays.
 * The result can be in any order.
 * Follow up:
 * <p>
 * What if the given array is already sorted? How would you optimize your algorithm?
 * What if nums1's size is small compared to nums2's size? Which algorithm is better?
 * What if elements of nums2 are stored on disk, and the memory is limited
 * such that you cannot load all elements into the memory at once?
 */
public class $350IntersectionOfTwoArrays2 {

    public static void main(String[] args) {
        int[] nums1 = new int[]{4, 9, 5};
        int[] nums2 = new int[]{9, 4, 9, 8, 4};
        PrintUtil.printArr(intersect(nums1, nums2));
        System.out.println();
        System.out.println("------------------------");
        System.out.println();
        PrintUtil.printArr(intersect2(nums1, nums2));
    }

    /**
     * their solution of this problem,sorting the array first.
     *
     * @param nums1
     * @param nums2
     * @return
     */
    static int[] intersect2(int[] nums1, int[] nums2) {
        List<Integer> res = new ArrayList<Integer>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        for (int i = 0, j = 0; i < nums1.length && j < nums2.length; ) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] == nums2[j]) {
                res.add(nums1[i]);
                i++;
                j++;
            } else {
                j++;
            }
        }
        int[] result = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            result[i] = res.get(i);
        }
        return result;
    }

    /**
     * my solution of this problem
     *
     * @param nums1
     * @param nums2
     * @return
     */
    static int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList();
        for (int i = 0; i < nums1.length; i++) {
            Integer temp = map.get(nums1[i]);
            if (temp == null) {
                map.put(nums1[i], 1);
            } else {
                map.put(nums1[i], temp + 1);
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            Integer temp = map.get(nums2[i]);
            if (temp != null && temp > 0) {
                map.put(nums2[i], temp - 1);
                list.add(nums2[i]);
            }
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
