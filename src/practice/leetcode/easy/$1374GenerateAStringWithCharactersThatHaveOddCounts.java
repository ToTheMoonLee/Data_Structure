package practice.leetcode.easy;

import java.util.Arrays;

/**
 * Given an integer n, return a string with n characters
 * such that each character in such string occurs an odd number of times.
 * <p>
 * The returned string must contain only lowercase English letters.
 * If there are multiples valid strings, return any of them.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 4
 * Output: "pppz"
 * Explanation: "pppz" is a valid string
 * since the character 'p' occurs three times and the character 'z' occurs once.
 * Note that there are many other valid strings such as "ohhh" and "love".
 * Example 2:
 * <p>
 * Input: n = 2
 * Output: "xy"
 * Explanation: "xy" is a valid string since the characters 'x' and 'y' occur once.
 * Note that there are many other valid strings such as "ag" and "ur".
 * Example 3:
 * <p>
 * Input: n = 7
 * Output: "holasss"
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 500
 */
public class $1374GenerateAStringWithCharactersThatHaveOddCounts {

    public static void main(String[] args) {
        System.out.println(generateTheString(7));
        System.out.println(generateTheString2(7));
    }

    /**
     * their solution of this problem
     *
     * @param n
     * @return
     */
    static String generateTheString2(int n) {
        char[] str = new char[n];
        Arrays.fill(str, 'a');
        if (n % 2 == 0) {
            str[0] = 'b';
        }
        return new String(str);
    }

    /**
     * my solution of this problem
     *
     * @param n
     * @return
     */
    static String generateTheString(int n) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n - 1; i++) {
            ans.append("a");
        }
        if (n % 2 == 0) {
            ans.append("b");
        } else {
            ans.append("a");
        }
        return ans.toString();
    }
}
