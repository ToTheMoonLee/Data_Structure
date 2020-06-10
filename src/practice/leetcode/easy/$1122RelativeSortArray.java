package practice.leetcode.easy;

import practice.datastructure.util.PrintUtil;

import java.util.TreeMap;

/**
 * Given two arrays arr1 and arr2, the elements of arr2 are distinct,
 * and all elements in arr2 are also in arr1.
 * <p>
 * Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2.
 * Elements that don't appear in arr2 should be placed at the end of arr1 in ascending order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * Output: [2,2,2,1,4,3,3,9,6,7,19]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * arr1.length, arr2.length <= 1000
 * 0 <= arr1[i], arr2[i] <= 1000
 * Each arr2[i] is distinct.
 * Each arr2[i] is in arr1.
 */
public class $1122RelativeSortArray {

    public static void main(String[] args) {
        int[] arr1 = new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] arr2 = new int[]{2, 1, 4, 3, 9, 6};
        PrintUtil.printArr(relativeSortArray(arr1, arr2));
        PrintUtil.printArr(relativeSortArray2(arr1, arr2));
    }

    /**
     * my second solution of this problem
     *
     * @param arr1
     * @param arr2
     * @return
     */
    static int[] relativeSortArray2(int[] arr1, int[] arr2) {
        int[] nums = new int[1001];
        for (int i : arr1) {
            nums[i]++;
        }
        int i = 0;
        for (int j : arr2) {
            while (nums[j]-- > 0) {
                arr1[i++] = j;
            }
        }
        for (int j = 0; j < nums.length; j++) {
            while (nums[j]-- > 0) {
                arr1[i++] = j;
            }
        }
        return arr1;
    }

    /**
     * my first solution of this problem
     *
     * @param arr1
     * @param arr2
     * @return
     */
    static int[] relativeSortArray(int[] arr1, int[] arr2) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i : arr1) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int i = 0;
        for (int j : arr2) {
            int k = map.get(j);
            map.put(j, 0);
            while (k-- > 0) {
                arr1[i++] = j;
            }
        }
        for (int key : map.keySet()) {
            int k = map.get(key);
            map.put(key, 0);
            while (k-- > 0) {
                arr1[i++] = key;
            }
        }
        return arr1;
    }
}
