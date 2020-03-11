package practice.leetcode.easy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
 * <p>
 * Note that the row index starts from 0.
 * <p>
 * <p>
 * In Pascal's triangle, each number is the sum of the two numbers directly above it.
 * <p>
 * Example:
 * <p>
 * Input: 3
 * Output: [1,3,3,1]
 */
public class $119PascalTriangle2 {

    public static void main(String[] args) {
        System.out.println(getRow(6));
        System.out.println(getRow2(6));
    }

    /**
     * their wonderful solution of this problem
     *
     * Here is my faster code, beats 99.9%. O(k) Time. The idea deprives from binomial factor.
     * For example, rowIndex = 6.
     * 1st: 1=1
     * 2nd: 6= 6 / 1
     * 3rd: 15=6x5 / (1x2)
     * 4th: 20=6x5x4 / (1x2x3)
     * 5th: 15=6x5x4x3 / (1x2x3x4)
     * 6th: 6 =6x5x4x3x2 / (1x2x3x4x5)
     * 7th: 1 =6x5x4x3x2x1 / (1x2x3x4x5x6)
     */
    static List<Integer> getRow2(int rowIndex) {
        List<Integer> res = new LinkedList<>();
        res.add(1);
        if (rowIndex == 0) return res;
        int t = rowIndex, b = 1;
        long cur = 1;
        for (int i = 1; i < rowIndex + 1; i++) {
            cur = cur * t;
            cur = cur / b;
            res.add((int) cur);
            t--;
            b++;
        }
        return res;
    }

    /**
     * my solution of this problem
     *
     * @param rowIndex
     * @return
     */
    static List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        for (int i = 0; i < rowIndex + 1; i++) {
            row.add(0, 1);
            for (int j = 1; j < row.size() - 1; j++) {
                row.set(j, row.get(j) + row.get(j + 1));
            }
        }
        return row;
    }
}
