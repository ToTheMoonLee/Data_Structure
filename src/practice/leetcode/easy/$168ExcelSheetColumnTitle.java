package practice.leetcode.easy;

/**
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 *
 * For example:
 *
 *     1 -> A
 *     2 -> B
 *     3 -> C
 *     ...
 *     26 -> Z
 *     27 -> AA
 *     28 -> AB
 *     ...
 * Example 1:
 *
 * Input: 1
 * Output: "A"
 * Example 2:
 *
 * Input: 28
 * Output: "AB"
 * Example 3:
 *
 * Input: 701
 * Output: "ZY"
 */
public class $168ExcelSheetColumnTitle {

    public static void main(String[] args) {
        System.out.println(convertToTitle(52));
        System.out.println(converToTitle2(52));
    }

    /**
     * their solution of this problem
     * @param n
     * @return
     */
    static String converToTitle2(int n) {
        StringBuilder result = new StringBuilder();

        while(n>0){
            n--;
            result.append((char)('A' + n % 26));
            n /= 26;
        }

        return result.reverse().toString();
    }

    /**
     * my solution of this problem
     * @param n
     * @return
     */
    static String convertToTitle(int n) {
        char a = 'A';
        StringBuilder sb = new StringBuilder();
        while (n / 26 > 0 && n != 26) {
            int temp = n % 26;
            if (n % 26 == 0) {
                sb.append((char) (a + 25));
                n = n/26-1;
            } else {
                sb.append((char) (a + temp-1));
                n /= 26;
            }

        }
        sb.append((char) (a + n - 1));
        return sb.reverse().toString();
    }
}
