package practice.leetcode.easy;

import practice.datastructure.util.PrintUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a m * n matrix of distinct numbers, return all lucky numbers in the matrix in any order.
 *
 * A lucky number is an element of the matrix such that it is the minimum element
 * in its row and maximum in its column.
 *
 *
 *
 * Example 1:
 *
 * Input: matrix = [[3,7,8],[9,11,13],[15,16,17]]
 * Output: [15]
 * Explanation: 15 is the only lucky number since it is the minimum in its row and the maximum in its column
 * Example 2:
 *
 * Input: matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
 * Output: [12]
 * Explanation: 12 is the only lucky number since it is the minimum in its row and the maximum in its column.
 * Example 3:
 *
 * Input: matrix = [[7,8],[1,2]]
 * Output: [7]
 *
 *
 * Constraints:
 *
 * m == mat.length
 * n == mat[i].length
 * 1 <= n, m <= 50
 * 1 <= matrix[i][j] <= 10^5.
 * All elements in the matrix are distinct.
 */
public class $1380LuckyNumbersInAMatrix {

    public static void main(String[] args) {
        int[][] maxtrix = new int[][]{new int[]{3, 7, 8}, new int[]{9, 11, 13}, new int[]{15, 16, 17}};
        PrintUtil.printList2(luckyNumbers(maxtrix));
        PrintUtil.printList2(luckyNumbers2(maxtrix));
    }

    /**
     * their straightforward and faster solution
     * @param matrix
     * @return
     */
    static List<Integer> luckyNumbers2(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();

        for (int row = 0; row < matrix.length; row++) {
            int minCol = minColInRow(matrix, row);
            int value = matrix[row][minCol];
            if (checkIfMaxInCol(matrix, minCol, value)) {
                result.add(value);
            }
        }

        return result;
    }

    static int minColInRow(int[][] matrix, int row) {
        int minIndex = 0, min = matrix[row][minIndex];
        for (int col = 1; col < matrix[row].length; col++) {
            if (matrix[row][col] < min) {
                min = matrix[row][col];
                minIndex = col;
            }
        }
        return minIndex;
    }

    static boolean checkIfMaxInCol(int[][] matrix, int col, int value) {
        for (int row = 0; row < matrix.length; row++) {
            if (matrix[row][col] > value) return false;
        }
        return true;
    }

    /**
     * my first solution of this problem
     * @param matrix
     * @return
     */
    static List<Integer> luckyNumbers (int[][] matrix) {
        int[] minTemp = new int[50];
        int[] maxTemp = new int[50];
        for (int i=0;i<matrix.length;i++) {
            int num = matrix[i][0];
            int minPos = 0;
            for (int j=0;j<matrix[i].length;j++) {
                if (matrix[i][j]<num) {
                    num = matrix[i][j];
                    minPos = j;
                }
                maxTemp[j] = Math.max(maxTemp[j],matrix[i][j]);
            }
            if (num > minTemp[minPos]) {
                minTemp[minPos] = num;
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i=0;i<minTemp.length;i++) {
            if (minTemp[i]!=0 && minTemp[i] == maxTemp[i]) {
                result.add(minTemp[i]);
            }
        }
        return result;
    }
}
