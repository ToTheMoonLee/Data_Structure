package practice.leetcode.easy;

import practice.datastructure.util.PrintUtil;

/**
 * Given an array arr, replace every element in that array
 * with the greatest element among the elements to its right, and replace the last element with -1.
 *
 * After doing so, return the array.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [17,18,5,4,6,1]
 * Output: [18,6,6,6,1,-1]
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 10^4
 * 1 <= arr[i] <= 10^5
 */
public class $1299ReplaceElementsWithGreatestElementOnRightSide {

    public static void main(String[] args) {
        PrintUtil.printArr(replaceElements(new int[]{17,18,5,4,6,1}));
        System.out.println("-------------------------");
        PrintUtil.printArr(replaceElements2(new int[]{17,18,5,4,6,1}));
    }

    /**
     * their concise solution of this problem
     * @param A
     * @return
     */
    static int[] replaceElements2(int[] A) {
        for (int i = A.length - 1, mx = -1; i >= 0; --i)
            mx = Math.max(A[i], A[i] = mx);
        return A;
    }

    /**
     * my solution of this problem
     * @param arr
     * @return
     */
    static int[] replaceElements(int[] arr) {
        int[] ans = new int[arr.length];
        ans[ans.length-1] = -1;
        int max = Integer.MIN_VALUE;
        for (int i=arr.length-2;i>=0;i--) {
            max = Math.max(max,arr[i+1]);
            ans[i] = max;
        }
        return ans;
    }
}
