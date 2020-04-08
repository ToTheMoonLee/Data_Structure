package practice.leetcode.easy;

/**
 * Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting
 * from the start of the string. If there are less than k characters left,
 * reverse all of them. If there are less than 2k but greater than or equal to k characters,
 * then reverse the first k characters and left the other as original.
 * Example:
 * Input: s = "abcdefg", k = 2
 * Output: "bacdfeg"
 * Restrictions:
 * The string consists of lower English letters only.
 * Length of the given string and k will in the range [1, 10000]
 */
public class $541ReverseString2 {

    public static void main(String[] args) {
        System.out.println(reverseStr("abcdefg",2));
        System.out.println(reverseStr2("abcdefg",2));
    }

    /**
     * their faster solution of this problem,beat 100%
     * @param s
     * @param k
     * @return
     */
    static String reverseStr2(String s, int k) {

        int i = 0;
        char[] chars = s.toCharArray();
        while (i < chars.length) {

            int end = i + k - 1;
            if (end > chars.length - 1)
                end = chars.length - 1;

            reverse(chars, i, end);

            i = i + 2 * k;
        }

        return new String(chars);
    }

    static void reverse(char[] chars, int left, int right) {

        while (left < right) {
            char tmp = chars[left];
            chars[left] = chars[right];
            chars[right] = tmp;
            left++;
            right--;
        }
    }

    /**
     * my solution of this problem
     * @param s
     * @param k
     * @return
     */
    static String reverseStr(String s, int k) {
        char[] arr = s.toCharArray();
        for (int i=0;i*k<arr.length;i++) {
            if (i%2==0) {
                int j=i*k;
                int n = (i+1)*k < arr.length ? (i+1)*k-1 : arr.length-1;
                reverse(arr, j, n);
            }
        }
        return String.valueOf(arr);
    }
}
