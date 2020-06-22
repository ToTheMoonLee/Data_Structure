package practice.leetcode.easy;

/**
 * ou are given an array coordinates, coordinates[i] = [x, y],
 * where [x, y] represents the coordinate of a point.
 * Check if these points make a straight line in the XY plane.
 *
 *
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
 * Output: true
 * Example 2:
 *
 *
 *
 * Input: coordinates = [[1,1],[2,2],[3,4],[4,5],[5,6],[7,7]]
 * Output: false
 *
 *
 * Constraints:
 *
 * 2 <= coordinates.length <= 1000
 * coordinates[i].length == 2
 * -10^4 <= coordinates[i][0], coordinates[i][1] <= 10^4
 * coordinates contains no duplicate point.
 */
public class $1232CheckIfItIsAStraightLine {

    public static void main(String[] args) {
        System.out.println(checkStraightLine(new int[][]{new int[]{1, 2}, new int[]{2, 3}, new int[]{3, 4}}));
    }

    /**
     * their solution of this problem
     * @param coordinates
     * @return
     */
    static boolean checkStraightLine(int[][] coordinates) {
        int x0 = coordinates[0][0];
        int x1 = coordinates[1][0];
        int y0 = coordinates[0][1];
        int y1 = coordinates[1][1];
        int dx = x1 - x0;
        int dy = y1 - y0;
        for (int i=2;i<coordinates.length;i++) {
            if (dx * (coordinates[i][1] - y0) != dy * (coordinates[i][0] - x0)) {
                return false;
            }
        }
        return true;
    }
}
