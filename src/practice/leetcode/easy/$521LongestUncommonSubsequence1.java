package practice.leetcode.easy;

/**
 * Given a group of two strings, you need to find the longest uncommon subsequence of this group of two strings.
 * The longest uncommon subsequence is defined as the longest subsequence of one of these strings and this subsequence
 * should not be any subsequence of the other strings.
 *
 * A subsequence is a sequence that can be derived from one sequence by deleting some characters
 * without changing the order of the remaining elements. Trivially, any string is a subsequence
 * of itself and an empty string is a subsequence of any string.
 *
 * The input will be two strings, and the output needs to be the length of the longest uncommon subsequence.
 * If the longest uncommon subsequence doesn't exist, return -1.
 *
 * Example 1:
 * Input: "aba", "cdc"
 * Output: 3
 * Explanation: The longest uncommon subsequence is "aba" (or "cdc"),
 * because "aba" is a subsequence of "aba",
 * but not a subsequence of any other strings in the group of two strings.
 * Note:
 *
 * Both strings' lengths will not exceed 100.
 * Only letters from a ~ z will appear in input strings.
 */
public class $521LongestUncommonSubsequence1 {

    public static void main(String[] args) {
        System.out.println(findLUSlength("abs","abd"));
        System.out.println(findLUSlength("abs","abs"));
        System.out.println("-----------------------");
        System.out.println(findLUSlength2("abs","abd"));
        System.out.println(findLUSlength2("abs","abs"));
    }

    /**
     * their one line solution of this problem
     * @param a
     * @param b
     * @return
     */
    static int findLUSlength2(String a, String b) {
        return b.equals(a) ? -1 : Math.max(a.length(), b.length());
    }

    /**
     * my solution of this problem
     * @param a
     * @param b
     * @return
     */
    static int findLUSlength(String a, String b) {
        int l1 = a.length();
        int l2 = b.length();
        if (l1 > l2) return l1;
        if (l2 > l1) return l2;
        else return b.equals(a) ? -1 : l1;
    }
}
