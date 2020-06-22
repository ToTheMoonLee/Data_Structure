package practice.leetcode.easy;

import java.util.Stack;

/**
 * Balanced strings are those who have equal quantity of 'L' and 'R' characters.
 *
 * Given a balanced string s split it in the maximum amount of balanced strings.
 *
 * Return the maximum amount of splitted balanced strings.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "RLRRLLRLRL"
 * Output: 4
 * Explanation: s can be split into "RL", "RRLL", "RL", "RL",
 * each substring contains same number of 'L' and 'R'.
 * Example 2:
 *
 * Input: s = "RLLLLRRRLR"
 * Output: 3
 * Explanation: s can be split into "RL", "LLLRRR", "LR",
 * each substring contains same number of 'L' and 'R'.
 * Example 3:
 *
 * Input: s = "LLLLRRRR"
 * Output: 1
 * Explanation: s can be split into "LLLLRRRR".
 * Example 4:
 *
 * Input: s = "RLRRRLLRLL"
 * Output: 2
 * Explanation: s can be split into "RL", "RRRLLRLL",
 * since each substring contains an equal number of 'L' and 'R'
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * s[i] = 'L' or 'R'
 */
public class $1221SplitAStringInBalancedStrings {

    public static void main(String[] args) {
        System.out.println(balancedStringSplit("RLRRRLLRLL"));
        System.out.println(balancedStringSplit2("RLRRRLLRLL"));
    }

    /**
     * their concise solution of this problem
     * @param s
     * @return
     */
    static int balancedStringSplit2(String s) {
        int res = 0, cnt = 0;
        for (int i = 0; i < s.length(); ++i) {
            cnt += s.charAt(i) == 'L' ? 1 : -1;
            if (cnt == 0) ++res;
        }
        return res;
    }

    /**
     * my solution of this problem
     * @param s
     * @return
     */
    static int balancedStringSplit(String s) {
        char[] chars = s.toCharArray();
        int r = 0;
        int l = 0;
        int ans = 0;
        for (char c : chars) {
            if ('R' == c) {
                r++;
            }
            if ('L' == c) {
                l++;
            }
            if (r == l) {
                ans++;
                l=0;
                r=0;
            }
        }
        return ans;
    }
}
