package practice.leetcode.easy;

/**
 * We are given two strings, A and B.
 *
 * A shift on A consists of taking string A and moving the leftmost character to the rightmost position. For example, if A = 'abcde', then it will be 'bcdea' after one shift on A. Return True if and only if A can become B after some number of shifts on A.
 *
 * Example 1:
 * Input: A = 'abcde', B = 'cdeab'
 * Output: true
 *
 * Example 2:
 * Input: A = 'abcde', B = 'abced'
 * Output: false
 * Note:
 *
 * A and B will have length at most 100.
 */
public class $796RotateString {

    public static void main(String[] args) {
        String A = "abcde";
        String B = "cdeab";
        System.out.println(rotateString(A, B));
        System.out.println(rotateString2(A, B));
    }

    /**
     * their one line solution of this problem
     * @param A
     * @param B
     * @return
     */
    static boolean rotateString2(String A, String B) {
        return A.length() == B.length() && (A + A).contains(B);
    }

    /**
     * my solution of this problem
     * @param A
     * @param B
     * @return
     */
    static boolean rotateString(String A, String B) {
        if (A.length()!=B.length()) return false;
        if (A.length()==0) return true;
        String C = A+B;
        int[] dp = getNext(C.toCharArray());
        int i = dp[C.length()-1]+1;
        if (i>=A.length()) return true;
        int j = 0;
        while (i<A.length()) {
            if (A.charAt(i) != B.charAt(j)) return false;
            i++;
            j++;
        }
        return true;
    }

    static int[] getNext(char[] arr) {
        int[] dp = new int[arr.length];
        dp[0] = -1;
        int i=-1;
        int j=0;
        while (j<arr.length) {
            if (i==-1 || arr[i] == arr[j]) {
                i++;
                j++;
                if (j<arr.length) {
                    dp[j] = i;
                }
            } else {
                i = dp[i];
            }
        }
        return dp;
    }
}
