package practice.leetcode.easy;

import java.util.Stack;

/**
 * A valid parentheses string is either empty (""), "(" + A + ")", or A + B,
 * where A and B are valid parentheses strings, and + represents string concatenation.
 * For example, "", "()", "(())()", and "(()(()))" are all valid parentheses strings.
 *
 * A valid parentheses string S is primitive if it is nonempty,
 * and there does not exist a way to split it into S = A+B, with A and B nonempty valid parentheses strings.
 *
 * Given a valid parentheses string S,
 * consider its primitive decomposition: S = P_1 + P_2 + ... + P_k,
 * where P_i are primitive valid parentheses strings.
 *
 * Return S after removing the outermost parentheses
 * of every primitive string in the primitive decomposition of S.
 *
 *
 *
 * Example 1:
 *
 * Input: "(()())(())"
 * Output: "()()()"
 * Explanation:
 * The input string is "(()())(())", with primitive decomposition "(()())" + "(())".
 * After removing outer parentheses of each part, this is "()()" + "()" = "()()()".
 * Example 2:
 *
 * Input: "(()())(())(()(()))"
 * Output: "()()()()(())"
 * Explanation:
 * The input string is "(()())(())(()(()))", with primitive decomposition "(()())" + "(())" + "(()(()))".
 * After removing outer parentheses of each part, this is "()()" + "()" + "()(())" = "()()()()(())".
 * Example 3:
 *
 * Input: "()()"
 * Output: ""
 * Explanation:
 * The input string is "()()", with primitive decomposition "()" + "()".
 * After removing outer parentheses of each part, this is "" + "" = "".
 *
 *
 * Note:
 *
 * S.length <= 10000
 * S[i] is "(" or ")"
 * S is a valid parentheses string
 */
public class $1021RemoveOutermostParentheses {

    public static void main(String[] args) {
        System.out.println(removeOuterParentheses("(()())(())(()(()))"));
        System.out.println(removeOuterParentheses2("(()())(())(()(()))"));
    }

    /**
     * their solution of this problem
     * @param S
     * @return
     */
    static String removeOuterParentheses2(String S) {
        StringBuilder ans = new StringBuilder();
        int opened = 0;
        for (char c : S.toCharArray()) {
            if ('('==c && opened++ > 0) ans.append(c);
            if (')'==c && opened-- > 1) ans.append(c);
        }
        return ans.toString();
    }

    /**
     * my solution of this problem
     * @param S
     * @return
     */
    static String removeOuterParentheses(String S) {
        Stack<String> s = new Stack<>();
        char[] arr = S.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<arr.length;i++) {
            String word = String.valueOf(arr[i]);
            if (s.isEmpty()) {
                s.push(word);
                arr[i] = ' ';
            } else if (s.size() == 1 && ")".equals(word)){
                s.pop();
                arr[i] = ' ';
            }else if ("(".equals(word)) {
                s.push(word);
            } else {
                s.pop();
            }
        }
        for (int i=0;i<arr.length;i++) {
            if (arr[i] !=' ') {
                sb.append(arr[i]);
            }
        }
        return sb.toString();
    }
}
