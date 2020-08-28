package practice.leetcode.easy;

import practice.datastructure.util.PrintUtil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given an array of string words. Return all strings in words which
 * is substring of another word in any order.
 *
 * String words[i] is substring of words[j],
 * if can be obtained removing some characters to left and/or right side of words[j].
 *
 *
 *
 * Example 1:
 *
 * Input: words = ["mass","as","hero","superhero"]
 * Output: ["as","hero"]
 * Explanation: "as" is substring of "mass" and "hero" is substring of "superhero".
 * ["hero","as"] is also a valid answer.
 * Example 2:
 *
 * Input: words = ["leetcode","et","code"]
 * Output: ["et","code"]
 * Explanation: "et", "code" are substring of "leetcode".
 * Example 3:
 *
 * Input: words = ["blue","green","bu"]
 * Output: []
 *
 *
 * Constraints:
 *
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 30
 * words[i] contains only lowercase English letters.
 * It's guaranteed that words[i] will be unique.
 */
public class $1408StringMatchingInAnArray {

    public static void main(String[] args) {
        PrintUtil.printList(stringMatching(new String[]{"mass", "as", "hero", "superhero"}));
    }

    /**
     * my solution of this problem
     * @param words
     * @return
     */
    static List<String> stringMatching(String[] words) {
        Set<String> ans = new HashSet<>();
        for (int i=0;i<words.length;i++) {
            for (int j=0;j<words.length;j++) {
                if (j!=i && contains(words[i],words[j])) {
                    ans.add(words[j]);
                }
            }
        }
        return new ArrayList<>(ans);
    }

    static boolean contains(String s1,String s2) {
        if (s2.length() > s1.length()) return false;
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        for (int i=0;i<=c1.length-c2.length;i++) {
            for (int j=0;j<c2.length;j++) {
                if (c1[j+i]!=c2[j]) break;
                if (j == c2.length-1) {
                    i = c1.length;
                    return true;
                }
            }
        }
        return false;
    }
}
