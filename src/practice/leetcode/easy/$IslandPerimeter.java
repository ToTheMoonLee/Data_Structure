package practice.leetcode.easy;

/**
 * You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.
 *
 * Grid cells are connected horizontally/vertically (not diagonally).
 * The grid is completely surrounded by water,
 * and there is exactly one island (i.e., one or more connected land cells).
 *
 * The island doesn't have "lakes" (water inside that isn't connected to the water around the island).
 * One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100.
 * Determine the perimeter of the island.
 *
 *
 *
 * Example:
 *
 * Input:
 * [[0,1,0,0],
 *  [1,1,1,0],
 *  [0,1,0,0],
 *  [1,1,0,0]]
 *
 * Output: 16
 *
 * Explanation: The perimeter is the 16 yellow stripes in the image below:
 */
public class $IslandPerimeter {

    public static void main(String[] args) {
        int[][] grid = new int[][]{new int[]{0, 1, 0, 0}, new int[]{1, 1, 1, 0}, new int[]{0, 1, 0, 0}, new int[]{1, 1, 0, 0}};
        System.out.println(islandPerimeter(grid));
        System.out.println(islandPerimeter2(grid));
    }

    /**
     * their solution of this problem
     * @param grid
     * @return
     */
    static int islandPerimeter2(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    result += 4;
                    if (i > 0 && grid[i-1][j] == 1) result -= 2;
                    if (j > 0 && grid[i][j-1] == 1) result -= 2;
                }
            }
        }
        return result;
    }

    /**
     * my solution of this problem
     * @param grid
     * @return
     */
    static int islandPerimeter(int[][] grid) {
        int count = 0;
        for (int i=0;i<grid.length;i++) {
            int[] line = grid[i];
            for (int j=0;j<line.length;j++) {
                if (line[j] == 1) {
                    if (j-1 < 0 || line[j-1] == 0) {
                        count++;
                    }
                    if (i-1 < 0 || grid[i-1][j] == 0) {
                        count++;
                    }
                    if (j+1 == line.length || line[j+1] == 0) {
                        count++;
                    }
                    if (i+1 == grid.length || grid[i+1][j] == 0) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
