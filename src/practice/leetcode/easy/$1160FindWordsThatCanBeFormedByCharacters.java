package practice.leetcode.easy;

import java.util.Arrays;

/**
 * You are given an array of strings words and a string chars.
 *
 * A string is good if it can be formed by characters from chars
 * (each character can only be used once).
 *
 * Return the sum of lengths of all good strings in words.
 *
 *
 *
 * Example 1:
 *
 * Input: words = ["cat","bt","hat","tree"], chars = "atach"
 * Output: 6
 * Explanation:
 * The strings that can be formed are "cat" and "hat" so the answer is 3 + 3 = 6.
 * Example 2:
 *
 * Input: words = ["hello","world","leetcode"], chars = "welldonehoneyr"
 * Output: 10
 * Explanation:
 * The strings that can be formed are "hello" and "world" so the answer is 5 + 5 = 10.
 *
 *
 * Note:
 *
 * 1 <= words.length <= 1000
 * 1 <= words[i].length, chars.length <= 100
 * All strings contain lowercase English letters only.
 */
public class $1160FindWordsThatCanBeFormedByCharacters {

    public static void main(String[] args) {
        System.out.println(countCharacters(new String[]{"cat", "bt", "hat", "tree"}, "atach"));
        System.out.println(countCharacters2(new String[]{"cat", "bt", "hat", "tree"}, "atach"));
    }

    /**
     * their solution of this problem,using Arrays.copyOf(),but slower than my solution.
     * @param words
     * @param chars
     * @return
     */
    static int countCharacters2(String[] words, String chars) {
        int count = 0;
        int[] seen = new int[26];
        //Count char of Chars String
        for (char c : chars.toCharArray())
            seen[c - 'a']++;
        // Comparing each word in words
        for (String word : words) {
            // simple making copy of seen arr
            int[] tSeen = Arrays.copyOf(seen, seen.length);
            int Tcount = 0;
            for (char c : word.toCharArray()) {
                if (tSeen[c - 'a'] > 0) {
                    tSeen[c - 'a']--;
                    Tcount++;
                }
            }
            if (Tcount == word.length())
                count += Tcount;
        }
        return count;
    }

    /**
     * my implement of this problem
     * @param words
     * @param chars
     * @return
     */
    static int countCharacters(String[] words, String chars) {
        int ans = 0;
        int[] letters = new int[26];
        char[] arr = chars.toCharArray();
        for (char a : arr) {
            letters[a-'a']++;
        }
        for (String s : words) {
            char[] charArray = s.toCharArray();
            int[] temp = new int[26];
            int i = 0;
            for (;i<charArray.length;i++) {
                if (letters[charArray[i]-'a'] > 0) {
                    letters[charArray[i]-'a']--;
                    temp[charArray[i]-'a']++;
                } else {
                    break;
                }
            }
            if (i == charArray.length) {
                ans += s.length();
            }
            i=0;
            for (;i<temp.length;i++) {
                letters[i] += temp[i];
            }
        }
        return ans;
    }
}
