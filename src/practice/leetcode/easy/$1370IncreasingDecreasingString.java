package practice.leetcode.easy;

import java.util.Arrays;
import java.util.Stack;

/**
 * Given a string s. You should re-order the string using the following algorithm:
 *
 * Pick the smallest character from s and append it to the result.
 * Pick the smallest character from s which is greater than the last appended character to the result and append it.
 * Repeat step 2 until you cannot pick more characters.
 * Pick the largest character from s and append it to the result.
 * Pick the largest character from s which is smaller than the last appended character to the result and append it.
 * Repeat step 5 until you cannot pick more characters.
 * Repeat the steps from 1 to 6 until you pick all characters from s.
 * In each step, If the smallest or the largest character appears
 * more than once you can choose any occurrence and append it to the result.
 *
 * Return the result string after sorting s with this algorithm.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "aaaabbbbcccc"
 * Output: "abccbaabccba"
 * Explanation: After steps 1, 2 and 3 of the first iteration, result = "abc"
 * After steps 4, 5 and 6 of the first iteration, result = "abccba"
 * First iteration is done. Now s = "aabbcc" and we go back to step 1
 * After steps 1, 2 and 3 of the second iteration, result = "abccbaabc"
 * After steps 4, 5 and 6 of the second iteration, result = "abccbaabccba"
 * Example 2:
 *
 * Input: s = "rat"
 * Output: "art"
 * Explanation: The word "rat" becomes "art" after re-ordering it with the mentioned algorithm.
 * Example 3:
 *
 * Input: s = "leetcode"
 * Output: "cdelotee"
 * Example 4:
 *
 * Input: s = "ggggggg"
 * Output: "ggggggg"
 * Example 5:
 *
 * Input: s = "spo"
 * Output: "ops"
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 500
 * s contains only lower-case English letters.
 */
public class $1370IncreasingDecreasingString {

    public static void main(String[] args) {
        System.out.println(sortString("aaaabbbbcccc"));
        System.out.println(sortString2("aaaabbbbcccc"));
    }

    /**
     * their solution of this problem
     * @param s
     * @return
     */
    static String sortString2(String s) {
        StringBuilder ans = new StringBuilder();
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c-'a']++;
        }
        while (ans.length()<s.length()) {
            add(count,ans,true);
            add(count,ans,false);
        }
        return ans.toString();
    }

    static void add(int[] count, StringBuilder sb, boolean asc) {
        for (int i=0;i<count.length;i++) {
            int j = asc ? i : 25 - i;
            if (count[j]-- > 0) {
                sb.append((char)(j+'a'));
            }
        }
    }

    /**
     * my solution of this problem
     * @param s
     * @return
     */
    static String sortString(String s) {
        char[] charArr = s.toCharArray();
        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();
        Arrays.sort(charArr);
        for (int i=charArr.length-1;i>=0;i--) {
            s1.push(charArr[i]);
        }
        String result = "";
        int i = charArr.length;
        while (i>0) {
            if (s1.isEmpty()) break;
            result = result + s1.pop();
            while (!s1.isEmpty()) {
                if (s1.peek() > result.charAt(result.length()-1)) {
                    result = result + s1.pop();
                    i--;
                } else {
                    s2.push(s1.pop());
                }
            }
            if (s2.isEmpty()) break;
            result = result+s2.pop();
            while (!s2.isEmpty()) {
                if (s2.peek() < result.charAt(result.length()-1)) {
                    result = result + s2.pop();
                    i--;
                } else {
                    s1.push(s2.pop());
                }
            }
        }
        return result;
    }
}
