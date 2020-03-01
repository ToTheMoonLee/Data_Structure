package practice.leetcode.easy;

/**
 * Given two binary strings, return their sum (also a binary string).
 * <p>
 * The input strings are both non-empty and contains only characters 1 or 0.
 * <p>
 * Example 1:
 * <p>
 * Input: a = "11", b = "1"
 * Output: "100"
 * Example 2:
 * <p>
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 */
public class $67AddBinary {

    public static void main(String[] args) {
//        String a = "1010";
//        String b = "1011";
        String a = "11";
        String b = "1";
        String result = addBinary(a, b);
//        String result = addBinary2(a, b);
        System.out.println(result);
    }


    /**
     * their solution of this problem
     * <a href="https://leetcode.com/problems/add-binary/discuss/24488/Short-AC-solution-in-Java-with-explanation"/>
     *
     * @param a
     * @param b
     * @return
     */
    static String addBinary2(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0) {
            carry /= 2;
            if (i >= 0) {
                carry += (a.charAt(i--) - '0');
            }
            if (j >= 0) {
                carry += (b.charAt(j--) - '0');
            }
            sb.append(carry % 2);
        }
        if (carry != 0) {
            sb.append(carry / 2);
        }
        return sb.reverse().toString();
    }

    /**
     * my solution of this problem
     *
     * @param a
     * @param b
     * @return
     */
    static String addBinary(String a, String b) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;
        while (i >= 0 || j >= 0) {
            if (i >= 0 && a.charAt(i) == '1') {
                count++;
            }
            if (j >= 0 && b.charAt(j) == '1') {
                count++;
            }
            if (count % 2 == 0) {
                sb.insert(0, "0");
            } else {
                sb.insert(0, "1");
            }
            if (count >= 2) {
                count = 1;
            } else {
                count = 0;
            }
            i--;
            j--;
        }
        if (count == 1) {
            sb.insert(0, "1");
        }
        return sb.toString();
    }
}
