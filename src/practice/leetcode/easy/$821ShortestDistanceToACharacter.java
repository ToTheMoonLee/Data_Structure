package practice.leetcode.easy;

import practice.datastructure.util.PrintUtil;

/**
 * Given a string S and a character C,
 * return an array of integers representing the shortest distance from the character C in the string.
 *
 * Example 1:
 *
 * Input: S = "loveleetcode", C = 'e'
 * Output: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
 *
 *
 * Note:
 *
 * S string length is in [1, 10000].
 * C is a single character, and guaranteed to be in string S.
 * All letters in S and C are lowercase.
 */
public class $821ShortestDistanceToACharacter {

    public static void main(String[] args) {
        PrintUtil.printArr(shortestToChar("loveleetcode", 'e'));
    }

    /**
     * my solution of this problem
     * @param S
     * @param c
     * @return
     */
    static int[] shortestToChar(String S, char c) {
        int[] result = new int[S.length()];
        int l = S.length() - 1;
        int r = S.length() - 1;
        char[] arr = S.toCharArray();
        for (int i=0;i<arr.length;i++) {
            if (arr[i] == c) {
                l = 0;
            }
            result[i] = l;
            l++;
        }
        for (int i=arr.length-1;i>=0;i--) {
            if (arr[i] == c) {
                r = 0;
            }
            result[i] = Math.min(r,result[i]);
            r++;
        }
        return result;
    }
}
