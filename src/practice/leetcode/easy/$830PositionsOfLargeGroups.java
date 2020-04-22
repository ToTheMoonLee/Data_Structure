package practice.leetcode.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * In a string S of lowercase letters, these letters form consecutive groups of the same character.
 *
 * For example, a string like S = "abbxxxxzyy" has the groups "a", "bb", "xxxx", "z" and "yy".
 *
 * Call a group large if it has 3 or more characters.
 * We would like the starting and ending positions of every large group.
 *
 * The final answer should be in lexicographic order.
 *
 *
 *
 * Example 1:
 *
 * Input: "abbxxxxzzy"
 * Output: [[3,6]]
 * Explanation: "xxxx" is the single large group with starting  3 and ending positions 6.
 * Example 2:
 *
 * Input: "abc"
 * Output: []
 * Explanation: We have "a","b" and "c" but no large group.
 * Example 3:
 *
 * Input: "abcdddeeeeaabbbcd"
 * Output: [[3,5],[6,9],[12,14]]
 *
 *
 * Note:  1 <= S.length <= 1000
 */
public class $830PositionsOfLargeGroups {

    public static void main(String[] args) {
    }

    /**
     * their concise solution of this problem
     * @param S
     * @return
     */
    static List<List<Integer>> largeGroupPositions2(String S) {
        List<List<Integer>> list = new ArrayList<>();
        char[] arr = S.toCharArray();
        for (int i=0,j=0;i<arr.length;i=j) {
            while (j<arr.length&&arr[i] == arr[j]) j++;
            if (j-i>=3) list.add(Arrays.asList(i,j-1));
        }
        return list;
    }

    /**
     * my solution of this problem
     * @param S
     * @return
     */
    static List<List<Integer>> largeGroupPositions(String S) {
        int[] table = new int[26];
        List<List<Integer>> list = new ArrayList<>();
        char[] arr = S.toCharArray();
        for (int i=1;i<arr.length;i++) {
            if (arr[i]!=arr[i-1]) {
                int start = table[arr[i-1]-'a'];
                if (i- start>=3) {
                    List<Integer> l = new ArrayList<>();
                    l.add(start);
                    l.add(i-1);
                    list.add(l);
                }
                table[arr[i]-'a'] = i;
            }
            if (i==arr.length-1) {
                int start = table[arr[i]-'a'];
                if (i- start>=2) {
                    List<Integer> l = new ArrayList<>();
                    l.add(start);
                    l.add(i);
                    list.add(l);
                }
            }
        }
        return list;
    }
}
