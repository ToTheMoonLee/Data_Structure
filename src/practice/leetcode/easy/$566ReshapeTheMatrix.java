package practice.leetcode.easy;

import practice.datastructure.util.PrintUtil;

/**
 * In MATLAB, there is a very useful function called 'reshape',
 * which can reshape a matrix into a new one with different size but keep its original data.
 *
 * You're given a matrix represented by a two-dimensional array,
 * and two positive integers r and c representing the row number and column number of the wanted reshaped matrix,
 * respectively.
 *
 * The reshaped matrix need to be filled with all the elements of the original matrix
 * in the same row-traversing order as they were.
 *
 * If the 'reshape' operation with given parameters is possible and legal,
 * output the new reshaped matrix; Otherwise, output the original matrix.
 *
 * Example 1:
 * Input:
 * nums =
 * [[1,2],
 *  [3,4]]
 * r = 1, c = 4
 * Output:
 * [[1,2,3,4]]
 * Explanation:
 * The row-traversing of nums is [1,2,3,4]. The new reshaped matrix is a 1 * 4 matrix,
 * fill it row by row by using the previous list.
 * Example 2:
 * Input:
 * nums =
 * [[1,2],
 *  [3,4]]
 * r = 2, c = 4
 * Output:
 * [[1,2],
 *  [3,4]]
 * Explanation:
 * There is no way to reshape a 2 * 2 matrix to a 2 * 4 matrix. So output the original matrix.
 * Note:
 * The height and width of the given matrix is in range [1, 100].
 * The given r and c are all positive.
 */
public class $566ReshapeTheMatrix {

    public static void main(String[] args) {
        int[][] nums = new int[][]{new int[]{1,2,3,4}};
        int[][] ints = matrixReshape(nums, 2, 2);
        int[][] ints1 = matrixReshape2(nums, 2, 2);
        PrintUtil.printArr(ints);
        System.out.println("-------");
        PrintUtil.printArr(ints1);
    }

    /**
     * their clever solution of this problem
     * @param nums
     * @param r
     * @param c
     * @return
     */
    static int[][] matrixReshape2(int[][] nums, int r, int c) {
        int n = nums.length, m = nums[0].length;
        if (r*c != n*m) return nums;
        int[][] res = new int[r][c];
        for (int i=0;i<r*c;i++)
            res[i/c][i%c] = nums[i/m][i%m];
        return res;
    }


    /**
     * my solution of this problem
     * @param nums
     * @param r
     * @param c
     * @return
     */
    static int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums.length == 0 || nums[0].length == 0) return nums;
        int size = nums.length*nums[0].length;
        if (r * c != size) return nums;
        int k=0,l=0;
        int[][] result = new int[r][c];
        for (int i=0;i<nums.length;i++) {
            for (int j=0;j<nums[i].length;j++) {
                if (k==c) {
                    k = 0;
                    l++;
                }
                result[l][k++] = nums[i][j];
            }
        }
        return result;
    }
}
