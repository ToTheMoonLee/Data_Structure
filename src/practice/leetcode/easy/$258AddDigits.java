package practice.leetcode.easy;

/**
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 * <p>
 * Example:
 * <p>
 * Input: 38
 * Output: 2
 * Explanation: The process is like: 3 + 8 = 11, 1 + 1 = 2.
 * Since 2 has only one digit, return it.
 * Follow up:
 * Could you do it without any loop/recursion in O(1) runtime?
 */
public class $258AddDigits {

    public static void main(String[] args) {
        System.out.println(addDigits(38));
        System.out.println(addDigits2(38));
        System.out.println(addDigits3(38));
    }

    /**
     * their solution of this problem
     *
     * @param num
     * @return
     */
    static int addDigits3(int num) {
        return 1 + (num - 1) % 9;
    }

    /**
     * my second solution of this problem
     *
     * @param num
     * @return
     */
    static int addDigits2(int num) {
        if (num == 0) return 0;
        return num % 9 == 0 ? 9 : num % 9;
    }

    /**
     * my first solution of this problem
     *
     * @param num
     * @return
     */
    static int addDigits(int num) {
        int total = 0;
        while (num / 10 != 0) {
            while (num != 0) {
                total += num % 10;
                num /= 10;
            }
            num = total;
            total = 0;
        }
        return num;
    }
}
