package practice.leetcode.easy;

import practice.datastructure.util.PrintUtil;

/**
 * An image is represented by a 2-D array of integers,
 * each integer representing the pixel value of the image (from 0 to 65535).
 * <p>
 * Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill,
 * and a pixel value newColor, "flood fill" the image.
 * <p>
 * To perform a "flood fill", consider the starting pixel,
 * plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel,
 * plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel),
 * and so on. Replace the color of all of the aforementioned pixels with the newColor.
 * <p>
 * At the end, return the modified image.
 * <p>
 * Example 1:
 * Input:
 * image = [[1,1,1],[1,1,0],[1,0,1]]
 * sr = 1, sc = 1, newColor = 2
 * Output: [[2,2,2],[2,2,0],[2,0,1]]
 * Explanation:
 * From the center of the image (with position (sr, sc) = (1, 1)), all pixels connected
 * by a path of the same color as the starting pixel are colored with the new color.
 * Note the bottom corner is not colored 2, because it is not 4-directionally connected
 * to the starting pixel.
 * Note:
 * <p>
 * The length of image and image[0] will be in the range [1, 50].
 * The given starting pixel will satisfy 0 <= sr < image.length and 0 <= sc < image[0].length.
 * The value of each color in image[i][j] and newColor will be an integer in [0, 65535].
 */
public class $733FloodFill {

    public static void main(String[] args) {
        int[][] image = new int[][]{new int[]{1, 1, 1}, new int[]{1, 1, 0}, new int[]{1, 0, 1}};
        PrintUtil.printArr(floodFill(image, 1, 1, 2));
        System.out.println("-------------------");
        PrintUtil.printArr(floodFill2(image, 1, 1, 2));
    }

    /**
     * their faster and consice solution of this problem
     *
     * @param image
     * @param sr
     * @param sc
     * @param newColor
     * @return
     */
    static int[][] floodFill2(int[][] image, int sr, int sc, int newColor) {
        int color = image[sr][sc];
        if (color != newColor) dfs(image, sr, sc, color, newColor);
        return image;
    }

    static void dfs(int[][] image, int r, int c, int color, int newColor) {
        if (image[r][c] == color) {
            image[r][c] = newColor;
            if (r >= 1) dfs(image, r - 1, c, color, newColor);
            if (c >= 1) dfs(image, r, c - 1, color, newColor);
            if (r + 1 < image.length) dfs(image, r + 1, c, color, newColor);
            if (c + 1 < image[0].length) dfs(image, r, c + 1, color, newColor);
        }
    }

    /**
     * my solution of this problem
     */
    static boolean[][] b;

    static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        b = new boolean[image.length][image[0].length];
        return floodFill(image, sr, sc, image[sr][sc], newColor);
    }

    static int[][] floodFill(int[][] image, int sr, int sc, int targetColor, int newColor) {
        if (image[sr][sc] == targetColor) {
            image[sr][sc] = newColor;
        }
        b[sr][sc] = true;
        if (sr - 1 >= 0 && !b[sr - 1][sc] && image[sr - 1][sc] == targetColor) {
            floodFill(image, sr - 1, sc, targetColor, newColor);
        }
        if (sr + 1 < image.length && !b[sr + 1][sc] && image[sr + 1][sc] == targetColor) {
            floodFill(image, sr + 1, sc, targetColor, newColor);
        }
        if (sc - 1 >= 0 && !b[sr][sc - 1] && image[sr][sc - 1] == targetColor) {
            floodFill(image, sr, sc - 1, targetColor, newColor);
        }
        if (sc + 1 < image[0].length && !b[sr][sc + 1] && image[sr][sc + 1] == targetColor) {
            floodFill(image, sr, sc + 1, targetColor, newColor);
        }

        return image;
    }
}
