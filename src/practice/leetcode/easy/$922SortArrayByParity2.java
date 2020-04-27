package practice.leetcode.easy;

import practice.datastructure.util.PrintUtil;

/**
 * Given an array A of non-negative integers, half of the integers in A are odd, and half of the integers are even.
 *
 * Sort the array so that whenever A[i] is odd, i is odd; and whenever A[i] is even, i is even.
 *
 * You may return any answer array that satisfies this condition.
 *
 *
 *
 * Example 1:
 *
 * Input: [4,2,5,7]
 * Output: [4,5,2,7]
 * Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.
 *
 *
 * Note:
 *
 * 2 <= A.length <= 20000
 * A.length % 2 == 0
 * 0 <= A[i] <= 1000
 */
public class $922SortArrayByParity2 {

    public static void main(String[] args) {
        int[] A = new int[]{4, 2, 5, 7};
        PrintUtil.printArr(sortArrayByParityII(A));
        System.out.println("-------------------");
        PrintUtil.printArr(sortArrayByParityII2(A));
    }

    /**
     * their space O(1) solution of this problem
     * @param A
     * @return
     */
    static int[] sortArrayByParityII2(int[] A) {
        int i=0;
        int j=1;
        while (i<A.length&&j<A.length) {
            while (i<A.length && i%2==A[i]%2) i+=2;
            while (j<A.length && j%2==A[j]%2) j+=2;
            if (i<A.length && j<A.length) {
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }
            i+=2;
            j+=2;
        }
        return A;
    }

    /**
     * my solution of this problem
     * @param A
     * @return
     */
    static int[] sortArrayByParityII(int[] A) {
        int[] ans = new int[A.length];
        int k= 0;
        int j = 1;
        for (int i=0;i<A.length;i++) {
            if (A[i]%2==0) {
                ans[k]=A[i];
                k+=2;
            }
            else {
                ans[j] = A[i];
                j+=2;
            }
        }
        return ans;
    }
}
