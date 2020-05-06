package practice.leetcode.easy;

import practice.datastructure.util.PrintUtil;

/**
 * We have an array A of integers, and an array queries of queries.
 *
 * For the i-th query val = queries[i][0], index = queries[i][1],
 * we add val to A[index].  Then, the answer to the i-th query is the sum of the even values of A.
 *
 * (Here, the given index = queries[i][1] is a 0-based index, and each query permanently modifies the array A.)
 *
 * Return the answer to all queries.  Your answer array should have answer[i] as the answer to the i-th query.
 *
 *
 *
 * Example 1:
 *
 * Input: A = [1,2,3,4], queries = [[1,0],[-3,1],[-4,0],[2,3]]
 * Output: [8,6,2,4]
 * Explanation:
 * At the beginning, the array is [1,2,3,4].
 * After adding 1 to A[0], the array is [2,2,3,4], and the sum of even values is 2 + 2 + 4 = 8.
 * After adding -3 to A[1], the array is [2,-1,3,4], and the sum of even values is 2 + 4 = 6.
 * After adding -4 to A[0], the array is [-2,-1,3,4], and the sum of even values is -2 + 4 = 2.
 * After adding 2 to A[3], the array is [-2,-1,3,6], and the sum of even values is -2 + 6 = 4.
 *
 *
 * Note:
 *
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * 1 <= queries.length <= 10000
 * -10000 <= queries[i][0] <= 10000
 * 0 <= queries[i][1] < A.length
 */
public class $985SumOfEvenNumbersAfterQueries {

    public static void main(String[] args) {
        PrintUtil.printArr(sumEvenAfterQueries(new int[]{1, 2, 3, 4}, new int[][]{new int[]{1, 0},
                new int[]{-3, 1}, new int[]{-4, 0}, new int[]{2, 3}}));
        System.out.println("----------------------------------");
        PrintUtil.printArr(sumEvenAfterQueries2(new int[]{1, 2, 3, 4}, new int[][]{new int[]{1, 0},
                new int[]{-3, 1}, new int[]{-4, 0}, new int[]{2, 3}}));
    }

    /**
     * their solution of this problem
     * @param A
     * @param queries
     * @return
     */
    static int[] sumEvenAfterQueries2(int[] A, int[][] queries) {
        int[] ans = new int[queries.length];
        int before = 0;
        for (int i=0;i<A.length;i++) {
            if (A[i]%2==0) {
                before+=A[i];
            }
        }
        for (int i=0;i<queries.length;i++) {
            int index = queries[i][1];
            int val = queries[i][0];
            if (A[index]%2==0) before = before-A[index];
            A[index]+=val;
            if (A[index]%2==0) before+=A[index];
            ans[i]= before;
        }
        return ans;
    }

    /**
     * my first solution of this problem
     * @param A
     * @param queries
     * @return
     */
    static int[] sumEvenAfterQueries(int[] A, int[][] queries) {
        int[] ans = new int[queries.length];
        int before = 0;
        for (int i=0;i<A.length;i++) {
            if (A[i]%2==0) {
                before+=A[i];
            }
        }
        for (int i=0;i<queries.length;i++) {
            if (A[queries[i][1]]%2==0 && (A[queries[i][1]] + queries[i][0])%2==0) {
                ans[i]= before + queries[i][0];
            } else if (A[queries[i][1]]%2==0 && (A[queries[i][1]] + queries[i][0])%2!=0) {
                ans[i]= before - A[queries[i][1]];
            } else if (A[queries[i][1]]%2!=0 && (A[queries[i][1]] + queries[i][0])%2==0) {
                ans[i] = before + A[queries[i][1]] + queries[i][0];
            } else {
                ans[i] = before;
            }
            before = ans[i];
            A[queries[i][1]]+=queries[i][0];
        }
        return ans;
    }
}
