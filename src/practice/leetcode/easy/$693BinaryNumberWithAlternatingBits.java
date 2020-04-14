package practice.leetcode.easy;

/**
 * Given a positive integer, check whether it has alternating bits: namely,
 * if two adjacent bits will always have different values.
 *
 * Example 1:
 * Input: 5
 * Output: True
 * Explanation:
 * The binary representation of 5 is: 101
 * Example 2:
 * Input: 7
 * Output: False
 * Explanation:
 * The binary representation of 7 is: 111.
 * Example 3:
 * Input: 11
 * Output: False
 * Explanation:
 * The binary representation of 11 is: 1011.
 * Example 4:
 * Input: 10
 * Output: True
 * Explanation:
 * The binary representation of 10 is: 1010.
 */
public class $693BinaryNumberWithAlternatingBits {

    public static void main(String[] args) {
        System.out.println(hasAlternatingBits(6));
        System.out.println(hasAlternatingBits2(6));
    }

    /**
     * their amazing solution of this problem
     * @param n
     * @return
     */
    static boolean hasAlternatingBits2(int n) {
        /*
        n =         1 0 1 0 1 0 1 0
        n >> 1      0 1 0 1 0 1 0 1
        n ^ n>>1    1 1 1 1 1 1 1 1
        n           1 1 1 1 1 1 1 1
        n + 1     1 0 0 0 0 0 0 0 0
        n & (n+1)   0 0 0 0 0 0 0 0
        */

        n = n ^ (n>>1);
        return (n & n+1) == 0;
    }

    /**
     * my solution of this problem
     * @param n
     * @return
     */
    static boolean hasAlternatingBits(int n) {
        if (n == 0 || n == 1) return true;
        while (n >1) {
            int temp1 = n&0b11;
            if (temp1 == 0b11 || temp1 == 0) return false;
            n >>=1;
        }
        return true;
    }
}
