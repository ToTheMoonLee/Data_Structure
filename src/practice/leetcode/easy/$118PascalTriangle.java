package practice.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 *
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 *
 * Example:
 *
 * Input: 5
 * Output:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 */
public class $118PascalTriangle {

    public static void main(String[] args) {
        System.out.println(generate(5));
        System.out.println(generate2(5));
    }

    /**
     * their brilliant solution of this problem
     * @param numRows
     * @return
     */
    static List<List<Integer>> generate2(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            row.add(0, 1);
            for (int j = 1; j < row.size() - 1; j++) {
                row.set(j, row.get(j) + row.get(j + 1));
            }
            result.add(new ArrayList<>(row));
        }
        return result;
    }

    /**
     * my solution of this problem
     * @param numRows
     * @return
     */
    static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i=0;i<numRows;i++) {
            List<Integer> item = new ArrayList<>();
            if (i == 0) {
                item.add(1);
            } else if (i == 1) {
                item.add(1);
                item.add(1);
            } else {
                List<Integer> temp = result.get(i-1);
                for (int j=0;j<=temp.size();j++) {
                    if (j==0) {
                        item.add(1);
                    } else if (j == temp.size()) {
                        item.add(1);
                    } else {
                        item.add(temp.get(j) + temp.get(j-1));
                    }
                }
            }
            result.add(item);
        }
        return result;
    }
}
