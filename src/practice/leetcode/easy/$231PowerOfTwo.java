package practice.leetcode.easy;

/**
 * Given an integer, write a function to determine if it is a power of two.
 *
 * Example 1:
 *
 * Input: 1
 * Output: true
 * Explanation: 20 = 1
 * Example 2:
 *
 * Input: 16
 * Output: true
 * Explanation: 24 = 16
 * Example 3:
 *
 * Input: 218
 * Output: false
 */
public class $231PowerOfTwo {

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(2));
        System.out.println(isPowerOfTwo(218));

        System.out.println(isPowerOfTwo2(2));
        System.out.println(isPowerOfTwo2(218));
    }

    /**
     * their amazing solution of this problem
     * @param n
     * @return
     */
    static boolean isPowerOfTwo2(int n) {
        return (n>0&&((n&n-1)==0));
    }

    /**
     * my solution of this problem
     * @param n
     * @return
     */
    static boolean isPowerOfTwo(int n) {
        if (n < 1) return false;
        if (n == 1) return true;
        while (n!=2) {
            if (n%2 == 1) return false;
            n/=2;
        }
        return true;
    }
}
