package practice.leetcode.easy;

/**
 * Given an integer, return its base 7 string representation.
 *
 * Example 1:
 * Input: 100
 * Output: "202"
 * Example 2:
 * Input: -7
 * Output: "-10"
 * Note: The input will be in range of [-1e7, 1e7].
 */
public class $504Base7 {

    public static void main(String[] args) {
        System.out.println(convertToBase7(-100));
        System.out.println(convertToBase72(-100));
    }

    /**
     * their recursive solution of this problem,but this is slower than my solution
     * @param n
     * @return
     */
    static String convertToBase72(int n) {
        if (n < 0) return "-" + convertToBase7(-n);
        if (n < 7) return Integer.toString(n);
        return convertToBase7(n / 7) + Integer.toString(n % 7);
    }

    /**
     * my solution of this problem
     * @param num
     * @return
     */
    static String convertToBase7(int num) {
        if (num == 0) return "0";
        StringBuilder sb = new StringBuilder();
        int a = Math.abs(num);
        while (a>0) {
            sb.append(a%7);
            a/=7;
        }
        if (num < 0) sb.append("-");
        return sb.reverse().toString();
    }
}
