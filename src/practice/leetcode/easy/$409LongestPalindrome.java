package practice.leetcode.easy;

import java.util.HashSet;

/**
 * Given a string which consists of lowercase or uppercase letters,
 * find the length of the longest palindromes that can be built with those letters.
 *
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 *
 * Note:
 * Assume the length of given string will not exceed 1,010.
 *
 * Example:
 *
 * Input:
 * "abccccdd"
 *
 * Output:
 * 7
 *
 * Explanation:
 * One longest palindrome that can be built is "dccaccd", whose length is 7.
 */
public class $409LongestPalindrome {

    public static void main(String[] args) {
        String s = "abccccdd";
        System.out.println(longestPalindrome(s));
        System.out.println(longestPalindrome2(s));
        System.out.println(longestPalindrome3(s));
    }

    /**
     * their faster solution of this problem
     * @param s
     * @return
     */
    static int longestPalindrome3(String s) {
        int[] lowercase = new int[26];
        int[] uppercase = new int[26];
        int res = 0;
        for (int i = 0; i < s.length(); i++){
            char temp = s.charAt(i);
            if (temp >= 97) lowercase[temp-'a']++;
            else uppercase[temp-'A']++;
        }
        for (int i = 0; i < 26; i++){
            res+=(lowercase[i]/2)*2;
            res+=(uppercase[i]/2)*2;
        }
        return res == s.length() ? res : res+1;
    }

    /**
     * their solution of this problem
     * @param s
     * @return
     */
    static int longestPalindrome2(String s) {
        if(s==null || s.length()==0) return 0;
        HashSet<Character> hs = new HashSet<Character>();
        int count = 0;
        for(int i=0; i<s.length(); i++){
            if(hs.contains(s.charAt(i))){
                hs.remove(s.charAt(i));
                count++;
            }else{
                hs.add(s.charAt(i));
            }
        }
        if(!hs.isEmpty()) return count*2+1;
        return count*2;
    }

    /**
     * my solution of this problem
     * @param s
     * @return
     */
    static int longestPalindrome(String s) {
        if (s == null || s.length() == 0) return 0;
        int[] words = new int[256];
        int longest = 0;
        int extra = 0;
        for (int i=0;i<s.length();i++) {
            if (++words[s.charAt(i)] == 2) {
                longest+=2;
                words[s.charAt(i)] = 0;
            }
        }
        for (int i=0;i<words.length;i++) {
            if (words[i] == 1) {
                extra = 1;
                break;
            }
        }
        return longest+extra;
    }
}
