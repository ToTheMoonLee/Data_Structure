package practice.leetcode.easy;

/**
 * The Fibonacci numbers, commonly denoted F(n) form a sequence,
 * called the Fibonacci sequence, such that each number is the sum of the two preceding ones,
 * starting from 0 and 1. That is,
 *
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), for N > 1.
 * Given N, calculate F(N).
 *
 *
 *
 * Example 1:
 *
 * Input: 2
 * Output: 1
 * Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.
 * Example 2:
 *
 * Input: 3
 * Output: 2
 * Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
 * Example 3:
 *
 * Input: 4
 * Output: 3
 * Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.
 *
 *
 * Note:
 *
 * 0 ≤ N ≤ 30.
 */
public class $509FibonacciNumber {

    /**
     * we can learn more solutions here
     * <a href="https://leetcode.com/problems/fibonacci-number/solution/"/>F
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(fib(10));
        System.out.println(fib2(10));
    }

    /**
     * my second solution of this problem,beat 100% java solution
     */
    static int[] cache;
    static int fib2(int n) {
        cache = new int[n+1];
        for (int i=0;i<cache.length;i++) {
            cache[i] = -1;
        }
        return getFib(n);
    }

    static int getFib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (cache[n] != -1) return cache[n];
        cache[n] = getFib(n-1) + getFib(n-2);
        return cache[n];
    }

    /**
     * my first solution of this problem,beat 5.01% java solution
     * @param n
     * @return
     */
    static int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fib(n-1) + fib(n-2);
    }
}
