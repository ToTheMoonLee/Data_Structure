package practice.leetcode.medium.recursionanddivision;

/**
 * Share
 * Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
 *
 * example:
 *
 * Input: x = 2.00000, n = 10
 * Output: 1024.00000
 */
public class $50Powxn {

    public static void main(String[] args) {
        System.out.println(myPow(2, 10));
    }

    /**
     * their solution of this problem
     * @param x
     * @param n
     * @return
     */
    static double myPow(double x, int n) {
        if (n == 0) return 1;
        if(n == Integer.MIN_VALUE){
            x = x * x;
            n = n/2;
        }
        if (n < 0) {
            x = 1/x;
            n = -n;
        }
        return n%2 == 0 ? myPow(x*x,n/2) : x * myPow(x*x,n/2);
    }
}
