package practice.leetcode.easy;

import practice.datastructure.util.PrintUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * We are given a list nums of integers representing a list compressed with run-length encoding.
 *
 * Consider each adjacent pair of elements [freq, val] = [nums[2*i],
 * nums[2*i+1]] (with i >= 0).  For each such pair,
 * there are freq elements with value val concatenated in a sublist.
 * Concatenate all the sublists from left to right to generate the decompressed list.
 *
 * Return the decompressed list.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4]
 * Output: [2,4,4,4]
 * Explanation: The first pair [1,2] means we have freq = 1 and val = 2 so we generate the array [2].
 * The second pair [3,4] means we have freq = 3 and val = 4 so we generate [4,4,4].
 * At the end the concatenation [2] + [4,4,4] is [2,4,4,4].
 * Example 2:
 *
 * Input: nums = [1,1,2,3]
 * Output: [1,3,3]
 *
 *
 * Constraints:
 *
 * 2 <= nums.length <= 100
 * nums.length % 2 == 0
 * 1 <= nums[i] <= 100
 */
public class $1313DecompressRunLengthEncodedList {

    public static void main(String[] args) {
        PrintUtil.printArr(decompressRLElist(new int[]{1, 1, 2, 3}));
        System.out.println(" ------------------------ ");
        PrintUtil.printArr(decompressRLElist2(new int[]{1, 1, 2, 3}));
    }

    /**
     * their faster solution of this problem
     * @param nums
     * @return
     */
    static int[] decompressRLElist2(int[] nums) {
        int[] ans;
        int size = 0;
        for (int i=0;i<nums.length;i+=2) {
            size += nums[i];
        }
        ans = new int[size];
        int j = 0;
        for (int i=0;i<nums.length;i+=2) {
            Arrays.fill(ans,j,j+nums[i],nums[i+1]);
            j+=nums[i];
        }
        return ans;
    }

    /**
     * my first solution of this problem
     * @param nums
     * @return
     */
    static int[] decompressRLElist(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for (int i=0;i<nums.length;i+=2) {
            int n = nums[i];
            for (int j = 0;j<n;j++) {
                ans.add(nums[i+1]);
            }
        }
        return ans.stream().mapToInt(i->i).toArray();
    }
}
