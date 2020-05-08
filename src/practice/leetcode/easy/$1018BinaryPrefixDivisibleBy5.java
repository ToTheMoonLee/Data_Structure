package practice.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array A of 0s and 1s, consider N_i:
 * the i-th subarray from A[0] to A[i] interpreted as a binary number
 * (from most-significant-bit to least-significant-bit.)
 *
 * Return a list of booleans answer, where answer[i] is true if and only if N_i is divisible by 5.
 *
 * Example 1:
 *
 * Input: [0,1,1]
 * Output: [true,false,false]
 * Explanation:
 * The input numbers in binary are 0, 01, 011; which are 0, 1,
 * and 3 in base-10.  Only the first number is divisible by 5, so answer[0] is true.
 * Example 2:
 *
 * Input: [1,1,1]
 * Output: [false,false,false]
 * Example 3:
 *
 * Input: [0,1,1,1,1,1]
 * Output: [true,false,false,false,true,false]
 * Example 4:
 *
 * Input: [1,1,1,0,1]
 * Output: [false,false,false,false,false]
 *
 *
 * Note:
 *
 * 1 <= A.length <= 30000
 * A[i] is 0 or 1
 */
public class $1018BinaryPrefixDivisibleBy5 {

    public static void main(String[] args) {
        System.out.println(prefixesDivBy5(new int[]{0,1,1,1,1,1}));
    }

    /**
     * with the hint of other one,I figure out this solution of this problem finally
     * <a href=https://leetcode.com/problems/binary-prefix-divisible-by-5/discuss/296249/Java-solution-with-best-explanation(don't-know-why-some-explanation-not-concise)/>
     */
    static List<Boolean> prefixesDivBy5(int[] A) {
        int b = 0;
        List<Boolean> ans = new ArrayList<>();
        for (int i=0;i<A.length;i++) {
            b = b<<1;
            b |= A[i];
            b = b%5;
            ans.add(b==0);
        }
        return ans;
    }
}
