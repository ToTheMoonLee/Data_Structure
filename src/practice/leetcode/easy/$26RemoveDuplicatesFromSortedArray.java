package practice.leetcode.easy;

/**
 * 26. Remove Duplicates from Sorted Array
 * Easy
 *
 * 2087
 *
 * 4422
 *
 * Add to List
 *
 * Share
 * Given a sorted array nums, remove the duplicates in-place
 * such that each element appear only once and return the new length.
 *
 * Do not allocate extra space for another array,
 * you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * Example 1:
 *
 * Given nums = [1,1,2],
 *
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 *
 * It doesn't matter what you leave beyond the returned length.
 * Example 2:
 *
 * Given nums = [0,0,1,1,1,2,2,3,3,4],
 *
 * Your function should return length = 5,
 * with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.
 *
 * It doesn't matter what values are set beyond the returned length.
 * Clarification:
 *
 * Confused why the returned value is an integer but your answer is an array?
 *
 * Note that the input array is passed in by reference,
 * which means modification to the input array will be known to the caller as well.
 *
 * Internally you can think of this:
 *
 * // nums is passed in by reference. (i.e., without making a copy)
 * int len = removeDuplicates(nums);
 *
 * // any modification to nums in your function would be known by the caller.
 * // using the length returned by your function, it prints the first len elements.
 * for (int i = 0; i < len; i++) {
 *     print(nums[i]);
 * }
 */
public class $26RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        int[] arr = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
//        int result = removeDuplicates(arr);
//        int result = removeDuplicates2(arr);
        int result = removeDuplicates3(arr);

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < result; i++) {
            if (i == result - 1) {
                stringBuilder.append(arr[i]);
            } else {
                stringBuilder.append(arr[i]).append(",");
            }
        }
        stringBuilder.append("]");
        System.out.println(stringBuilder.toString());
    }

    /**
     * the official solution of this problem
     * <a href="https://leetcode.com/problems/remove-duplicates-from-sorted-array/solution/">
     * @param nums
     * @return
     */
    static int removeDuplicates3(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j=1;j<nums.length;j++) {
            if (nums[j]!=nums[i]) {
                nums[++i] = nums[j];
            }
        }
        return i+1;
    }

    /**
     * my improved solution of this problem
     * @param nums
     * @return
     */
    static int removeDuplicates2(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        int i=1;
        int min = nums[0];
        for (int j = 1; j < nums.length; j++) {
            if (min < nums[j]) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i++] = temp;
                min = temp;
            }
        }
        return i;
    }

    /**
     * my solution of this problem
     * @param nums
     * @return
     */
    static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        int min = nums[0];
        int max = nums[nums.length-1];
        int i=0;
        for (;i<nums.length-1;i++) {
            if (nums[i] == max) {
                return i+1;
            }
            for(int j=i+1;j<nums.length;j++) {
                if (min < nums[j]) {
                    int temp = nums[i+1];
                    nums[i+1] = nums[j];
                    nums[j] = temp;
                    min = nums[i+1];
                    break;
                }
            }
        }
        return i+1;
    }
}






























