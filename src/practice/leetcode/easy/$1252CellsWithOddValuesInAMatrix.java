package practice.leetcode.easy;

/**
 * Given n and m which are the dimensions of a matrix initialized
 * by zeros and given an array indices where indices[i] = [ri, ci].
 * For each pair of [ri, ci] you have to increment all cells in row ri and column ci by 1.
 *
 * Return the number of cells with odd values in the matrix after applying the increment to all indices.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: n = 2, m = 3, indices = [[0,1],[1,1]]
 * Output: 6
 * Explanation: Initial matrix = [[0,0,0],[0,0,0]].
 * After applying first increment it becomes [[1,2,1],[0,1,0]].
 * The final matrix will be [[1,3,1],[1,3,1]] which contains 6 odd numbers.
 * Example 2:
 *
 *
 * Input: n = 2, m = 2, indices = [[1,1],[0,0]]
 * Output: 0
 * Explanation: Final matrix = [[2,2],[2,2]]. There is no odd number in the final matrix.
 *
 *
 * Constraints:
 *
 * 1 <= n <= 50
 * 1 <= m <= 50
 * 1 <= indices.length <= 100
 * 0 <= indices[i][0] < n
 * 0 <= indices[i][1] < m
 */
public class $1252CellsWithOddValuesInAMatrix {

    public static void main(String[] args) {
        System.out.println(oddCells(2, 3, new int[][]{new int[]{0, 1}, new int[]{1, 1}}));
    }

    /**
     * their amazing solution of this problem
     * https://leetcode.com/problems/cells-with-odd-values-in-a-matrix/discuss/425100/JavaPython-3-2-methods%3A-time-O(m-*-n-%2B-L)-and-O(L)-codes-w-comment-and-analysis.
     */

    /**
     * my implement of this problem
     * @param n
     * @param m
     * @param indices
     * @return
     */
    static int oddCells(int n, int m, int[][] indices) {
        int[][] matrix = new int[n][m];
        for (int[] arr : indices) {
            int r = arr[0];
            int c = arr[1];
            for (int i=0;i<matrix[r].length;i++) {
                matrix[r][i]++;
            }
            for (int i=0;i<matrix.length;i++) {
                matrix[i][c]++;
            }
        }
        int ans = 0;
        for (int[] itemArr : matrix) {
            for (int item : itemArr) {
                if (item % 2 == 1) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
