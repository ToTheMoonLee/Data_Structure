package practice.leetcode.easy;

/**
 * Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
 *
 * Example 1:
 * Input: "aba"
 * Output: True
 * Example 2:
 * Input: "abca"
 * Output: True
 * Explanation: You could delete the character 'c'.
 * Note:
 * The string will only contain lowercase characters a-z. The maximum length of the string is 50000.
 */
public class $680ValidPalindrome2 {

    public static void main(String[] args) {
        System.out.println(validPalindrome("abca"));
        System.out.println(validPalindrome2("abca"));
    }


    /**
     * my second solution of this problem,beats 92%
     * @param s
     * @return
     */
    static boolean validPalindrome2(String s) {
        char[] arr = s.toCharArray();
        int i=0;
        int j=arr.length-1;
        while (i <= j) {
            if (arr[i]!=arr[j]) {
                return isPalindrome(arr,i+1,j) || isPalindrome(arr,i,j-1);
            }
            i++;
            j--;
        }
        return true;
    }

    static boolean isPalindrome(char[] arr,int start,int end) {
        while (start <=end) {
            if (arr[start] != arr[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    /**
     * my first solution of this problem,beats 13%
     * @param s
     * @return
     */
    static boolean validPalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);
        StringBuilder reverse = new StringBuilder(s).reverse();
        for (int i=0;i<sb.length();i++) {
            if (sb.charAt(i) != reverse.charAt(i)) {
                boolean b1= sb.deleteCharAt(i).toString().equals(reverse.deleteCharAt(s.length()-1-i).toString());
                sb = new StringBuilder(s);
                reverse = new StringBuilder(s).reverse();
                boolean b2= sb.deleteCharAt(s.length()-1-i).toString().equals(reverse.deleteCharAt(i).toString());
                return b1 || b2;
            }
        }
        return true;
    }
}
