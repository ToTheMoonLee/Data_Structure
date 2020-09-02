package practice.leetcode.medium;

import java.util.HashMap;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 *
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class $3LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    /**
     * thier concise and faster solution of this problem,use of sliding window.
     * same as mine,but faster than mine.
     * @param s
     * @return
     */
    static int lengthOfLongestSubstring2(String s) {
        char[] arr = s.toCharArray();
        int[] letters = new int[128];
        int i=0;
        int j=0;
        int ans = 0;
        while (j<arr.length) {
            i = Math.max(letters[arr[j]],i);
            ans = Math.max(ans,j-i+1);
            letters[arr[j]] = j+1;
            j++;
        }
        return ans;
    }

    /**
     * my solution of this problem
     * @param s
     * @return
     */
    static int lengthOfLongestSubstring(String s) {
        if (s==null || "".equals(s)) return 0;
        HashMap<Character,Integer> map = new HashMap<>();
        char[] arr = s.toCharArray();
        int start = 0;
        int ans = 0;
        int i=0;
        for (;i<arr.length;i++) {
            if (map.get(arr[i])!=null) {
                ans = Math.max(ans,i-start);
                int cur = map.get(arr[i]);
                while (start<=cur) {
                    map.remove(arr[start]);
                    start++;
                }
                map.put(arr[i],i);
            } else {
                map.put(arr[i],i);
            }
        }
        ans = Math.max(ans,i-start);
        return ans;
    }
}
