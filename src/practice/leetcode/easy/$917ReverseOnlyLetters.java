package practice.leetcode.easy;

/**
 * Given a string S, return the "reversed" string where all characters
 * that are not a letter stay in the same place, and all letters reverse their positions.
 *
 *
 *
 * Example 1:
 *
 * Input: "ab-cd"
 * Output: "dc-ba"
 * Example 2:
 *
 * Input: "a-bC-dEf-ghIj"
 * Output: "j-Ih-gfE-dCba"
 * Example 3:
 *
 * Input: "Test1ng-Leet=code-Q!"
 * Output: "Qedo1ct-eeLg=ntse-T!"
 *
 *
 * Note:
 *
 * S.length <= 100
 * 33 <= S[i].ASCIIcode <= 122
 * S doesn't contain \ or "
 */
public class $917ReverseOnlyLetters {

    public static void main(String[] args) {
        System.out.println(reverseOnlyLetters("Test1ng-Leet=code-Q!"));
    }

    /**
     * my solution of this problem
     * @param S
     * @return
     */
    static String reverseOnlyLetters(String S) {
        char[] arr = S.toCharArray();
        int i=0;
        int j = arr.length-1;
        while (i<j) {
            while (i<j && !isLetter(arr[i])) i++;
            while (i<j && !isLetter(arr[j])) j--;
            if (i<j) {
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            i++;
            j--;
        }
        return String.valueOf(arr);
    }

    static boolean isLetter(char c) {
        int a1 = c-'a';
        int a2 = c-'A';
        return a1>=0&&a1<=25 || a2>=0&&a2<=25;
    }
}
