package practice.leetcode.easy;

import practice.datastructure.util.PrintUtil;

import java.util.Arrays;

/**
 * Let's define a function f(s) over a non-empty string s,
 * which calculates the frequency of the smallest character in s.
 * For example, if s = "dcce" then f(s) = 2 because the smallest character is "c" and its frequency is 2.
 *
 * Now, given string arrays queries and words, return an integer array answer,
 * where each answer[i] is the number of words such that f(queries[i]) < f(W), where W is a word in words.
 *
 *
 *
 * Example 1:
 *
 * Input: queries = ["cbd"], words = ["zaaaz"]
 * Output: [1]
 * Explanation: On the first query we have f("cbd") = 1, f("zaaaz") = 3 so f("cbd") < f("zaaaz").
 * Example 2:
 *
 * Input: queries = ["bbb","cc"], words = ["a","aa","aaa","aaaa"]
 * Output: [1,2]
 * Explanation: On the first query only f("bbb") < f("aaaa").
 * On the second query both f("aaa") and f("aaaa") are both > f("cc").
 *
 *
 * Constraints:
 *
 * 1 <= queries.length <= 2000
 * 1 <= words.length <= 2000
 * 1 <= queries[i].length, words[i].length <= 10
 * queries[i][j], words[i][j] are English lowercase letters.
 */
public class $1170CompareStringsByFrequencyOfTheSmallestCharacter {

    public static void main(String[] args) {
        PrintUtil.printArr(numSmallerByFrequency(new String[]{"bbb", "cc"}, new String[]{"a", "aa", "aaa", "aaaa"}));
        PrintUtil.printArr(numSmallerByFrequency2(new String[]{"bbb", "cc"}, new String[]{"a", "aa", "aaa", "aaaa"}));
    }

    /**
     * their amazing solution of this problem
     * @param queries
     * @param words
     * @return
     */
    static int[] numSmallerByFrequency2(String[] queries, String[] words) {
        int[] fCount = new int[11];
        for (String s : words) {
            fCount[f(s)]++;
        }
        int sum = 0;
        for (int i = 0;i<fCount.length;i++) {
            sum += fCount[i];
            fCount[i] = sum;
        }

        int[] ans = new int[queries.length];
        for (int i=0;i<queries.length;i++) {
            ans[i] = fCount[fCount.length-1] - fCount[f(queries[i])];
        }
        return ans;
    }

    /**
     * my solution of this problem
     * @param queries
     * @param words
     * @return
     */
    static int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] q = new int[queries.length];
        int[] w = new int[words.length];
        for (int i=0;i<queries.length;i++) {
            q[i] = f(queries[i]);
        }
        for (int i=0;i<words.length;i++) {
            w[i] = f(words[i]);
        }
        int[] ans = new int[q.length];
        Arrays.sort(w);
        for (int i=0;i<q.length;i++) {
            int j = w.length-1;
            for (;j>=0;j--) {
                if (q[i]>=w[j]) break;
            }
            ans[i] = w.length-1-j;
        }
        return ans;
    }

    static int f(String s ) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        int i=1;
        for (;i<arr.length;i++) {
            if (arr[i]!=arr[i-1]) {
                break;
            }
        }
        return i;
    }
}
