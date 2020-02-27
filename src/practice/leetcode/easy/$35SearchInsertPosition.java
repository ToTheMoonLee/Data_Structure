package practice.leetcode.easy;

/**
 * Given a sorted array and a target value,
 * return the index if the target is found. If not,
 * return the index where it would be if it were inserted in order.
 *
 * You may assume no duplicates in the array.
 *
 * Example 1:
 *
 * Input: [1,3,5,6], 5
 * Output: 2
 * Example 2:
 *
 * Input: [1,3,5,6], 2
 * Output: 1
 * Example 3:
 *
 * Input: [1,3,5,6], 7
 * Output: 4
 * Example 4:
 *
 * Input: [1,3,5,6], 0
 * Output: 0
 */
public class $35SearchInsertPosition {

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 2));
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 7));
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 0));
    }

    /**
     * binary search
     * @param nums
     * @param target
     * @return
     */
    static int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int middle = 0;
        while (start <= end) {
            middle = start + (end - start) / 2;
            if (nums[middle] == target) return middle;
            if (target < nums[middle]) {
                end = middle - 1;
            } else {
                start = middle + 1;
            }
        }
        return start;
    }
}
