package practice.leetcode.medium;

/**
 * Given a string s, find the longest palindromic substring in s.
 * You may assume that the maximum length of s is 1000.
 *
 * Example 1:
 *
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: "cbbd"
 * Output: "bb"
 */
public class $5LongestPalindromicSubstring {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad"));
        System.out.println("---------------");
        System.out.println(longestPalindrome2("babad"));
        System.out.println("---------------");
        System.out.println(longestPalindrome3("babad"));
    }

    /**
     * their dynamic programming solution of this problem
     * @param s
     * @return
     */
    static String longestPalindrome3(String s) {
        int n = s.length();
        String res = null;

        boolean[][] dp = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);

                if (dp[i][j] && (res == null || j - i + 1 > res.length())) {
                    res = s.substring(i, j + 1);
                }
            }
        }

        return res;
    }

    /**
     * my second solution of this problem
     * @param s
     * @return
     */
    static String longestPalindrome2(String s) {
        if (s == null || s.length() == 0) return "";
        char[] arr = s.toCharArray();
        int m = 0;
        int n = 0;
        for (int i = 0; i < arr.length; i++) {
            int j = i - 1;
            int k = i + 1;
            while (j >= 0 && k < arr.length && arr[j] == arr[k]) {
                j--;
                k++;
            }
            if (k - j - 2 > n - m) {
                m = j + 1;
                n = k - 1;
            }
            j = i - 1;
            k = i;
            while (j >= 0 && k < arr.length && arr[j] == arr[k]) {
                j--;
                k++;
            }
            if (k - j - 2 > n - m) {
                m = j + 1;
                n = k - 1;
            }
        }
        return s.substring(m, n + 1);
    }

    /**
     * my first solution of this problem
     *
     * @param s
     * @return
     */
    static String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        char[] arr = s.toCharArray();
        int m = 0;
        int n = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length - 1; j >= i; j--) {
                int k = i;
                int l = j;
                while (k <= l) {
                    if (arr[k] != arr[l]) break;
                    k++;
                    l--;
                }
                if (k > l && j - i > n - m) {
                    m = i;
                    n = j;
                }
            }
        }
        return s.substring(m, n + 1);
    }
}
