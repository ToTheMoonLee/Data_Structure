package practice.leetcode.easy;

/**
 * In a row of seats, 1 represents a person sitting in that seat, and 0 represents that the seat is empty.
 *
 * There is at least one empty seat, and at least one person sitting.
 *
 * Alex wants to sit in the seat such that the distance between him and the closest person to him is maximized.
 *
 * Return that maximum distance to closest person.
 *
 * Example 1:
 *
 * Input: [1,0,0,0,1,0,1]
 * Output: 2
 * Explanation:
 * If Alex sits in the second open seat (seats[2]), then the closest person has distance 2.
 * If Alex sits in any other open seat, the closest person has distance 1.
 * Thus, the maximum distance to the closest person is 2.
 * Example 2:
 *
 * Input: [1,0,0,0]
 * Output: 3
 * Explanation:
 * If Alex sits in the last seat, the closest person is 3 seats away.
 * This is the maximum distance possible, so the answer is 3.
 * Note:
 *
 * 1 <= seats.length <= 20000
 * seats contains only 0s or 1s, at least one 0, and at least one 1.
 */
public class $849MaxmizeDistanceToClosestPerson {

    public static void main(String[] args) {
        int[] seats = new int[]{1, 0, 0, 0, 1, 0, 1};
        System.out.println(maxDistToClosest(seats));
        System.out.println(maxDistToClosest2(seats));
    }

    /**
     * their concise solution of this problem
     * @param seats
     * @return
     */
    static int maxDistToClosest2(int[] seats) {
        int res = 0, n = seats.length, last = -1;
        for (int i = 0; i < n; ++i) {
            if (seats[i] == 1) {
                res = last < 0 ? i : Math.max(res, (i - last) / 2);
                last = i;
            }
        }
        res = Math.max(res, n - last - 1);
        return res;
    }

    /**
     * my solution of this problem
     * @param seats
     * @return
     */
    static int maxDistToClosest(int[] seats) {
        int max = 0;
        for (int i=0,j=0;i<seats.length;i=j) {
            j = i;
            if (seats[j] == 1) {
                j++;
                continue;
            }
            while (j<seats.length && seats[j] == 0) {
                j++;
            }
            if (i==0 || j==seats.length) {
                if (j - i > max) max = j-i;
            }else if ((j-i+1)/2 > max) {
                max = (j-i+1)/2;
            }
        }
        return max;
    }
}
