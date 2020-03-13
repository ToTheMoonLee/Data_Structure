package practice.leetcode.easy;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 *
 * Note: For the purpose of this problem, we define empty string as valid palindrome.
 *
 * Example 1:
 *
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 * Example 2:
 *
 * Input: "race a car"
 * Output: false
 */
public class $125ValidPalindrome {

    public static void main(String[] args) {
        String s1 = "A man, a plan, a canal: Panama";
        String s2 = "race a car";
        System.out.println(isPalindrome(s1));
        System.out.println(isPalindrome(s2));
        System.out.println(isPalindrome2(s2));
        System.out.println(isPalindrome2(s2));
    }

    private static final char[] charMap = new char[256];

    static {
        for (int i = 0; i < 10; i++) {
            charMap[i + '0'] = (char) (1 + i);  // numeric
        }
        for (int i = 0; i < 26; i++) {
            charMap[i + 'a'] = charMap[i + 'A'] = (char) (11 + i);  //alphabetic, ignore cases
        }
    }

    /**
     * their amazing solution of this problem
     *
     * @param s
     * @return
     */
    static boolean isPalindrome2(String s) {
        char[] pChars = s.toCharArray();
        int start = 0, end = pChars.length - 1;
        char cS, cE;
        while (start < end) {
            cS = charMap[pChars[start]];
            cE = charMap[pChars[end]];
            if (cS != 0 && cE != 0) {
                if (cS != cE) return false;
                start++;
                end--;
            } else {
                if (cS == 0) start++;
                if (cE == 0) end--;
            }
        }
        return true;
    }

    /**
     * my solution of this problem
     *
     * @param s
     * @return
     */
    static boolean isPalindrome(String s) {
        s = s.trim().toLowerCase();
        if (s.length() == 0) return true;
        int i = 0;
        int j = s.length() - 1;
        while (i <= j) {
            while (i < s.length() && (s.charAt(i) < 97 && s.charAt(i) > 57 || s.charAt(i) < 48 || s.charAt(i) > 122)) {
                i++;
            }
            while (j >= 0 && (s.charAt(j) < 97 && s.charAt(j) > 57 || s.charAt(j) < 48 || s.charAt(i) > 122)) {
                j--;
            }
            if (i <= j && s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
