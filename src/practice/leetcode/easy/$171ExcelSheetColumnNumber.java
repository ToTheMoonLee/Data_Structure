package practice.leetcode.easy;

/**
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 *
 * For example:
 *
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28
 *     ...
 * Example 1:
 *
 * Input: "A"
 * Output: 1
 * Example 2:
 *
 * Input: "AB"
 * Output: 28
 * Example 3:
 *
 * Input: "ZY"
 * Output: 701
 */
public class $171ExcelSheetColumnNumber {

    public static void main(String[] args) {
        System.out.println(titleToNumber("ZY"));
    }

    /**
     * my solution of this problem
     * @param s
     * @return
     */
    static int titleToNumber(String s) {
        int size = s.length();
        int result = 0;
        for (int i=0;i<size;i++) {
            int a = s.charAt(i) - 'A' + 1;
            result += a * Math.pow(26,size -i-1);
        }
        return result;
    }
}
