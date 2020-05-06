package practice.leetcode.easy;

import practice.datastructure.util.PrintUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * For a non-negative integer X, the array-form of X is an array of its digits in left to right order.
 * For example, if X = 1231, then the array form is [1,2,3,1].
 *
 * Given the array-form A of a non-negative integer X, return the array-form of the integer X+K.
 *
 *
 *
 * Example 1:
 *
 * Input: A = [1,2,0,0], K = 34
 * Output: [1,2,3,4]
 * Explanation: 1200 + 34 = 1234
 * Example 2:
 *
 * Input: A = [2,7,4], K = 181
 * Output: [4,5,5]
 * Explanation: 274 + 181 = 455
 * Example 3:
 *
 * Input: A = [2,1,5], K = 806
 * Output: [1,0,2,1]
 * Explanation: 215 + 806 = 1021
 * Example 4:
 *
 * Input: A = [9,9,9,9,9,9,9,9,9,9], K = 1
 * Output: [1,0,0,0,0,0,0,0,0,0,0]
 * Explanation: 9999999999 + 1 = 10000000000
 *
 *
 * Note：
 *
 * 1 <= A.length <= 10000
 * 0 <= A[i] <= 9
 * 0 <= K <= 10000
 * If A.length > 1, then A[0] != 0
 */
public class $989AddToArrayFormOfInteger {

    public static void main(String[] args) {
        PrintUtil.printList2(addToArrayForm(new int[]{2,1,5},806));
        System.out.println("---------------------------");
        PrintUtil.printList2(addToArrayForm2(new int[]{2,1,5},806));
        System.out.println("---------------------------");
        PrintUtil.printList2(addToArrayForm3(new int[]{2,1,5},806));
    }

    /**
     * the official solution of this problem
     * @param A
     * @param K
     * @return
     */
    static List<Integer> addToArrayForm3(int[] A, int K) {
        int N = A.length;
        int cur = K;
        List<Integer> ans = new ArrayList();

        int i = N;
        while (--i >= 0 || cur > 0) {
            if (i >= 0)
                cur += A[i];
            ans.add(cur % 10);
            cur /= 10;
        }

        Collections.reverse(ans);
        return ans;
    }

    /**
     * their solution of this problem
     * @param A
     * @param K
     * @return
     */
    static List<Integer> addToArrayForm2(int[] A, int K) {
        List<Integer> ans = new LinkedList<>();
        for (int i = A.length-1;i>=0;i--) {
            ans.add(0,(K+A[i])%10);
            K = (K+A[i])/10;
        }
        while (K!=0) {
            ans.add(0,K%10);
            K/=10;
        }
        return ans;
    }

    /**
     * my solution of this problem
     * @param A
     * @param K
     * @return
     */
    static List<Integer> addToArrayForm(int[] A, int K) {
        List<Integer> ans = new LinkedList<>();
        int carry = 0;
        int i = A.length-1;
        while (K!=0 && i>=0) {
            int a = K%10;
            int temp = a+A[i]+carry;
            ans.add(0,temp%10);
            carry = temp/10;
            K/=10;
            i--;
        }
        while (K!=0) {
            int a = K%10;
            int temp = a+carry;
            ans.add(0,temp%10);
            carry = temp/10;
            K/=10;
        }
        for (;i>=0;i--) {
            int temp = A[i]+carry;
            ans.add(0,temp%10);
            carry = temp/10;
        }
        if (carry == 1) ans.add(0,1);
        return ans;
    }
}
