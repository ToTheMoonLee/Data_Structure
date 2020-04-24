package practice.leetcode.easy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given two strings A and B of lowercase letters, return true if and
 * only if we can swap two letters in A so that the result equals B.
 *
 *
 *
 * Example 1:
 *
 * Input: A = "ab", B = "ba"
 * Output: true
 * Example 2:
 *
 * Input: A = "ab", B = "ab"
 * Output: false
 * Example 3:
 *
 * Input: A = "aa", B = "aa"
 * Output: true
 * Example 4:
 *
 * Input: A = "aaaaaaabc", B = "aaaaaaacb"
 * Output: true
 * Example 5:
 *
 * Input: A = "", B = "aa"
 * Output: false
 *
 *
 * Note:
 *
 * 0 <= A.length <= 20000
 * 0 <= B.length <= 20000
 * A and B consist only of lowercase letters.
 */
public class $859BuddyStrings {

    public static void main(String[] args) {
        System.out.println(buddyStrings("ab","ba"));
        System.out.println(buddyStrings2("ab","ba"));
    }

    /**
     * their concise solution of this problem
     * @param A
     * @param B
     * @return
     */
    static boolean buddyStrings2(String A, String B) {
        if (A.length() != B.length()) return false;
        if (A.equals(B)) {
            Set<Character> s = new HashSet<Character>();
            for (char c : A.toCharArray()) s.add(c);
            return s.size() < A.length();
        }
        List<Integer> dif = new ArrayList<>();
        for (int i = 0; i < A.length(); ++i) if (A.charAt(i) != B.charAt(i)) dif.add(i);
        return dif.size() == 2 && A.charAt(dif.get(0)) == B.charAt(dif.get(1)) && A.charAt(dif.get(1)) == B.charAt(dif.get(0));
    }

    /**
     * my solution of this problem
     * @param A
     * @param B
     * @return
     */
    static boolean buddyStrings(String A, String B) {
        if (A.length()!=B.length()) return false;
        if (A.length() ==0 || A.length() == 1) return false;
        boolean count = false;
        List<Character> list1 = new ArrayList<>();
        List<Character> list2 = new ArrayList<>();
        int[] boo = new int[26];
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();
        for (int i=0;i<A.length();i++) {
            if (a[i]!=b[i]) {
                list1.add(a[i]);
                list2.add(b[i]);
            } else {
                boo[a[i]-'a']++;
                if (boo[a[i]-'a'] >=2) {
                    count = true;
                }
            }
        }
        if (list1.size() == 0 && count) return true;
        if (list1.size()!=2) return false;

        return list1.get(0) == list2.get(1) && list1.get(1)==list2.get(0);
    }
}
