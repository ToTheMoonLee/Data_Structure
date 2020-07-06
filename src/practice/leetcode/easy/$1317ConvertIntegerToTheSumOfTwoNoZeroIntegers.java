package practice.leetcode.easy;

import practice.datastructure.util.PrintUtil;

/**
 * Given an integer n. No-Zero integer is a positive integer
 * which doesn't contain any 0 in its decimal representation.
 *
 * Return a list of two integers [A, B] where:
 *
 * A and B are No-Zero integers.
 * A + B = n
 * It's guarateed that there is at least one valid solution.
 * If there are many valid solutions you can return any of them.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: [1,1]
 * Explanation: A = 1, B = 1. A + B = n and both A and B don't contain any 0 in their decimal representation.
 * Example 2:
 *
 * Input: n = 11
 * Output: [2,9]
 * Example 3:
 *
 * Input: n = 10000
 * Output: [1,9999]
 * Example 4:
 *
 * Input: n = 69
 * Output: [1,68]
 * Example 5:
 *
 * Input: n = 1010
 * Output: [11,999]
 *
 *
 * Constraints:
 *
 * 2 <= n <= 10^4
 */
public class $1317ConvertIntegerToTheSumOfTwoNoZeroIntegers {

    public static void main(String[] args) {
        PrintUtil.printArr(getNoZeroIntegers(69));
        System.out.println("-----------------------");
        PrintUtil.printArr(getNoZeroIntegers2(69));
        System.out.println("-----------------------");
        PrintUtil.printArr(getNoZeroIntegers3(69));
    }

    /**
     * their concise and faster solution of this problem
     * @param n
     * @return
     */
    static int[] getNoZeroIntegers3(int n) {
        int a=0, b=0, step=1;
        while (n>0) {
            int d = n % 10; // digit
            n /= 10;
            if ((d == 0 || d == 1) && n>0) { // n>0 evades the case when 1 is the most significant digit
                a += step*(1+d);
                b += step*9;
                n--; // handle carry
            } else {
                a += step*1;
                b += step*(d-1);
            }
            step *= 10;
        }
        return new int[]{a,b};
    }

    /**
     * my second solution of this problem
     * @param n
     * @return
     */
    static int[] getNoZeroIntegers2(int n) {
        int[] ans = new int[2];
        int a1 = 0;
        int a2 = 0;
        int multi = 1;
        while (n!=0) {
            int carry = n % 10;
            n /= 10;
            if (carry == 0 && n>0) {
                a1 += 1*multi;
                a2 += 9*multi;
                n--;
            } else if (carry == 1 && n>0) {
                a1 += 2*multi;
                a2 += 9*multi;
                n--;
            } else {
                a1 += 1*multi;
                a2 += (carry-1)*multi;
            }
            multi*=10;
        }
        ans[0] = a1;
        ans[1] = a2;
        return ans;
    }

    /**
     * my first solution of this problem
     * @param n
     * @return
     */
    static int[] getNoZeroIntegers(int n) {
        int[] ans = new int[2];
        for (int i=1;i<n;i++) {
            if (isValid(i) && isValid(n-i)) {
                ans[0] = i;
                ans[1] = n-i;
            }
        }
        return ans;
    }

    static boolean isValid(int n) {
        while (n!=0) {
            if (n % 10 == 0) {
                return false;
            }
            n /= 10;
        }
        return true;
    }
}
