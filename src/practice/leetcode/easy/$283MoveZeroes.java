package practice.leetcode.easy;

import practice.datastructure.util.PrintUtil;

/**
 * Given an array nums, write a function to move all 0's to the end of it
 * while maintaining the relative order of the non-zero elements.
 * <p>
 * Example:
 * <p>
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 * Note:
 * <p>
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 */
public class $283MoveZeroes {


    public static void main(String[] args) {
        int[] nums1 = new int[]{0, 1, 0, 3, 12};
        int[] nums2 = new int[]{0, 1, 0, 3, 12};
        moveZeroes(nums1);
        moveZeroes2(nums2);
        PrintUtil.printArr(nums1);
        PrintUtil.printArr(nums2);
    }

    /**
     * their solution of this problem
     *
     * @param nums
     */
    static void moveZeroes2(int[] nums) {
        if (nums == null || nums.length == 0) return;

        int insertPos = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[insertPos++] = nums[i];
            }
        }
        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }
    }

    /**
     * my solution of this problem
     *
     * @param nums
     */
    static void moveZeroes(int[] nums) {
        if (nums == null) return;
        int i = 0;
        int j = 0;
        while (j < nums.length) {
            if (nums[j] == 0) {
                j++;
                continue;
            } else if (i != j) {
//                int temp = nums[i];
//                nums[i] = nums[j];
//                nums[j] = temp;

                // some optimize
                nums[i] = nums[j];
                nums[j] = 0;
            }
            j++;
            i++;
        }
    }
}
