package practice.leetcode.easy;

/**
 *
 *
 Given two strings s and t , write a function to determine if t is an anagram of s.

 Example 1:

 Input: s = "anagram", t = "nagaram"
 Output: true
 Example 2:

 Input: s = "rat", t = "car"
 Output: false
 Note:
 You may assume the string contains only lowercase alphabets.

 Follow up:
 What if the inputs contain unicode characters? How would you adapt your solution to such case?
 */
public class $242ValidAnagram {

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        String s1 = "rat";
        String t1 = "car";
        System.out.println(isAnagram(s, t));
        System.out.println(isAnagram(s1, t1));
    }

    /**
     * my solution of this problem
     * @param s
     * @param t
     * @return
     */
    static boolean isAnagram(String s, String t) {
        int[] arr = new int[26];
        for (int i=0;i<s.length();i++) {
            arr[s.charAt(i) - 'a']++;
        }
        for (int i=0;i<t.length();i++) {
            arr[t.charAt(i) - 'a']--;
        }
        for (int i=0;i<arr.length;i++) {
            if (arr[i]!=0) return false;
        }
        return true;
    }

    /**
     * my second solution of this problem
     * @param s
     * @param t
     * @return
     */
    static boolean isAnagram2(String s, String t) {
        int total = 0;
        if (s.length() != t.length()) return false;
        for (int i=0;i<s.length();i++) {
            if (!s.contains(String.valueOf(t.charAt(i)))) {
                return false;
            }
            total = total + (s.charAt(i) - t.charAt(i));
        }
        return total == 0;
    }
}
