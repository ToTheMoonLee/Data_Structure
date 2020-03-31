package practice.leetcode.easy;

/**
 * Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
 *
 * Example 1:
 *
 * Input: 16
 * Output: true
 * Example 2:
 *
 * Input: 5
 * Output: false
 * Follow up: Could you solve it without loops/recursion?
 */
public class $342PowerOfFour {

    public static void main(String[] args) {
        System.out.println(isPowerOfFour(16));
        System.out.println(isPowerOfFour(5));
    }

    /**
     * my solution of this problem
     * @param num
     * @return
     */
    static boolean isPowerOfFour(int num) {
        if (num <= 0) return false;
        if ((num&(num-1))!=0) return false;
        int n = 0b01010101010101010101010101010101;
        return (num&n) == num;
    }
}
