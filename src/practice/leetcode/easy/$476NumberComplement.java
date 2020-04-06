package practice.leetcode.easy;

import java.util.Stack;

/**
 * Given a positive integer, output its complement number.
 * The complement strategy is to flip the bits of its binary representation.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: 5
 * Output: 2
 * Explanation: The binary representation of 5 is 101 (no leading zero bits),
 * and its complement is 010. So you need to output 2.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: 1
 * Output: 0
 * Explanation: The binary representation of 1 is 1 (no leading zero bits),
 * and its complement is 0. So you need to output 0.
 * <p>
 * <p>
 * Note:
 * <p>
 * The given integer is guaranteed to fit within the range of a 32-bit signed integer.
 * You could assume no leading zero bit in the integer’s binary representation.
 * This question is the same as 1009: https://leetcode.com/problems/complement-of-base-10-integer/
 */
public class $476NumberComplement {

    public static void main(String[] args) {
        System.out.println(findComplement(8));
        System.out.println(findComplement2(1));
    }

    /**
     * their solution of this problem
     * 100110, its complement is 011001, the sum is 111111. 
     * @param num
     * @return
     */
    static int findComplement3(int num) {
        int i = 0;
        int j = 0;

        while (i < num) {
            i += Math.pow(2, j);
            j++;
        }

        return i - num;
    }

    /**
     * my second solution of this problem
     *
     * @param num
     * @return
     */
    static int findComplement2(int num) {
        int temp = num;
        int take = 0;
        while (num != 0) {
            take = take << 1;
            take = take | 1;
            num = num >> 1;
        }

        return take ^ temp;
    }

    /**
     * my first solution of this problem
     *
     * @param num
     * @return
     */
    static int findComplement(int num) {
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        while (num != 0) {
            int n = ~num & 1;
            stack.push(n);
            num = num >> 1;
        }
        while (!stack.isEmpty()) {
            int n = stack.pop();
            result = result << 1;
            result = result | n;
        }
        return result;
    }
}
