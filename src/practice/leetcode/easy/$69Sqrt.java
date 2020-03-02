package practice.leetcode.easy;

/**
 * Implement int sqrt(int x).
 *
 * Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
 *
 * Since the return type is an integer,
 * the decimal digits are truncated and only the integer part of the result is returned.
 *
 * Example 1:
 *
 * Input: 4
 * Output: 2
 * Example 2:
 *
 * Input: 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since
 *              the decimal part is truncated, 2 is returned.
 */
public class $69Sqrt {

    public static void main(String[] args) {
//        int i = mySqrt(2147395600);
//        int i = mySqrt2(2147395600);
        int i = mySqrt3(2147395600);
        System.out.println(i);
    }

    /**
     * the smart solution of this problem
     * <a href="https://leetcode.com/problems/sqrtx/discuss/25047/A-Binary-Search-Solution"/>
     * @param x
     * @return
     */
    static int mySqrt3(int x) {
        if (x == 0) {
            return 0;
        }
        int low = 1;
        int high = x;
        while (true) {
            int mid = low + (high - low) / 2;
            if (mid > x / mid) {
                high = mid - 1;
            } else {
                if (mid + 1 > x / (mid + 1)) {
                    return mid;
                }
                low = mid + 1;
            }
        }
    }

    /**
     * my second solution of this problem
     * @param x
     * @return
     */
    static int mySqrt2(int x) {
        long i = x / 2;
        while (i * i >= x) {
            if (i * i == x) {
                return (int)i;
            }
            i /= 2;
        }
        while (i*i<=x) {
            i++;
        }
        return (int)i-1;
    }

    /**
     * my first solution of this problem
     * @param x
     * @return
     */
    static int mySqrt(int x) {
        long i = 0;
        while (i*i<=x) {
            i++;
        }
        return (int)i-1;
    }
}
