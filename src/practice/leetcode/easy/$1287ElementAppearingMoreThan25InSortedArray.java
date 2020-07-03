package practice.leetcode.easy;

import java.util.HashMap;

/**
 * Given an integer array sorted in non-decreasing order,
 * there is exactly one integer in the array that occurs more than 25% of the time.
 *
 * Return that integer.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [1,2,2,6,6,6,6,7,10]
 * Output: 6
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 10^4
 * 0 <= arr[i] <= 10^5
 */
public class $1287ElementAppearingMoreThan25InSortedArray {

    public static void main(String[] args) {
        System.out.println(findSpecialInteger(new int[]{1,2,2,6,6,6,6,7,10}));
        System.out.println(findSpecialInteger2(new int[]{1,2,2,6,6,6,6,7,10}));
    }

    /**
     * my second solution of this problem
     * @param arr
     * @return
     */
    static int findSpecialInteger2(int[] arr) {
        int t = arr.length/4;
        for (int i=0;i<=t;i++) {
            int j=i+t;
            while (j<arr.length) {
                if (arr[j] == arr[j-t]) return arr[j];
                j+=t;
            }
        }
        return 0;
    }

    /**
     * my first solution of this problem
     * @param arr
     * @return
     */
    static int findSpecialInteger(int[] arr) {
        int threshold = arr.length/4;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i : arr) {
            int count = map.getOrDefault(i,0) + 1;
            if (count > threshold) return i;
            map.put(i,count);
        }
        return 0;
    }
}
