package practice.leetcode.easy;

import practice.datastructure.util.PrintUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given the array nums, obtain a subsequence of the array whose sum of elements
 * is strictly greater than the sum of the non included elements in such subsequence.
 * <p>
 * If there are multiple solutions, return the subsequence with minimum size
 * and if there still exist multiple solutions, return the subsequence with the maximum total sum
 * of all its elements. A subsequence of an array can be obtained
 * by erasing some (possibly zero) elements from the array.
 * <p>
 * Note that the solution with the given constraints is guaranteed to be unique.
 * Also return the answer sorted in non-increasing order.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [4,3,10,9,8]
 * Output: [10,9]
 * Explanation: The subsequences [10,9] and [10,8] are minimal such that the sum of their elements
 * is strictly greater than the sum of elements not included, however,
 * the subsequence [10,9] has the maximum total sum of its elements.
 * Example 2:
 * <p>
 * Input: nums = [4,4,7,6,7]
 * Output: [7,7,6]
 * Explanation: The subsequence [7,7] has the sum of its elements equal to 14
 * which is not strictly greater than the sum of elements not included (14 = 4 + 4 + 6).
 * Therefore, the subsequence [7,6,7] is the minimal satisfying the conditions. Note the subsequence has to returned in non-decreasing order.
 * Example 3:
 * <p>
 * Input: nums = [6]
 * Output: [6]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 500
 * 1 <= nums[i] <= 100
 */
public class $1403MinimumSubsequenceInNonIncreasingOrder {

    public static void main(String[] args) {
        PrintUtil.printList2(minSubsequence(new int[]{4, 4, 7, 6, 7}));
    }

    static List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        List<Integer> ans = new ArrayList<>();
        int half = sum / 2;
        sum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            sum += nums[i];
            ans.add(nums[i]);
            if (sum > half) {
                break;
            }
        }
        return ans;
    }
}
