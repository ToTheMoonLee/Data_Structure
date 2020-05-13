package practice.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a triangle, find the minimum path sum from top to bottom.
 * Each step you may move to adjacent numbers on the row below.
 *
 * For example, given the following triangle
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 *
 * Note:
 *
 * Bonus point if you are able to do this using only O(n) extra space,
 * where n is the total number of rows in the triangle.
 */
public class $120Triangle {

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> temp1 = new ArrayList<>();
        temp1.add(2);
        List<Integer> temp2 = new ArrayList<>();
        temp2.add(3);
        temp2.add(4);
        List<Integer> temp3 = new ArrayList<>();
        temp3.add(6);
        temp3.add(5);
        temp3.add(7);
        List<Integer> temp4 = new ArrayList<>();
        temp4.add(4);
        temp4.add(1);
        temp4.add(8);
        temp4.add(3);
        triangle.add(temp1);
        triangle.add(temp2);
        triangle.add(temp3);
        triangle.add(temp4);

        System.out.println(minimumTotal(triangle));
        System.out.println(minimumTotal2(triangle));
        System.out.println(minimumTotal3(triangle));
    }

    /**
     * their concise and amazing solution of this problem
     * @param triangle
     * @return
     */
    static int minimumTotal3(List<List<Integer>> triangle) {
        int[] A = new int[triangle.size()+1];
        for(int i=triangle.size()-1;i>=0;i--){
            for(int j=0;j<triangle.get(i).size();j++){
                A[j] = Math.min(A[j],A[j+1])+triangle.get(i).get(j);
            }
        }
        return A[0];
    }

    /**
     * my second solution of this problem
     * @param triangle
     * @return
     */
    static int minimumTotal2(List<List<Integer>> triangle) {
        int[][] dp = new int[triangle.size()][triangle.get(triangle.size()-1).size()];
        dp[0][0] = triangle.get(0).get(0);
        for (int i=1;i<triangle.size();i++) {
            List<Integer> temp = triangle.get(i);
            for (int j=0;j<temp.size();j++) {
                if (j==0) {
                    dp[i][j] = temp.get(j) + dp[i-1][j];
                } else if (j==temp.size()-1) {
                    dp[i][j] = temp.get(j) + dp[i-1][j-1];
                } else {
                    int n = Math.min(dp[i-1][j],dp[i-1][j-1]);
                    dp[i][j] = temp.get(j) + n;
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i: dp[dp.length-1]) {
            ans = Math.min(ans,i);
        }
        return ans;
    }

    /**
     * my first solution of this problem
     * @param triangle
     * @return
     */
    static int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0 || triangle.get(0).size()==0) return -1;
        List<List<Integer>> dp = new ArrayList<>();
        List<Integer> level = new ArrayList<>();
        level.add(triangle.get(0).get(0));
        dp.add(level);
        for (int i=1;i<triangle.size();i++) {
            List<Integer> temp = new ArrayList<>();
            List<Integer> lev = triangle.get(i);
            for (int j=0;j<lev.size();j++) {
                if (j==0) {temp.add(dp.get(i-1).get(j) + lev.get(j));}
                else if (j==lev.size()-1) {
                    temp.add(dp.get(i-1).get(j-1) + lev.get(j));
                } else {
                    int n = Math.min(dp.get(i-1).get(j),dp.get(i-1).get(j-1));
                    temp.add(n+lev.get(j));
                }
            }
            dp.add(temp);
        }
        int ans = Integer.MAX_VALUE;
        for (int i: dp.get(dp.size()-1)) {
            ans = Math.min(ans,i);
        }
        return ans;
    }
}
