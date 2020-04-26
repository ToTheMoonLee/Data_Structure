package practice.leetcode.easy;

import practice.datastructure.util.PrintUtil;

/**
 * Given an array A of non-negative integers,
 * return an array consisting of all the even elements of A, followed by all the odd elements of A.
 *
 * You may return any answer array that satisfies this condition.
 *
 *
 *
 * Example 1:
 *
 * Input: [3,1,2,4]
 * Output: [2,4,3,1]
 * The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 *
 *
 * Note:
 *
 * 1 <= A.length <= 5000
 * 0 <= A[i] <= 5000
 */
public class $905SortArrayByParity {

    public static void main(String[] args) {
        int[] A = new int[]{3, 1, 2, 4};
        PrintUtil.printArr(sortArrayByParity(A));
        System.out.println("---------------------");
        PrintUtil.printArr(sortArrayByParity2(A));
    }

    /**
     * their space O(1) solution of this problem
     * @param A
     * @return
     */
    static int[] sortArrayByParity2(int[] A) {
        for (int i=0,j=0;j<A.length;j++) {
            if (A[j]%2==0) {
                int temp = A[j];
                A[j] = A[i];
                A[i++] = temp;
            }
        }
        return A;
    }

    /**
     * my solution of this problem
     * @param A
     * @return
     */
    static int[] sortArrayByParity(int[] A) {
        int i=0;
        int j=A.length-1;
        int[] ans = new int[A.length];
        for (int num : A) {
            if (num%2 == 0) {
                ans[i++] = num;
            } else {
                ans[j--] = num;
            }
        }
        return ans;
    }
}
