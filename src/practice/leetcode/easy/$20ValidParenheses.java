package practice.leetcode.easy;

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
 * determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 *
 * Example 1:
 *
 * Input: "()"
 * Output: true
 * Example 2:
 *
 * Input: "()[]{}"
 * Output: true
 * Example 3:
 *
 * Input: "(]"
 * Output: false
 * Example 4:
 *
 * Input: "([)]"
 * Output: false
 * Example 5:
 *
 * Input: "{[]}"
 * Output: true
 */
public class $20ValidParenheses {

    public static void main(String[] args) {
        System.out.println(" isValid --- " + isValid("()"));
        System.out.println(" isValid --- " + isValid("()[]{}"));
        System.out.println(" isValid --- " + isValid("([)]"));
        System.out.println(" isValid --- " + isValid("[]"));

        System.out.println("------------------------------");

        System.out.println(" isValid --- " + isValid2("()"));
        System.out.println(" isValid --- " + isValid2("()[]{}"));
        System.out.println(" isValid --- " + isValid2("([)]"));
        System.out.println(" isValid --- " + isValid2("[]"));
    }

    /**
     * the amazing version of others
     * <a href="https://leetcode.com/problems/valid-parentheses/discuss/9178/Short-java-solution">
     * @param s
     * @return
     */
    static boolean isValid2(String s) {
        Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || stack.pop() != c) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    /**
     * my solution of this problem
     * @param s
     * @return
     */
    static boolean isValid(String s) {
        if (s == null) {
            return true;
        }
        char[] c = s.toCharArray();
        Stack stack = new Stack();
        for (int i=0;i<c.length;i++) {
            switch (c[i]) {
                case '(':
                case '{':
                case '[':
                    stack.push(c[i]);
                    break;
                case ')':
                    if (stack.isEmpty() || !stack.peek().equals('(')) return false;
                    stack.pop();
                    break;
                case '}':
                    if (stack.isEmpty() || !stack.peek().equals('{')) return false;
                    stack.pop();
                    break;
                case ']':
                    if (stack.isEmpty() || !stack.peek().equals('[')) return false;
                    stack.pop();
                    break;
            }
        }
        return stack.isEmpty();
    }

}
