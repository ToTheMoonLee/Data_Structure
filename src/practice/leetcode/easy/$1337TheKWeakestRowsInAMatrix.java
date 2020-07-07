package practice.leetcode.easy;

import practice.datastructure.util.PrintUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

/**
 * Given a m * n matrix mat of ones (representing soldiers) and zeros (representing civilians),
 * return the indexes of the k weakest rows in the matrix ordered from the weakest to the strongest.
 *
 * A row i is weaker than row j, if the number of soldiers
 * in row i is less than the number of soldiers in row j,
 * or they have the same number of soldiers but i is less than j.
 * Soldiers are always stand in the frontier of a row, that is,
 * always ones may appear first and then zeros.
 *
 *
 *
 * Example 1:
 *
 * Input: mat =
 * [[1,1,0,0,0],
 *  [1,1,1,1,0],
 *  [1,0,0,0,0],
 *  [1,1,0,0,0],
 *  [1,1,1,1,1]],
 * k = 3
 * Output: [2,0,3]
 * Explanation:
 * The number of soldiers for each row is:
 * row 0 -> 2
 * row 1 -> 4
 * row 2 -> 1
 * row 3 -> 2
 * row 4 -> 5
 * Rows ordered from the weakest to the strongest are [2,0,3,1,4]
 * Example 2:
 *
 * Input: mat =
 * [[1,0,0,0],
 *  [1,1,1,1],
 *  [1,0,0,0],
 *  [1,0,0,0]],
 * k = 2
 * Output: [0,2]
 * Explanation:
 * The number of soldiers for each row is:
 * row 0 -> 1
 * row 1 -> 4
 * row 2 -> 1
 * row 3 -> 1
 * Rows ordered from the weakest to the strongest are [0,2,3,1]
 *
 *
 * Constraints:
 *
 * m == mat.length
 * n == mat[i].length
 * 2 <= n, m <= 100
 * 1 <= k <= m
 * matrix[i][j] is either 0 or 1.
 */
public class $1337TheKWeakestRowsInAMatrix {

    public static void main(String[] args) {
        PrintUtil.printArr(kWeakestRows(new int[][]{new int[]{1, 1, 0, 0, 0}, new int[]{1, 1, 1, 1, 0}, new int[]{1, 0, 0, 0, 0}, new int[]{1, 1, 0, 0, 0}, new int[]{1, 1, 1, 1, 1}}, 3));
        System.out.println("---------------------------------");
        PrintUtil.printArr(kWeakestRows2(new int[][]{new int[]{1, 1, 0, 0, 0}, new int[]{1, 1, 1, 1, 0}, new int[]{1, 0, 0, 0, 0}, new int[]{1, 1, 0, 0, 0}, new int[]{1, 1, 1, 1, 1}}, 3));
    }

    /**
     * their professional solution of this problem
     * @param mat
     * @param k
     * @return
     */
    static int[] kWeakestRows2(int[][] mat, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] != b[0] ? b[0] - a[0] : b[1] - a[1]);
        int[] ans = new int[k];

        for (int i = 0; i < mat.length; i++) {
            pq.offer(new int[] {numOnes(mat[i]), i});
            if (pq.size() > k)
                pq.poll();
        }

        while (k > 0)
            ans[--k] = pq.poll()[1];

        return ans;
    }

    static int numOnes(int[] row) {
        int lo = 0;
        int hi = row.length;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;

            if (row[mid] == 1)
                lo = mid + 1;
            else
                hi = mid;
        }

        return lo;
    }

    /**
     * my first solution of this problem
     * @param mat
     * @param k
     * @return
     */
    static int[] kWeakestRows(int[][] mat, int k) {
        int[] ans = new int[k];
        int[] tmp = new int[mat.length];
        for (int i=0;i<mat.length;i++) {
            for (int j=0;j<mat[i].length;j++) {
                if (mat[i][j] == 0) {
                    tmp[i] = j;
                    break;
                }
                if (j == mat[i].length-1) {
                    tmp[i] = mat[i].length;
                }
            }
        }
        TreeMap<Integer,List<Integer>> map = new TreeMap<>();
        for (int i=0;i<tmp.length;i++) {
            List<Integer> list = map.getOrDefault(tmp[i],new ArrayList<Integer>());
            list.add(i);
            map.put(tmp[i],list);
        }
        int i = 0;
        for (List<Integer> value : map.values()) {
            for (int j : value) {
                if (i >= k) break;
                ans[i++] = j;
            }
            if (i>=k) break;
        }
        return ans;
    }
}
