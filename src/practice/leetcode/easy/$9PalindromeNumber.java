package practice.leetcode.easy;

public class $9PalindromeNumber {

    public static void main(String[] args) {
        System.out.println(" result is " + isPalindrome(2));
        System.out.println(" result is " + isPalindrome(12));
        System.out.println(" result is " + isPalindrome(-12));
        System.out.println(" result is " + isPalindrome(121));

        System.out.println("---------------------------------");

        System.out.println(" result is " + isPalindrome2(121));
        System.out.println(" result is " + isPalindrome2(2));
        System.out.println(" result is " + isPalindrome2(20000));
        System.out.println(" result is " + isPalindrome2(20002));
    }

    /**
     * the amazing version of others
     * <a href="https://leetcode.com/problems/palindrome-number/discuss/5127/9-line-accepted-Java-code-without-the-need-of-handling-overflow">
     * @param x
     * @return
     */
    static boolean isPalindrome2(int x) {
        if (x < 0 || x % 10 == 0) {
            return false;
        }
        int rev = 0;
        while (x > rev) {
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        return x == rev || x == rev / 10;
    }

    /**
     * my solution of this issue
     * @param x
     * @return
     */
    static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int temp = x;
        int result = 0;
        int tail;
        while (temp != 0) {
            tail = temp % 10;
            result = result * 10 + tail;
            temp /= 10;
        }
        return result == x;
    }
}
