package practice.leetcode.easy;

/**
 * On a N * N grid, we place some 1 * 1 * 1 cubes.
 * <p>
 * Each value v = grid[i][j] represents a tower of v cubes placed on top of grid cell (i, j).
 * <p>
 * Return the total surface area of the resulting shapes.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [[2]]
 * Output: 10
 * Example 2:
 * <p>
 * Input: [[1,2],[3,4]]
 * Output: 34
 * Example 3:
 * <p>
 * Input: [[1,0],[0,2]]
 * Output: 16
 * Example 4:
 * <p>
 * Input: [[1,1,1],[1,0,1],[1,1,1]]
 * Output: 32
 * Example 5:
 * <p>
 * Input: [[2,2,2],[2,1,2],[2,2,2]]
 * Output: 46
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= N <= 50
 * 0 <= grid[i][j] <= 50
 */
public class $892SurfaceAreaOf3DShapes {

    public static void main(String[] args) {
        System.out.println(surfaceArea(new int[][]{new int[]{1, 2}, new int[]{3, 4}}));
    }

    /**
     * my solution of this problem
     *
     * @param grid
     * @return
     */
    static int surfaceArea(int[][] grid) {
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != 0) {
                    sum += ((grid[i][j] * 4) + 2);
                }
                if (i - 1 >= 0) sum -= Math.min(grid[i - 1][j], grid[i][j]) * 2;
                if (j - 1 >= 0) sum -= Math.min(grid[i][j - 1], grid[i][j]) * 2;
            }
        }
        return sum;
    }
}
