package practice.leetcode.easy;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 *
 * Note: Given n will be a positive integer.
 *
 * Example 1:
 *
 * Input: 2
 * Output: 2
 * Explanation: There are two ways to climb to the top.
 * 1. 1 step + 1 step
 * 2. 2 steps
 * Example 2:
 *
 * Input: 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 */
public class $70ClimbingStairs {

    public static void main(String[] args) {
//        System.out.println(climbStairs(45));
        System.out.println(climbStairs2(45));
    }

    /**
     * the other solution of this problem
     * <a href="https://leetcode.com/problems/climbing-stairs/discuss/25299/Basically-it's-a-fibonacci."/>
     * @param n
     * @return
     */
    static int climbStairs2(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (n == 2) return 2;

        int oneStepBefore = 2;
        int twoStepBefore = 1;
        int total = 0;
        for (int i = 2; i < n; i++) {
            total = oneStepBefore + twoStepBefore;
            twoStepBefore = oneStepBefore;
            oneStepBefore = total;
        }
        return total;
    }

    /**
     * my solution of this problem and it get a time limit exceeded
     * @param n
     * @return
     */
    static int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        return climbStairs(n-1) + climbStairs(n-2);
    }
}
