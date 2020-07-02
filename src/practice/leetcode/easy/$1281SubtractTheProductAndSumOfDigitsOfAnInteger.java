package practice.leetcode.easy;

/**
 * Given an integer number n,
 * return the difference between the product of its digits and the sum of its digits.
 *
 *
 * Example 1:
 *
 * Input: n = 234
 * Output: 15
 * Explanation:
 * Product of digits = 2 * 3 * 4 = 24
 * Sum of digits = 2 + 3 + 4 = 9
 * Result = 24 - 9 = 15
 * Example 2:
 *
 * Input: n = 4421
 * Output: 21
 * Explanation:
 * Product of digits = 4 * 4 * 2 * 1 = 32
 * Sum of digits = 4 + 4 + 2 + 1 = 11
 * Result = 32 - 11 = 21
 *
 *
 * Constraints:
 *
 * 1 <= n <= 10^5
 */
public class $1281SubtractTheProductAndSumOfDigitsOfAnInteger {

    public static void main(String[] args) {
        System.out.println(subtractProductAndSum(234));
    }

    /**
     * my solution of this problem
     * @param n
     * @return
     */
    static int subtractProductAndSum(int n) {
        int product = 1;
        int sum = 0;
        while (n != 0) {
            int a = n%10;
            product *=a;
            sum += a;
            n/=10;
        }
        return product - sum;
    }
}
