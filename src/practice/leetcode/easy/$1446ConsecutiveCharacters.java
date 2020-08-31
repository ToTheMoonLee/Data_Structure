package practice.leetcode.easy;

/**
 * Given a string s, the power of the string is the maximum length of a non-empty substring
 * that contains only one unique character.
 * <p>
 * Return the power of the string.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: s = "leetcode"
 * Output: 2
 * Explanation: The substring "ee" is of length 2 with the character 'e' only.
 * Example 2:
 * <p>
 * Input: s = "abbcccddddeeeeedcba"
 * Output: 5
 * Explanation: The substring "eeeee" is of length 5 with the character 'e' only.
 * Example 3:
 * <p>
 * Input: s = "triplepillooooow"
 * Output: 5
 * Example 4:
 * <p>
 * Input: s = "hooraaaaaaaaaaay"
 * Output: 11
 * Example 5:
 * <p>
 * Input: s = "tourist"
 * Output: 1
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 500
 * s contains only lowercase English letters.
 */
public class $1446ConsecutiveCharacters {

    public static void main(String[] args) {
        System.out.println(maxPower("leetcode"));
    }

    static int maxPower(String s) {
        int ans = 1;
        char[] arr = s.toCharArray();
        int max = 1;
        for (int i = 1; i < arr.length; i++) {
            while (i < arr.length && arr[i] == arr[i - 1]) {
                max++;
                i++;
            }
            ans = Math.max(ans, max);
            max = 1;
        }
        return ans;
    }
}
