package practice.leetcode.easy;

/**
 * An array is monotonic if it is either monotone increasing or monotone decreasing.
 *
 * An array A is monotone increasing if for all i <= j, A[i] <= A[j].
 * An array A is monotone decreasing if for all i <= j, A[i] >= A[j].
 *
 * Return true if and only if the given array A is monotonic.
 *
 *
 *
 * Example 1:
 *
 * Input: [1,2,2,3]
 * Output: true
 * Example 2:
 *
 * Input: [6,5,4,4]
 * Output: true
 * Example 3:
 *
 * Input: [1,3,2]
 * Output: false
 * Example 4:
 *
 * Input: [1,2,4,5]
 * Output: true
 * Example 5:
 *
 * Input: [1,1,1]
 * Output: true
 *
 *
 * Note:
 *
 * 1 <= A.length <= 50000
 * -100000 <= A[i] <= 100000
 */
public class $896MonotonicArray {

    public static void main(String[] args) {
        int[] A = new int[]{1, 2, 4, 5};
        System.out.println(isMonotonic(A));
        System.out.println(isMonotonic2(A));
    }

    /**
     * their concise solution of this problem,but slower than mine
     * @param A
     * @return
     */
    static boolean isMonotonic2(int[] A) {
        boolean a = true;
        boolean b = true;
        for (int i=0;i<A.length-1;i++) {
            a &= (A[i]<=A[i+1]);
            b &= (A[i]>=A[i+1]);
        }
        return a || b;
    }

    /**
     * my solution of this problem
     * @param A
     * @return
     */
    static boolean isMonotonic(int[] A) {
        boolean a = true;
        boolean b = true;
        for (int i=0;i<A.length-1;i++) {
            if (A[i]<=A[i+1]) {
                a = true;
            } else {
                a = false;
                break;
            }
        }
        for (int i=0;i<A.length-1;i++) {
            if (A[i]>=A[i+1]) {
                b = true;
            } else {
                b = false;
                break;
            }
        }
        return a || b;
    }
}
