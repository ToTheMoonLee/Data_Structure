package practice.leetcode.easy;

/**
 * Given an integer n, return the number of trailing zeroes in n!.
 *
 * Example 1:
 *
 * Input: 3
 * Output: 0
 * Explanation: 3! = 6, no trailing zero.
 * Example 2:
 *
 * Input: 5
 * Output: 1
 * Explanation: 5! = 120, one trailing zero.
 * Note: Your solution should be in logarithmic time complexity.
 */
public class $172FactorialTrailingZeroes {

    public static void main(String[] args) {
        System.out.println(trailingZeroes(25));
    }

    /**
     * their solution of this problem
     * @param n
     * @return
     */
    static int trailingZeroes(int n) {
        return n == 0 ? 0 : n/5 + trailingZeroes(n/5);
    }
}
