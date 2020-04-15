package practice.leetcode.easy;

/**
 * Give a string s, count the number of non-empty (contiguous) substrings that have the same number of 0's and 1's,
 * and all the 0's and all the 1's in these substrings are grouped consecutively.
 *
 * Substrings that occur multiple times are counted the number of times they occur.
 *
 * Example 1:
 * Input: "00110011"
 * Output: 6
 * Explanation: There are 6 substrings that have equal number of consecutive 1's and 0's:
 * "0011", "01", "1100", "10", "0011", and "01".
 *
 * Notice that some of these substrings repeat and are counted the number of times they occur.
 *
 * Also, "00110011" is not a valid substring because all the 0's (and 1's) are not grouped together.
 * Example 2:
 * Input: "10101"
 * Output: 4
 * Explanation: There are 4 substrings: "10", "01", "10", "01" that have equal number of consecutive 1's and 0's.
 * Note:
 *
 * s.length will be between 1 and 50,000.
 * s will only consist of "0" or "1" characters.
 */
public class $696CountBinarySubstrings {

    public static void main(String[] args) {
        System.out.println(countBinarySubstrings("00110011"));
    }

    /**
     * my solution of this problem
     * @param s
     * @return
     */
    static int countBinarySubstrings(String s) {
        int zeros = 0;
        int ones = 0;
        int count = 0;
        char[] arr = s.toCharArray();
        for (int i=0;i<arr.length;i++) {
            char a = arr[i];
            if (i>0 && a !=arr[i-1]) {
                count += Math.min(zeros,ones);
                if (a == '0') zeros = 0;
                else ones = 0;
            }
            if (a == '0') zeros++;
            if (a == '1') ones++;
        }
        count += Math.min(zeros,ones);
        return count;
    }
}
