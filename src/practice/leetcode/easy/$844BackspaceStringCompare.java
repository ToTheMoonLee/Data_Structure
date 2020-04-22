package practice.leetcode.easy;

import java.util.Stack;

/**
 * Given two strings S and T, return if they are equal when both are typed into empty text editors.
 * # means a backspace character.
 *
 * Note that after backspacing an empty text, the text will continue empty.
 *
 * Example 1:
 *
 * Input: S = "ab#c", T = "ad#c"
 * Output: true
 * Explanation: Both S and T become "ac".
 * Example 2:
 *
 * Input: S = "ab##", T = "c#d#"
 * Output: true
 * Explanation: Both S and T become "".
 * Example 3:
 *
 * Input: S = "a##c", T = "#a#c"
 * Output: true
 * Explanation: Both S and T become "c".
 * Example 4:
 *
 * Input: S = "a#c", T = "b"
 * Output: false
 * Explanation: S becomes "c" while T becomes "b".
 * Note:
 *
 * 1 <= S.length <= 200
 * 1 <= T.length <= 200
 * S and T only contain lowercase letters and '#' characters.
 * Follow up:
 *
 * Can you solve it in O(N) time and O(1) space?
 */
public class $844BackspaceStringCompare {

    public static void main(String[] args) {
        System.out.println(backspaceCompare("ab#c", "ad#c"));
        System.out.println(backspaceCompare2("ab#c", "ad#c"));
    }

    /**
     * their solution of this problem
     * I thought like this ,but did't implement it
     * @param S
     * @param T
     * @return
     */
    static boolean backspaceCompare2(String S, String T) {
        char[] s = S.toCharArray();
        char[] t = T.toCharArray();
        int i=s.length-1,j=t.length-1;
        while(true) {
            int n = 0;
            while (i>=0 && (n>0 || s[i]=='#')) {
                n += s[i]=='#'? 1 : -1;
                i--;
            }
            n =  0;
            while (j>=0 && (n>0 || t[j]=='#')) {
                n += t[j]=='#'? 1 : -1;
                j--;
            }
            if (i>=0&&j>=0&&s[i]==t[j]) {
                i--;
                j--;
            } else {
                break;
            }
        }
        return i==-1&j==-1;
    }

    /**
     * my solutoin of this problem
     * @param S
     * @param T
     * @return
     */
    static boolean backspaceCompare(String S, String T) {
        char[] s = S.toCharArray();
        char[] t = T.toCharArray();
        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();
        pushToStack(s, s1);
        pushToStack(t, s2);
        if (s1.size() != s2.size()) return false;
        while (!s1.isEmpty()) {
            if (s1.pop() !=s2.pop()) return false;
        }
        return true;
    }

    private static void pushToStack(char[] t, Stack<Character> s2) {
        for (char aT : t) {
            if (!s2.isEmpty() && aT == '#') s2.pop();
            else if (aT != '#') s2.push(aT);
        }
    }
}
