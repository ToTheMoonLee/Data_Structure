package practice.leetcode.easy;

import practice.datastructure.util.PrintUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of distinct integers arr,
 * find all pairs of elements with the minimum absolute difference of any two elements.
 *
 * Return a list of pairs in ascending order(with respect to pairs), each pair [a, b] follows
 *
 * a, b are from arr
 * a < b
 * b - a equals to the minimum absolute difference of any two elements in arr
 *
 *
 * Example 1:
 *
 * Input: arr = [4,2,1,3]
 * Output: [[1,2],[2,3],[3,4]]
 * Explanation: The minimum absolute difference is 1. List all pairs with difference equal to 1 in ascending order.
 * Example 2:
 *
 * Input: arr = [1,3,6,10,15]
 * Output: [[1,3]]
 * Example 3:
 *
 * Input: arr = [3,8,-10,23,19,-4,-14,27]
 * Output: [[-14,-10],[19,23],[23,27]]
 *
 *
 * Constraints:
 *
 * 2 <= arr.length <= 10^5
 * -10^6 <= arr[i] <= 10^6
 */
public class $1200MinimumAbsoluteDifference {

    public static void main(String[] args) {
        PrintUtil.printList3(minimumAbsDifference(new int[]{3, 8, -10, 23, 19, -4, -14, 27}));
    }

    static List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        int a = Integer.MAX_VALUE;
        for (int i=1;i<arr.length;i++) {
            a = Math.min(a,arr[i] - arr[i-1]);
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i=1;i<arr.length;i++) {
            if (arr[i] - arr[i-1] == a) {
                List<Integer> temp = new ArrayList<>();
                temp.add(arr[i-1]);
                temp.add(arr[i]);
                ans.add(temp);
            }
        }
        return ans;
    }
}
