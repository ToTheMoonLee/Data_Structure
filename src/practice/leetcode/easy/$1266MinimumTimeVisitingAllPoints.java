package practice.leetcode.easy;

/**
 * On a plane there are n points with integer coordinates points[i] = [xi, yi].
 * Your task is to find the minimum time in seconds to visit all points.
 *
 * You can move according to the next rules:
 *
 * In one second always you can either move vertically,
 * horizontally by one unit or diagonally (it means to move one unit vertically and one unit horizontally in one second).
 * You have to visit the points in the same order as they appear in the array.
 *
 *
 * Example 1:
 *
 *
 * Input: points = [[1,1],[3,4],[-1,0]]
 * Output: 7
 * Explanation: One optimal path is [1,1] -> [2,2] -> [3,3] -> [3,4] -> [2,3] -> [1,2] -> [0,1] -> [-1,0]
 * Time from [1,1] to [3,4] = 3 seconds
 * Time from [3,4] to [-1,0] = 4 seconds
 * Total time = 7 seconds
 * Example 2:
 *
 * Input: points = [[3,2],[-2,2]]
 * Output: 5
 *
 *
 * Constraints:
 *
 * points.length == n
 * 1 <= n <= 100
 * points[i].length == 2
 * -1000 <= points[i][0], points[i][1] <= 1000
 */
public class $1266MinimumTimeVisitingAllPoints {

    public static void main(String[] args) {
        System.out.println(minTimeToVisitAllPoints(new int[][]{new int[]{1, 1}, new int[]{3, 4}, new int[]{-1, 0}}));
    }

    /**
     * my solution of this problem
     * @param points
     * @return
     */
    static int minTimeToVisitAllPoints(int[][] points) {
        int ans = 0;
        for (int i=1;i<points.length;i++) {
            ans += getMin(points[i-1],points[i]);
        }
        return ans;
    }

    static int getMin(int[] a, int[] b) {
        int c1 = 0;
        int c2 = 0;
        if (a[0] > b[0]) {
            c1 = a[0] - b[0];
        } else {
            c1 = b[0] - a[0];
        }
        if (a[1] > b[1]) {
            c2 = a[1] - b[1];
        } else {
            c2 = b[1] - a[1];
        }
        return Math.max(c1,c2);
    }
}
