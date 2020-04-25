package practice.leetcode.easy;

import practice.datastructure.util.PrintUtil;

/**
 * Given a matrix A, return the transpose of A.
 *
 * The transpose of a matrix is the matrix flipped over it's main diagonal,
 * switching the row and column indices of the matrix.
 *
 *
 *
 *
 *
 * Example 1:
 *
 * Input: [[1,2,3],[4,5,6],[7,8,9]]
 * Output: [[1,4,7],[2,5,8],[3,6,9]]
 * Example 2:
 *
 * Input: [[1,2,3],[4,5,6]]
 * Output: [[1,4],[2,5],[3,6]]
 *
 *
 * Note:
 *
 * 1 <= A.length <= 1000
 * 1 <= A[0].length <= 1000
 */
public class $867TransposeMatrix {

    public static void main(String[] args) {
        PrintUtil.printArr(transpose(new int[][]{new int[]{1, 2, 3}, new int[]{4, 5, 6}}));
    }

    /**
     * my solution of this problem
     * @param A
     * @return
     */
    static int[][] transpose(int[][] A) {
        int[][] result = new int[A[0].length][A.length];
        for (int i=0;i<A.length;i++) {
            for (int j=0;j<A[i].length;j++) {
                result[j][i] = A[i][j];
            }
        }
        return result;
    }
}
