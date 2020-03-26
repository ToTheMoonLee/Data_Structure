package practice.leetcode.easy;

import java.util.HashMap;

/**
 * Given two strings s and t, determine if they are isomorphic.
 *
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 *
 * All occurrences of a character must be replaced with another character while preserving
 * the order of characters. No two characters may map to the same character but a character may map to itself.
 *
 * Example 1:
 *
 * Input: s = "egg", t = "add"
 * Output: true
 * Example 2:
 *
 * Input: s = "foo", t = "bar"
 * Output: false
 * Example 3:
 *
 * Input: s = "paper", t = "title"
 * Output: true
 * Note:
 * You may assume both s and t have the same length.
 */
public class $205IsomorphicString {

    public static void main(String[] args) {
        System.out.println(isIsomorphic("ab", "aa"));
        System.out.println(isIsomorphic2("ab", "aa"));
    }

    /**
     * their solution of this problem
     * @param s
     * @param t
     * @return
     */
    static boolean isIsomorphic2(String s, String t) {
        int[] n = new int[512];
        for (int i=0;i<s.length();i++) {
            if (n[s.charAt(i)]!=n[t.charAt(i)+256]) return false;
            n[s.charAt(i)] = n[t.charAt(i)+256] = i+1;
        }
        return true;
    }

    /**
     * my solution of this problem
     * @param s
     * @param t
     * @return
     */
    static boolean isIsomorphic(String s, String t) {
        HashMap<Character,Integer> sMap = new HashMap<>();
        HashMap<Character,Integer> tMap = new HashMap<>();

        for (int i=0;i<s.length();i++) {
            if (sMap.get(s.charAt(i)) !=null) {
                if (t.charAt(i) != t.charAt(sMap.get(s.charAt(i)))) return false;
            }
            if (tMap.get(t.charAt(i)) != null) {
                if (s.charAt(i) != s.charAt(tMap.get(t.charAt(i)))) return false;
            }
            sMap.put(s.charAt(i),i);
            tMap.put(t.charAt(i),i);
        }
        return true;
    }
}
