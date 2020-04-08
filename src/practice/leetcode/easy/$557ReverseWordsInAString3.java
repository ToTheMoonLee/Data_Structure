package practice.leetcode.easy;

import static practice.leetcode.easy.$541ReverseString2.reverse;

/**
 * Given a string, you need to reverse the order of characters in each word within a sentence
 * while still preserving whitespace and initial word order.
 *
 * Example 1:
 * Input: "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 * Note: In the string, each word is separated by single space and there will not be any extra space in the string.
 */
public class $557ReverseWordsInAString3 {

    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
        System.out.println(reverseWords2("Let's take LeetCode contest"));
    }

    /**
     * my second solution of this problem,faster than 100%
     * @param s
     * @return
     */
    static String reverseWords2(String s) {
        char[] c = s.toCharArray();
        int start = 0;
        int end = 0;
        for (int i=0;i<c.length;i++) {
            if (c[i] == ' ' || i==c.length-1) {
                end = i==c.length-1 ? c.length-1 : i-1;
                reverse(c,start,end);
                start = i+1;
            }
        }
        return String.valueOf(c);
    }

    /**
     * my first solution of this problem
     * @param s
     * @return
     */
    static String reverseWords(String s) {
        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<arr.length;i++) {
            char[] c = arr[i].toCharArray();
            reverse(c,0,arr[i].length()-1);
            sb.append(String.valueOf(c)).append(" ");
        }
        return sb.deleteCharAt(sb.length()-1).toString();
    }

}
