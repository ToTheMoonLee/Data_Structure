package practice.leetcode.easy;

/**
 * Given a string s formed by digits ('0' - '9') and '#' .
 * We want to map s to English lowercase characters as follows:
 *
 * Characters ('a' to 'i') are represented by ('1' to '9') respectively.
 * Characters ('j' to 'z') are represented by ('10#' to '26#') respectively.
 * Return the string formed after mapping.
 *
 * It's guaranteed that a unique mapping will always exist.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "10#11#12"
 * Output: "jkab"
 * Explanation: "j" -> "10#" , "k" -> "11#" , "a" -> "1" , "b" -> "2".
 * Example 2:
 *
 * Input: s = "1326#"
 * Output: "acz"
 * Example 3:
 *
 * Input: s = "25#"
 * Output: "y"
 * Example 4:
 *
 * Input: s = "12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"
 * Output: "abcdefghijklmnopqrstuvwxyz"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * s[i] only contains digits letters ('0'-'9') and '#' letter.
 * s will be valid string such that mapping is always possible.
 */
public class $1309DecryptStringFromAlphabetToIntegerMapping {

    public static void main(String[] args) {
        System.out.println(freqAlphabets("10#11#12"));
        System.out.println(freqAlphabets2("10#11#12"));
    }

    /**
     * my second solution of this problem
     * @param s
     * @return
     */
    static String freqAlphabets2(String s) {
        StringBuilder ans = new StringBuilder();
        char[] arr = s.toCharArray();
        for (int i=0;i<arr.length;i++) {
            int offset = 0;
            if (i+2 < arr.length && arr[i+2] == '#') {
                String temp = String.valueOf(arr[i]) + String.valueOf(arr[i+1]);
                i += 2;
                offset = Integer.parseInt(temp) -1;
            } else {
                offset = arr[i] - '1';
            }
            ans.append((char)('a'+offset));
        }
        return ans.toString();
    }

    /**
     * my first solution of this problem
     * @param s
     * @return
     */
    static String freqAlphabets(String s) {
        String ans = "";
        char[] arr = s.toCharArray();
        for (int i=arr.length-1;i>=0;i--) {
            int temp = 0;
            if (arr[i] == '#') {
                temp = arr[--i] - '0' + 10*(arr[--i] - '0') - 1;
            } else {
                temp = arr[i] - '0' - 1;
            }
            ans = (char)('a' + temp) + ans;
        }
        return ans;
    }
}
