package practice.leetcode.easy;

import java.util.Arrays;
import java.util.Comparator;

/**
 * In an alien language, surprisingly they also use english lowercase letters,
 * but possibly in a different order. The order of the alphabet is some permutation of lowercase letters.
 *
 * Given a sequence of words written in the alien language, and the order of the alphabet,
 * return true if and only if the given words are sorted lexicographicaly in this alien language.
 *
 *
 *
 * Example 1:
 *
 * Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
 * Output: true
 * Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
 * Example 2:
 *
 * Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
 * Output: false
 * Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.
 * Example 3:
 *
 * Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
 * Output: false
 * Explanation: The first three characters "app" match,
 * and the second string is shorter (in size.) According to lexicographical rules "apple" > "app", because 'l' > '∅',
 * where '∅' is defined as the blank character which is less than any other character (More info).
 *
 *
 * Constraints:
 *
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 20
 * order.length == 26
 * All characters in words[i] and order are English lowercase letters.
 */
public class $953VerifyingAnAlienDictionary {

    public static void main(String[] args) {
        System.out.println(isAlienSorted(new String[]{"word", "world", "row"}, "worldabcefghijkmnpqstuvxyz"));
    }

    /**
     * my solution of this problem
     * @param words
     * @param order
     * @return
     */
    static boolean isAlienSorted(String[] words, String order) {
        for (int i=0;i<words.length-1;i++) {
            char[] c1 = words[i].toCharArray();
            char[] c2 = words[i+1].toCharArray();
            boolean b = false;
            for (int j=0;j<c1.length&&j<c2.length;j++) {
                if (order.indexOf(c1[j]) > order.indexOf(c2[j])) {
                    return false;
                } else if (order.indexOf(c1[j]) < order.indexOf(c2[j])) {
                    b = true;
                    break;
                }
            }
            if (!b&& c1.length > c2.length) return false;
        }
        return true;
    }

}
