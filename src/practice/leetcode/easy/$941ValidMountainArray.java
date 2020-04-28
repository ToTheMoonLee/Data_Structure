package practice.leetcode.easy;

/**
 * Given an array A of integers, return true if and only if it is a valid mountain array.
 *
 * Recall that A is a mountain array if and only if:
 *
 * A.length >= 3
 * There exists some i with 0 < i < A.length - 1 such that:
 * A[0] < A[1] < ... A[i-1] < A[i]
 * A[i] > A[i+1] > ... > A[A.length - 1]
 *
 *
 *
 *
 * Example 1:
 *
 * Input: [2,1]
 * Output: false
 * Example 2:
 *
 * Input: [3,5,5]
 * Output: false
 * Example 3:
 *
 * Input: [0,3,2,1]
 * Output: true
 *
 *
 * Note:
 *
 * 0 <= A.length <= 10000
 * 0 <= A[i] <= 10000
 */
public class $941ValidMountainArray {

    public static void main(String[] args) {
        int[] A = new int[]{0, 3, 2, 1};
        System.out.println(validMountainArray(A));
        System.out.println(validMountainArray2(A));
    }

    /**
     * my faster solution of this problem,beat 100%
     * @param A
     * @return
     */
    static boolean validMountainArray2(int[] A) {
        if (A.length <3) return false;
        int i=0,j=A.length-1;
        while (i<A.length-1) {
            if (A[i] < A[i+1]) i++;
            else break;
        }
        while (j>0) {
            if (A[j]<A[j-1]) j--;
            else break;
        }
        return i!=A.length-1 && j!=0 && i==j;
    }

    /**
     * my solution of this problem
     * @param A
     * @return
     */
    static boolean validMountainArray(int[] A) {
        if (A.length <3) return false;
        int i=0,j=A.length-1;
        while (i<A.length-1 && j>0) {
            if (A[i] < A[i+1]) i++;
            if (A[j] < A[j-1]) j--;
            if (i == A.length-1 || j == 0 || A[i] >= A[i+1] && A[j]>=A[j-1]) break;
        }
        return i!=A.length-1 && j!=0 && i==j;
    }
}
