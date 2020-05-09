package practice.leetcode.easy;

import practice.datastructure.util.PrintUtil;

import java.util.*;

/**
 * We are given a matrix with R rows and C columns has cells with integer coordinates (r, c),
 * where 0 <= r < R and 0 <= c < C.
 *
 * Additionally, we are given a cell in that matrix with coordinates (r0, c0).
 *
 * Return the coordinates of all cells in the matrix,
 * sorted by their distance from (r0, c0) from smallest distance to largest distance.
 * Here, the distance between two cells (r1, c1) and (r2, c2) is
 * the Manhattan distance, |r1 - r2| + |c1 - c2|.
 * (You may return the answer in any order that satisfies this condition.)
 *
 *
 *
 * Example 1:
 *
 * Input: R = 1, C = 2, r0 = 0, c0 = 0
 * Output: [[0,0],[0,1]]
 * Explanation: The distances from (r0, c0) to other cells are: [0,1]
 * Example 2:
 *
 * Input: R = 2, C = 2, r0 = 0, c0 = 1
 * Output: [[0,1],[0,0],[1,1],[1,0]]
 * Explanation: The distances from (r0, c0) to other cells are: [0,1,1,2]
 * The answer [[0,1],[1,1],[0,0],[1,0]] would also be accepted as correct.
 * Example 3:
 *
 * Input: R = 2, C = 3, r0 = 1, c0 = 2
 * Output: [[1,2],[0,2],[1,1],[0,1],[1,0],[0,0]]
 * Explanation: The distances from (r0, c0) to other cells are: [0,1,1,2,2,3]
 * There are other answers that would also be accepted as correct, such as [[1,2],[1,1],[0,2],[1,0],[0,1],[0,0]].
 *
 *
 * Note:
 *
 * 1 <= R <= 100
 * 1 <= C <= 100
 * 0 <= r0 < R
 * 0 <= c0 < C
 */
public class $1030MatrixCellsInDistanceOrder {

    public static void main(String[] args) {
        PrintUtil.printArr(allCellsDistOrder(1,2,0,0));
        System.out.println("----------------------------");
        PrintUtil.printArr(allCellsDistOrder2(1,2,0,0));
    }

    /**
     * their sort solution of this problem
     * @param R
     * @param C
     * @param r0
     * @param c0
     * @return
     */
    static int[][] allCellsDistOrder2(int R, int C, int r0, int c0) {
        TreeMap<Integer,List<int[]>> map = new TreeMap<>();
        for(int i=0;i<R;i++) {
            for (int j=0;j<C;j++) {
                int dist = Math.abs(r0-i) + Math.abs(c0-j);
                List<int[]> list = map.getOrDefault(dist,new ArrayList<>());
                list.add(new int[]{i,j});
                map.put(dist,list);
            }
        }
        int[][] result = new int[R*C][2];
        int i=0;
        for (int k : map.keySet()) {
            List<int[]> list = map.get(k);
            for (int[] c : list) {
                result[i++] = c;
            }
        }
        return result;
    }

    /**
     * their BFS solution of this problem
     * @param R
     * @param C
     * @param r0
     * @param c0
     * @return
     */
    static int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
        int i=0;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] b = new boolean[R][C];
        int[][] result = new int[R*C][2];
        q.offer(new int[]{r0,c0});
        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int r = temp[0];
            int c = temp[1];
            if (r<0 || r>=R || c<0 || c>=C) {
                continue;
            }
            if (b[r][c]) continue;
            result[i] = temp;
            i++;
            b[r][c] = true;

            q.offer(new int[]{r-1,c});
            q.offer(new int[]{r+1,c});
            q.offer(new int[]{r,c-1});
            q.offer(new int[]{r,c+1});
        }
        return result;
    }
}
