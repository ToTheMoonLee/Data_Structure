package practice.leetcode.easy;

/**
 * ven a sorted (in ascending order) integer array nums of n elements and a target value,
 * write a function to search target in nums. If target exists, then return its index, otherwise return -1.
 *
 *
 * Example 1:
 *
 * Input: nums = [-1,0,3,5,9,12], target = 9
 * Output: 4
 * Explanation: 9 exists in nums and its index is 4
 *
 * Example 2:
 *
 * Input: nums = [-1,0,3,5,9,12], target = 2
 * Output: -1
 * Explanation: 2 does not exist in nums so return -1
 */
public class $704BinarySearch {

    public static void main(String[] args) {
        System.out.println(search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
    }

    /**
     * my solution of this problem
     * @param nums
     * @param target
     * @return
     */
    static int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length-1;
        while (l<=r) {
            int mid = l + (r-l)/2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) l = mid+1;
            else r = mid-1;
        }
        return -1;
    }
}
