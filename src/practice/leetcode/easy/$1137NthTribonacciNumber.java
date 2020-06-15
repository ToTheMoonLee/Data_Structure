package practice.leetcode.easy;

/**
 * The Tribonacci sequence Tn is defined as follows:
 *
 * T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
 *
 * Given n, return the value of Tn.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 4
 * Output: 4
 * Explanation:
 * T_3 = 0 + 1 + 1 = 2
 * T_4 = 1 + 1 + 2 = 4
 * Example 2:
 *
 * Input: n = 25
 * Output: 1389537
 *
 *
 * Constraints:
 *
 * 0 <= n <= 37
 * The answer is guaranteed to fit within a 32-bit integer, ie. answer <= 2^31 - 1.
 */
public class $1137NthTribonacciNumber {

    public static void main(String[] args) {
        System.out.println(tribonacci(25));
        System.out.println(tribonacci2(25));
    }

    /**
     * my second solution of this problem
     * @param n
     * @return
     */
    static int tribonacci2(int n) {
        if (n == 0) return n;
        if (n == 1) return n;
        if (n==2) return 1;
        int n1 = 0;
        int n2 = 1;
        int n3 = 1;
        for (int i=3;i<n;i++) {
            int sum = n1 + n2 + n3;
            n1 = n2;
            n2 = n3;
            n3 = sum;
        }

        return  n1 + n2 + n3;
    }

    /**
     * my first solution of this problem
     */
    static int[] memo = new int[38];
    static int tribonacci(int n) {
        if (n == 0) return n;
        if (n == 1) return n;
        if (n==2) return 1;
        int n1 = memo[n-1];
        int n2 = memo[n-2];
        int n3 = memo[n-3];
        if (n1 == 0) {
            n1 = tribonacci(n-1);
            memo[n-1] = n1;
        }
        if (n2 == 0) {
            n2 = tribonacci(n-2);
            memo[n-2] = n2;
        }
        if (n3 == 0) {
            n3 = tribonacci(n-3);
            memo[n-3] = n3;
        }

        return  n1 + n2 + n3;
    }
}
