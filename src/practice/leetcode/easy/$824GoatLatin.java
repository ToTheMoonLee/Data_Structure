package practice.leetcode.easy;

/**
 * A sentence S is given, composed of words separated by spaces.
 * Each word consists of lowercase and uppercase letters only.
 *
 * We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.)
 *
 * The rules of Goat Latin are as follows:
 *
 * If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of the word.
 * For example, the word 'apple' becomes 'applema'.
 *
 * If a word begins with a consonant (i.e. not a vowel),
 * remove the first letter and append it to the end, then add "ma".
 * For example, the word "goat" becomes "oatgma".
 *
 * Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
 * For example, the first word gets "a" added to the end, the second word gets "aa" added to the end and so on.
 * Return the final sentence representing the conversion from S to Goat Latin.
 *
 *
 *
 * Example 1:
 *
 * Input: "I speak Goat Latin"
 * Output: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
 * Example 2:
 *
 * Input: "The quick brown fox jumped over the lazy dog"
 * Output: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa
 * overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
 *
 *
 * Notes:
 *
 * S contains only uppercase, lowercase and spaces. Exactly one space between each word.
 * 1 <= S.length <= 150.
 */
public class $824GoatLatin {

    public static void main(String[] args) {
        System.out.println(toGoatLatin("I speak Goat Latin"));
    }

    /**
     * my solution of this problem
     */
    static String pattern = "aeiouAEIOU";
    static String toGoatLatin(String S) {
        String[] arr = S.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<arr.length;i++) {
            sb.append(GL(arr[i],i+1));
            if (i!=arr.length-1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    static String GL(String s,int n) {
        StringBuilder sb = new StringBuilder();
        if (!pattern.contains(String.valueOf(s.charAt(0)))) {
            sb.append(s.substring(1,s.length())).append(s.charAt(0));
        } else {
            sb.append(s);
        }
        sb.append("ma");
        for (int i=0;i<n;i++) {
            sb.append("a");
        }
        return sb.toString();
    }
}
