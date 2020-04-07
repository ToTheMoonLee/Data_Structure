package practice.leetcode.easy;

/**
 * We define the Perfect Number is a positive integer that is equal to the sum of all its positive divisors except itself.
 *
 * Now, given an integer n, write a function that returns true when it is a perfect number and false when it is not.
 * Example:
 * Input: 28
 * Output: True
 * Explanation: 28 = 1 + 2 + 4 + 7 + 14
 * Note: The input number n will not exceed 100,000,000. (1e8)
 */
public class $507PerfectNumber {

    public static void main(String[] args) {
        System.out.println(checkPerfectNumber(28));
    }

    /**
     * my first solution of this problem
     * @param num
     * @return
     */
    static boolean checkPerfectNumber(int num) {
        if (num == 1) return false;
        int sum = 0;
        int d = (int)Math.sqrt(num);
        while (d>1) {
            if (num%d == 0) {
                sum = sum + d + num/d;
                if (sum > num) return false;
            }
            d--;
        }
        sum+=1;
        return sum == num;
    }
}
