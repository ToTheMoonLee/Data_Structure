package practice.leetcode.easy;

/**
 * Given alphanumeric string s.
 * (Alphanumeric string is a string consisting of lowercase English letters and digits).
 * <p>
 * You have to find a permutation of the string where no letter
 * is followed by another letter and no digit is followed by another digit.
 * That is, no two adjacent characters have the same type.
 * <p>
 * Return the reformatted string or return an empty string if it is impossible to reformat the string.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "a0b1c2"
 * Output: "0a1b2c"
 * Explanation: No two adjacent characters have the same type
 * in "0a1b2c". "a0b1c2", "0a1b2c", "0c2a1b" are also valid permutations.
 * Example 2:
 * <p>
 * Input: s = "leetcode"
 * Output: ""
 * Explanation: "leetcode" has only characters so we cannot separate them by digits.
 * Example 3:
 * <p>
 * Input: s = "1229857369"
 * Output: ""
 * Explanation: "1229857369" has only digits so we cannot separate them by characters.
 * Example 4:
 * <p>
 * Input: s = "covid2019"
 * Output: "c2o0v1i9d"
 * Example 5:
 * <p>
 * Input: s = "ab123"
 * Output: "1a2b3"
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 500
 * s consists of only lowercase English letters and/or digits.
 */
public class $1417ReformatTheString {

    public static void main(String[] args) {
        System.out.println(reformat("covid2019"));
    }

    static String reformat(String s) {
        int letterCount = 0;
        char[] cArr = s.toCharArray();
        for (int i = 0; i < cArr.length; i++) {
            if (cArr[i] - 'a' >= 0 && cArr[i] - 'a' < 26) {
                letterCount++;
            }
        }
        int numCount = s.length() - letterCount;
        if (Math.abs(numCount - letterCount) > 1) return "";
        char[] c = new char[s.length()];
        int ni = 0;
        int li = 1;
        if (numCount < letterCount) {
            ni = 1;
            li = 0;
        }
        for (char ch : cArr) {
            if (ch - 'a' >= 0 && ch - 'a' < 26) {
                c[li] = ch;
                li += 2;
            } else {
                c[ni] = ch;
                ni += 2;
            }
        }
        return new String(c);
    }
}
