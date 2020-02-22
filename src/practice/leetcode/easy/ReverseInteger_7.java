package practice.leetcode.easy;

/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 * <p>
 * Example 1:
 * <p>
 * Input: 123
 * Output: 321
 * Example 2:
 * <p>
 * Input: -123
 * Output: -321
 * Example 3:
 * <p>
 * Input: 120
 * Output: 21
 * Note:
 * Assume we are dealing with an environment which could only store integers within
 * the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem,
 * assume that your function returns 0 when the reversed integer overflows.
 */
public class ReverseInteger_7 {

    public static void main(String[] args) {
        int reverse = new Solution().reverse(123);
        System.out.println(" reverse is " + reverse);
//        int reverse2 = new Solution().reverse2(123);
        int reverse2 = new Solution().reverse2(1534236469);
        System.out.println(" reverse is " + reverse2);
    }

    static class Solution {

        int reverse2(int x) {
            int result = 0;
            int tail;
            int newResult;
            while (x != 0) {
                tail = x % 10;
                newResult = result * 10 + tail;
                if ((newResult - tail) / 10 != result) {
                    return 0;
                }
                result = newResult;
                x = x / 10;
            }
            return result;
        }

        /**
         * my solution of this issue
         *
         * @param x
         * @return
         */
        int reverse(int x) {
            String s = String.valueOf(x);
            StringBuilder reverse = new StringBuilder();
            for (int i = s.length() - 1; i >= 0; i--) {
                int c = s.charAt(i);
                if (c == '-') {
                    reverse.insert(0, "-");
                } else {
                    reverse.append((char) c);
                }
            }
            int result = 0;
            try {
                result = Integer.valueOf(reverse.toString());
            } catch (Exception e) {
                result = 0;
            }
            return result;
        }
    }
}
