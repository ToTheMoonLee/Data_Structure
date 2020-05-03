package practice.leetcode.easy;

import java.util.Arrays;

/**
 * Given an array A of positive lengths,
 * return the largest perimeter of a triangle with non-zero area, formed from 3 of these lengths.
 *
 * If it is impossible to form any triangle of non-zero area, return 0.
 *
 *
 *
 * Example 1:
 *
 * Input: [2,1,2]
 * Output: 5
 * Example 2:
 *
 * Input: [1,2,1]
 * Output: 0
 * Example 3:
 *
 * Input: [3,2,3,4]
 * Output: 10
 * Example 4:
 *
 * Input: [3,6,2,3]
 * Output: 8
 *
 *
 * Note:
 *
 * 3 <= A.length <= 10000
 * 1 <= A[i] <= 10^6
 */
public class $976LargestPerimeterTriangle {

    public static void main(String[] args) {
        System.out.println(largestPerimeter(new int[]{3, 6, 2, 3}));
    }

    /**
     * their solution of this problem
     * @param A
     * @return
     */
    static int largestPerimeter(int[] A) {
        Arrays.sort(A);
        for (int i=A.length-1;i>=2;i--) {
            if (A[i-1]+A[i-2] > A[i]) {
                return A[i-1]+A[i-2]+A[i];
            }
        }
        return 0;
    }
}
