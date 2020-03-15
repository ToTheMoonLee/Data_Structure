package practice.leetcode.easy;

/**
 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
 *
 * Note:
 *
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 *
 * Example 1:
 *
 * Input: [2,2,1]
 * Output: 1
 * Example 2:
 *
 * Input: [4,1,2,1,2]
 * Output: 4
 */
public class $136SingleNumber {

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{4, 1, 2, 1, 2}));
    }

    /**
     * their amazing solution of this problem
     * @param nums
     * @return
     */
    static int singleNumber(int[] nums) {
        int ans =0;

        int len = nums.length;
        for(int i=0;i!=len;i++)
            ans ^= nums[i];

        return ans;

    }
}
