package practice.leetcode.easy;

/**
 * Given an array of 4 digits, return the largest 24 hour time that can be made.
 *
 * The smallest 24 hour time is 00:00, and the largest is 23:59.
 * Starting from 00:00, a time is larger if more time has elapsed since midnight.
 *
 * Return the answer as a string of length 5.  If no valid time can be made, return an empty string.
 *
 *
 *
 * Example 1:
 *
 * Input: [1,2,3,4]
 * Output: "23:41"
 * Example 2:
 *
 * Input: [5,5,5,5]
 * Output: ""
 *
 *
 * Note:
 *
 * A.length == 4
 * 0 <= A[i] <= 9
 * Accepted
 * 15,663
 * Submissions
 * 43,153
 */
public class $949LargestTimeForGivenGigits {

    public static void main(String[] args) {
        System.out.println(largestTimeFromDigits(new int[]{1,2,3,4}));
    }

    /**
     * the official solution of this problem
     * @param A
     * @return
     */
    static String largestTimeFromDigits(int[] A) {
        int ans = -1;
        for(int i=0;i<A.length;i++) {
            for (int j=0;j<A.length;j++) {
                for (int k=0;k<A.length;k++) {
                    if (i == j || j == k || i == k) continue;
                    int h = A[i]*10+A[j];
                    int m = A[k]*10+A[6-i-j-k];
                    if (h<24 && m<60 ) {
                        ans = Math.max(h*60+m,ans);
                    }
                }
            }
        }
        return ans>=0 ? String.format("%02d:%02d",ans/60,ans%60) : "";
    }
}
