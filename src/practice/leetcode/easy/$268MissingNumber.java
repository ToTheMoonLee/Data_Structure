package practice.leetcode.easy;

/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n,
 * find the one that is missing from the array.
 *
 * Example 1:
 *
 * Input: [3,0,1]
 * Output: 2
 * Example 2:
 *
 * Input: [9,6,4,2,3,5,7,0,1]
 * Output: 8
 * Note:
 * Your algorithm should run in linear runtime complexity.
 * Could you implement it using only constant extra space complexity?
 */
public class $268MissingNumber {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 0, 1};
        System.out.println(missingNumber(nums));
        System.out.println(missingNumber2(nums));
        System.out.println(missingNumber3(nums));
    }

    /**
     * their solution of this problem
     * @param nums
     * @return
     */
    static int missingNumber3(int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }

    /**
     * my second solution of this problem
     * @param nums
     * @return
     */
    static int missingNumber2(int[] nums) {
        int total = 0;
        int numsTotal = 0;
        for (int i=0;i<nums.length;i++) {
            total+=i;
            numsTotal+=nums[i];
        }
        total += nums.length;
        return total-numsTotal;
    }

    /**
     * my solution of this problem
     * @param nums
     * @return
     */
    static int missingNumber(int[] nums) {
        boolean[] b = new boolean[nums.length+1];
        for (int i=0;i<nums.length;i++) {
            b[nums[i]] = true;
        }
        for (int i=0;i<b.length;i++) {
            if (!b[i]) return i;
        }
        return 0;
    }
}
