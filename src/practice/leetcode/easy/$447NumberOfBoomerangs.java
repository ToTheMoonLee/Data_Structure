package practice.leetcode.easy;

import java.util.HashMap;

/**
 * Given n points in the plane that are all pairwise distinct,
 * a "boomerang" is a tuple of points (i, j, k) such that
 * the distance between i and j equals the distance between i and k (the order of the tuple matters).
 *
 * Find the number of boomerangs. You may assume that n will be at most 500 and coordinates
 * of points are all in the range [-10000, 10000] (inclusive).
 *
 * Example:
 *
 * Input:
 * [[0,0],[1,0],[2,0]]
 *
 * Output:
 * 2
 *
 * Explanation:
 * The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]
 */
public class $447NumberOfBoomerangs {

    public static void main(String[] args) {
        System.out.println(numberOfBoomerangs(new int[][]{new int[]{0, 0}, new int[]{1, 0}, new int[]{2, 0}}));
    }

    /**
     * my solution of this problem
     * @param points
     * @return
     */
    static int numberOfBoomerangs(int[][] points) {
        int result = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<points.length;i++) {
            int[] point1 = points[i];
            for (int j=0;j<points.length;j++) {
                if (j == i) continue;
                int[] point2 = points[j];
                int distance = (point2[0]-point1[0]) * (point2[0]-point1[0]) + (point2[1]-point1[1]) * (point2[1]-point1[1]);
                Integer count = map.get(distance);
                if (count == null) {
                    map.put(distance,1);
                } else {
                    result = result + count*2;
                    map.put(distance,count+1);
                }
            }
            map.clear();
        }
        return result;
    }
}
