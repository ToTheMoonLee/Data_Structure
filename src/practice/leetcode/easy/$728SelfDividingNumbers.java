package practice.leetcode.easy;

import practice.datastructure.util.PrintUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * A self-dividing number is a number that is divisible by every digit it contains.
 *
 * For example, 128 is a self-dividing number because 128 % 1 == 0, 128 % 2 == 0, and 128 % 8 == 0.
 *
 * Also, a self-dividing number is not allowed to contain the digit zero.
 *
 * Given a lower and upper number bound, output a list of every possible self dividing number,
 * including the bounds if possible.
 *
 * Example 1:
 * Input:
 * left = 1, right = 22
 * Output: [1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22]
 * Note:
 *
 * The boundaries of each input argument are 1 <= left <= right <= 10000.
 */
public class $728SelfDividingNumbers {

    public static void main(String[] args) {
        PrintUtil.printList2(selfDividingNumbers(1, 22));
    }

    /**
     * my solution of this problem
     * @param left
     * @param right
     * @return
     */
    static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        while (left <=right) {
            if (isValid(left)) result.add(left);
            left++;
        }
        return result;
    }

    static boolean isValid(int num) {
        int temp = num;
        while (temp!=0) {
            int d = temp%10;
            if (d == 0 || num%d!=0) return false;
            temp/=10;
        }
        return true;
    }
}
