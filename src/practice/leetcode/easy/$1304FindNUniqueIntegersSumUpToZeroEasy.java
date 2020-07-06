package practice.leetcode.easy;

import practice.datastructure.util.PrintUtil;

/**
 * Given an integer n, return any array containing n unique integers such that they add up to 0.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 5
 * Output: [-7,-1,1,3,4]
 * Explanation: These arrays also are accepted [-5,-1,1,2,3] , [-3,-1,2,-2,4].
 * Example 2:
 *
 * Input: n = 3
 * Output: [-1,0,1]
 * Example 3:
 *
 * Input: n = 1
 * Output: [0]
 *
 *
 * Constraints:
 *
 * 1 <= n <= 1000
 */
public class $1304FindNUniqueIntegersSumUpToZeroEasy {

    public static void main(String[] args) {
        PrintUtil.printArr(sumZero(5));
    }

    /**
     * my solution of this problem,and I didn't take down other's solution of the problem
     * @param n
     * @return
     */
    static int[] sumZero(int n) {
        int[] ans = new int[n];
        for (int i=0,j=n-1;i<=j;i++,j--) {
            if (i == j) ans[i] = 0;
            else {
                ans[i] = -j;
                ans[j] = j;
            }
        }
        return ans;
    }
}
