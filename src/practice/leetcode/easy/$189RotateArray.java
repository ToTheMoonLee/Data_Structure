package practice.leetcode.easy;

/**
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3,4,5,6,7] and k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 * Example 2:
 * <p>
 * Input: [-1,-100,3,99] and k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 * Note:
 * <p>
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 * Could you do it in-place with O(1) extra space?
 */
public class $189RotateArray {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
//        rotate(nums, 3);
//        rotate2(nums, 3);
//        rotate3(nums, 3);
        rotate4(nums, 3);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    /**
     * the official solution of this problem
     * @param nums
     * @param k
     */
    static void rotate4(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    /**
     * my third solution of this problem
     *
     * @param nums
     * @param k
     */
    static void rotate3(int[] nums, int k) {
        k = k % nums.length;
        while (k > 0) {
            int temp = nums[nums.length - 1];
            for (int i = nums.length - 1; i > 0; i--) {
                nums[i] = nums[i - 1];
            }
            nums[0] = temp;
            k--;
        }
    }

    /**
     * my second solution of this problem
     *
     * @param nums
     * @param k
     */
    static void rotate2(int[] nums, int k) {
        k = k % nums.length;
        int[] temp = new int[nums.length];
        int j = 0;
        for (int i = nums.length - k; i < nums.length; i++) {
            temp[j++] = nums[i];
        }
        for (int i = 0; i < nums.length - k; i++) {
            temp[j++] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = temp[i];
        }
    }

    /**
     * my first solution of this problem
     *
     * @param nums
     * @param k
     */
    static void rotate(int[] nums, int k) {
        k = k % nums.length;
        int[] leftK = new int[nums.length - k];
        int[] rightK = new int[k];
        for (int i = 0; i < leftK.length; i++) {
            leftK[i] = nums[i];
        }
        int j = 0;
        for (int i = leftK.length; i < nums.length; i++) {
            rightK[j++] = nums[i];
        }
        for (int i = 0; i < rightK.length; i++) {
            nums[i] = rightK[i];
        }
        j = 0;
        for (int i = rightK.length; i < nums.length; i++) {
            nums[i] = leftK[j++];
        }
    }
}
