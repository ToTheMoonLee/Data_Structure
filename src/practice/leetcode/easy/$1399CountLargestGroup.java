package practice.leetcode.easy;

/**
 * Given an integer n. Each number from 1 to n is grouped according to the sum of its digits.
 *
 * Return how many groups have the largest size.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 13
 * Output: 4
 * Explanation: There are 9 groups in total,
 * they are grouped according sum of its digits of numbers from 1 to 13:
 * [1,10], [2,11], [3,12], [4,13], [5], [6], [7], [8], [9]. There are 4 groups with largest size.
 * Example 2:
 *
 * Input: n = 2
 * Output: 2
 * Explanation: There are 2 groups [1], [2] of size 1.
 * Example 3:
 *
 * Input: n = 15
 * Output: 6
 * Example 4:
 *
 * Input: n = 24
 * Output: 5
 *
 *
 * Constraints:
 *
 * 1 <= n <= 10^4
 */
public class $1399CountLargestGroup {

    public static void main(String[] args) {
        System.out.println(countLargestGroup(15));
    }

    static int countLargestGroup(int n) {
        int[] nums = new int[37];
        int size = 1;
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            int sum = getSum(i);
            nums[sum]++;
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > size) {
                ans = 0;
                size = nums[i];
            }
            if (nums[i] == size) {
                ans++;
            }
        }
        return ans;
    }

    static int getSum(int i) {
        int sum = 0;
        while (i != 0) {
            int a = i % 10;
            sum += a;
            i = i / 10;
        }
        return sum;
    }
}
