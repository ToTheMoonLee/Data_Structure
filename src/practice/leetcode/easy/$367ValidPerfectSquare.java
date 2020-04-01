package practice.leetcode.easy;

/**
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
 *
 * Note: Do not use any built-in library function such as sqrt.
 *
 * Example 1:
 *
 * Input: 16
 * Output: true
 * Example 2:
 *
 * Input: 14
 * Output: false
 */
public class $367ValidPerfectSquare {

    public static void main(String[] args) {
        System.out.println(isPerfectSquare(16));
        System.out.println(isPerfectSquare(14));
    }

    /**
     * my solution of this problem,we should notice that the long type be used instead of int
     * @param num
     * @return
     */
    static boolean isPerfectSquare(int num) {
        int start = 1;
        int end = num;
        long mid = 0;
        while (start<=end) {
            mid = start + (end - start)/2;
            long sqrt = mid * mid;
            if (sqrt == num) {
                return true;
            } else if (sqrt < num) {
                start = (int)mid+1;
            } else {
                end = (int)mid - 1;
            }
        }
        return false;
    }
}
