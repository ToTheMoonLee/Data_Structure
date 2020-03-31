package practice.leetcode.easy;

/**
 * Given an integer, write a function to determine if it is a power of three.
 * <p>
 * Example 1:
 * <p>
 * Input: 27
 * Output: true
 * Example 2:
 * <p>
 * Input: 0
 * Output: false
 * Example 3:
 * <p>
 * Input: 9
 * Output: true
 * Example 4:
 * <p>
 * Input: 45
 * Output: false
 * Follow up:
 * Could you do it without using any loop / recursion?
 */
public class $326PowerOfThree {

    public static void main(String[] args) {
        System.out.println(isPowerOfThree(27));
        System.out.println(isPowerOfThree(45));
    }

    /**
     * my solution of this problem
     *
     * @param n
     * @return
     */
    static boolean isPowerOfThree(int n) {
        if (n == 1) return true;
        while (n > 0) {
            if (n % 3 != 0) return false;
            n /= 3;
            if (n == 1) return true;
        }
        return false;
    }
}
