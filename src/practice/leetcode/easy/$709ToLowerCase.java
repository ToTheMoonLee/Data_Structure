package practice.leetcode.easy;

/**
 * Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.
 *
 *
 *
 * Example 1:
 *
 * Input: "Hello"
 * Output: "hello"
 * Example 2:
 *
 * Input: "here"
 * Output: "here"
 * Example 3:
 *
 * Input: "LOVELY"
 * Output: "lovely"
 */
public class $709ToLowerCase {

    public static void main(String[] args) {
        System.out.println(toLowerCase("Hello World"));
    }

    /**
     * my solution of this problem
     * @param str
     * @return
     */
    static String toLowerCase(String str) {
        char[] arr = str.toCharArray();
        for (int i=0;i<arr.length;i++) {
            if (arr[i]>=65 && arr[i]<=90) {
                arr[i] = (char)(arr[i]+32);
            }
        }
        return String.valueOf(arr);
    }
}
