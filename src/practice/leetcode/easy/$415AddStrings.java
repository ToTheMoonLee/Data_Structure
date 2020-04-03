package practice.leetcode.easy;

/**
 * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
 *
 * Note:
 *
 * The length of both num1 and num2 is < 5100.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
public class $415AddStrings {

    public static void main(String[] args) {
        System.out.println(addStrings("1", "9"));
        System.out.println(addStrings2("1", "9"));
    }

    /**
     * their straightforward solution of this problem
     * @param num1
     * @param num2
     * @return
     */
    static String addStrings2(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i=num1.length()-1,j=num2.length()-1;i>=0||j>=0||carry == 1;i--,j--) {
            int n1 = i<0 ? 0:num1.charAt(i)-'0';
            int n2 = j<0 ? 0:num2.charAt(j)-'0';
            sb.append((n1+n2+carry)%10);
            carry = (n1+n2+carry)/10;
        }
        return sb.reverse().toString();
    }

    /**
     * my first solution of this problem
     * @param num1
     * @param num2
     * @return
     */
    static String addStrings(String num1, String num2) {
        StringBuilder sb  = new StringBuilder();
        int extra = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        while (i >= 0 && j >= 0) {
            int n1 = num1.charAt(i) - '0';
            int n2 = num2.charAt(j) - '0';
            int sum = n1 + n2 + extra;
            if (sum >= 10) {
                extra = 1;
            } else {
                extra = 0;
            }
            sb.append(sum % 10);
            i--;
            j--;
        }
        while (i >= 0) {
            int n1 = num1.charAt(i) - '0';
            int sum = n1 + extra;
            if (sum >= 10) {
                extra = 1;
            } else {
                extra = 0;
            }
            sb.append(sum % 10);
            i--;
        }
        while (j >= 0) {
            int n2 = num2.charAt(j) - '0';
            int sum = n2 + extra;
            if (sum >= 10) {
                extra = 1;
            } else {
                extra = 0;
            }
            sb.append(sum % 10);
            j--;
        }
        if (extra == 1) sb.append(1);
        return sb.reverse().toString();
    }
}
