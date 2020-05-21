package practice.leetcode.easy;

import java.util.Stack;

/**
 * Given a string S of lowercase letters,
 * a duplicate removal consists of choosing two adjacent and equal letters, and removing them.
 *
 * We repeatedly make duplicate removals on S until we no longer can.
 *
 * Return the final string after all such duplicate removals have been made.
 * It is guaranteed the answer is unique.
 *
 *
 *
 * Example 1:
 *
 * Input: "abbaca"
 * Output: "ca"
 * Explanation:
 * For example, in "abbaca" we could remove "bb" since the letters are adjacent and equal,
 * and this is the only possible move.
 * The result of this move is that the string is "aaca",
 * of which only "aa" is possible, so the final string is "ca".
 *
 *
 * Note:
 *
 * 1 <= S.length <= 20000
 * S consists only of English lowercase letters.
 */
public class $1047RemoveAllAdjacentDuplicatesInString {

    public static void main(String[] args) {
        System.out.println(removeDuplicates("abbaca"));
        System.out.println(removeDuplicates2("abbaca"));
        System.out.println(removeDuplicates3("abbaca"));
    }

    /**
     * their amazing solution of this problem
     * @param S
     * @return
     */
    static String removeDuplicates3(String S) {
        int i = 0;
        char[] arr = S.toCharArray();
        for (int j=0;j<arr.length;i++,j++) {
            arr[i] = arr[j];
            if (i>0&&arr[i]==arr[i-1]) {
                i-=2;
            }
        }
        return new String(arr,0,i);
    }

    /**
     * my second solution of this problem
     * @param S
     * @return
     */
    static String removeDuplicates2(String S) {
        char[] arr = S.toCharArray();
        StringBuilder s = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        stack.push(arr[0]);
        for (int i=1;i<arr.length;i++) {
            if (!stack.isEmpty() && stack.peek() == arr[i]) {
                stack.pop();
            } else {
                stack.push(arr[i]);
            }
        }
        while (!stack.isEmpty()) {
            s.append(stack.pop());
        }
        return s.reverse().toString();
    }

    /**
     * my first solution of this problem
     * @param S
     * @return
     */
    static String removeDuplicates(String S) {
        char[] arr = S.toCharArray();
        StringBuilder s = new StringBuilder();
        while (arr.length > 0) {
            boolean flag = false;
            for (int i=0;i<arr.length;i++) {
                if (i+1 < arr.length && arr[i] == arr[i+1]) {
                    i++;
                    flag = true;
                }
                else {
                    s.append(arr[i]);
                }
            }
            if (flag) {
                arr = s.toString().toCharArray();
                s = new StringBuilder();
            } else {
                break;
            }
        }
        return s.toString();
    }
}
