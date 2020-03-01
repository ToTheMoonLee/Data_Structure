package practice.leetcode.easy;

/**
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 *
 * The digits are stored such that the most significant digit is at the head of the list,
 * and each element in the array contain a single digit.
 *
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 *
 * Example 1:
 *
 * Input: [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Example 2:
 *
 * Input: [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 */
public class $66PlusOne {

    public static void main(String[] args) {
        int[] digits = new int[]{9, 9};
//        int[] result = plusOne(digits);
        int[] result = plusOne2(digits);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    /**
     * the amazing solution of this problem from other people
     * <a href="https://leetcode.com/problems/plus-one/discuss/24082/My-Simple-Java-Solution"/>
     * @param digits
     * @return
     */
    static int[] plusOne2(int[] digits) {
        int n = digits.length;
        for (int i=n-1;i>=0;i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int[] result = new int[n + 1];
        result[0] = 1;
        return result;
    }

    /**
     * my solution of this problem
     * @param digits
     * @return
     */
    static int[] plusOne(int[] digits) {
        int sum = 0;
        for (int i = digits.length - 1; i >= 0; i--) {
            sum /= 10;
            sum = sum + digits[i];
            if (i == digits.length - 1) {
                sum += 1;
            }
            digits[i] = sum % 10;
            if (sum < 10) {
                return digits;
            }
        }
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        for (int i = 0; i < digits.length; i++) {
            result[i + 1] = digits[i];
        }
        return result;
    }
}
