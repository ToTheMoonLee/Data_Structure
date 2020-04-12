package practice.leetcode.easy;

/**
 * Given a non-negative integer c, your task is to decide
 * whether there're two integers a and b such that a2 + b2 = c.
 *
 * Example 1:
 *
 * Input: 5
 * Output: True
 * Explanation: 1 * 1 + 2 * 2 = 5
 *
 *
 * Example 2:
 *
 * Input: 3
 * Output: False
 */
public class $633SumOfSquareNumbers {

    public static void main(String[] args) {
        System.out.println(judgeSquareSum(5));
        System.out.println(judgeSquareSum2(5));
    }

    /**
     * their faster solution of this problem
     * @param c
     * @return
     */
    static boolean judgeSquareSum2(int c) {
        if (c < 0) {
            return false;
        }
        int left = 0, right = (int)Math.sqrt(c);
        while (left <= right) {
            int cur = left * left + right * right;
            if (cur < c) {
                left++;
            } else if (cur > c) {
                right--;
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * my solution of this problem
     * @param c
     * @return
     */
    static boolean judgeSquareSum(int c) {
        if (c == 0) return true;
        int b = (int)Math.sqrt(c);
        if (b*b == c) return true;
        for (int i=1;i<=b;i++) {
            int a = (int)Math.sqrt(c-i*i);
            if (a*a == c-i*i) return true;
        }
        return false;
    }
}
