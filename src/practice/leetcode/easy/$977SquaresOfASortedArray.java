package practice.leetcode.easy;

import practice.datastructure.util.PrintUtil;

import java.util.Arrays;

/**
 * Given an array of integers A sorted in non-decreasing order,
 * return an array of the squares of each number, also in sorted non-decreasing order.
 *
 *
 *
 * Example 1:
 *
 * Input: [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 * Example 2:
 *
 * Input: [-7,-3,2,3,11]
 * Output: [4,9,9,49,121]
 *
 *
 * Note:
 *
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * A is sorted in non-decreasing order.
 */
public class $977SquaresOfASortedArray {

    public static void main(String[] args) {
        PrintUtil.printArr(sortedSquares(new int[]{-4,-1,0,3,10}));
        System.out.println("---------------------------------");
        PrintUtil.printArr(sortedSquares2(new int[]{-4,-1,0,3,10}));
        System.out.println("---------------------------------");
        PrintUtil.printArr(sortedSquares3(new int[]{-4,-1,0,3,10}));
    }

    /**
     * their solution of this problem
     * @param A
     * @return
     */
    static int[] sortedSquares3(int[] A) {
        int[] ans = new int[A.length];
        int i=0;
        int j= A.length-1;
        int k = ans.length-1;
        while (k>=0) {
            if (Math.abs(A[i]) > Math.abs(A[j])) {
                ans[k--] = A[i]*A[i++];
            } else {
                ans[k--] = A[j]*A[j--];
            }
        }
        return ans;
    }

    /**
     * my second solution of this problem
     * @param A
     * @return
     */
    static int[] sortedSquares2(int[] A) {
        int[] ans = new int[A.length];
        int i = 0;
        while (i<A.length && A[i]<0) i++;
        int j = i-1;
        int k=0;
        while (i<A.length && j>=0) {
            if (A[i]*A[i] < A[j]*A[j]) {
                ans[k++] = A[i]*A[i];
                i++;
            } else {
                ans[k++] = A[j]*A[j];
                j--;
            }
        }
        while (i<A.length) ans[k++] = A[i]*A[i++];
        while (j>=0) ans[k++] = A[j]*A[j--];
        return ans;
    }

    /**
     * my first solution of this problem
     * @param A
     * @return
     */
    static int[] sortedSquares(int[] A) {
        for (int i=0;i<A.length;i++) {
            A[i] = A[i]*A[i];
        }
        Arrays.sort(A);
        return A;
    }
}
