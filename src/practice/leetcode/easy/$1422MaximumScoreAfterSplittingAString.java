package practice.leetcode.easy;

/**
 * Given a string s of zeros and ones, return the maximum score after
 * splitting the string into two non-empty substrings (i.e. left substring and right substring).
 *
 * The score after splitting a string is the number of zeros
 * in the left substring plus the number of ones in the right substring.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "011101"
 * Output: 5
 * Explanation:
 * All possible ways of splitting s into two non-empty substrings are:
 * left = "0" and right = "11101", score = 1 + 4 = 5
 * left = "01" and right = "1101", score = 1 + 3 = 4
 * left = "011" and right = "101", score = 1 + 2 = 3
 * left = "0111" and right = "01", score = 1 + 1 = 2
 * left = "01110" and right = "1", score = 2 + 1 = 3
 * Example 2:
 *
 * Input: s = "00111"
 * Output: 5
 * Explanation: When left = "00" and right = "111", we get the maximum score = 2 + 3 = 5
 * Example 3:
 *
 * Input: s = "1111"
 * Output: 3
 *
 *
 * Constraints:
 *
 * 2 <= s.length <= 500
 * The string s consists of characters '0' and '1' only.
 */
public class $1422MaximumScoreAfterSplittingAString {

    public static void main(String[] args) {
        System.out.println(maxScore("011101"));
        System.out.println(maxScore2("011101"));
    }

    /**
     * their concise solution of this problem
     * @param s
     * @return
     */
    static int maxScore2(String s) {
        int zeros = 0, ones = 0, max = Integer.MIN_VALUE;
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i) == '0') zeros++; else ones++;
            if(i != s.length()-1) max = Math.max(zeros - ones, max);
        }
        return max + ones;
    }

    /**
     * my solution of this problem
     * @param s
     * @return
     */
    static int maxScore(String s) {
        int[] zeros = new int[s.length()];
        int[] ones = new int[s.length()];
        char[] cArr = s.toCharArray();
        for (int i=0;i<cArr.length;i++) {
            if (i==0) {
                zeros[i] = cArr[i]=='0' ? 1 : 0;
                ones[ones.length-1-i] = cArr[i]=='1' ? 1 : 0;
            } else {
                zeros[i] = cArr[i]=='0' ? (zeros[i-1] + 1) : zeros[i-1];
                ones[ones.length-1-i] = cArr[i]=='1' ? (ones[ones.length-i] + 1) : ones[ones.length-i];
            }
        }
        int ans = Integer.MIN_VALUE;
        for (int i=0;i<zeros.length-1;i++) {
            ans = Math.max(ans,zeros[i]+ones[i+1]);
        }
        return ans;
    }
}
