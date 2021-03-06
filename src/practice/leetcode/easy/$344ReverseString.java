package practice.leetcode.easy;


import static practice.leetcode.easy.$541ReverseString2.reverse;

/**
 * Write a function that reverses a string. The input string is given as an array of characters char[].
 *
 * Do not allocate extra space for another array,
 * you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * You may assume all the characters consist of printable ascii characters.
 *
 *
 *
 * Example 1:
 *
 * Input: ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 * Example 2:
 *
 * Input: ["H","a","n","n","a","h"]
 * Output: ["h","a","n","n","a","H"]
 */
public class $344ReverseString {

    public static void main(String[] args) {
        char[] chars = "Hannah".toCharArray();
        reverseString(chars);
        StringBuilder sb = new StringBuilder();
        for (char c : chars) {
            sb.append(c + ",");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb.toString());
    }

    static void reverseString(char[] s) {
        int i=0;
        int j=s.length-1;
        reverse(s,i,j);
    }
}
