package practice.leetcode.easy;

/**
 * Given a binary array, find the maximum number of consecutive 1s in this array.
 *
 * Example 1:
 * Input: [1,1,0,1,1,1]
 * Output: 3
 * Explanation: The first two digits or the last three digits are consecutive 1s.
 *     The maximum number of consecutive 1s is 3.
 * Note:
 *
 * The input array will only contain 0 and 1.
 * The length of input array is a positive integer and will not exceed 10,000
 */
public class $485MaxConsecutiveOnes {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 0, 1, 1, 1};
        System.out.println(findMaxConsecutiveOnes(nums));
        System.out.println(findMaxConsecutiveOnes2(nums));
        System.out.println(findMaxConsecutiveOnes3(nums));
    }

    /**
     * their concise solution of this problem
     * @param nums
     * @return
     */
    static int findMaxConsecutiveOnes3(int[] nums) {
        int maxHere = 0, max = 0;
        for (int n : nums)
            max = Math.max(max, maxHere = n == 0 ? 0 : maxHere + 1);
        return max;
    }

    /**
     * their faster solution of this problem
     * @param nums
     * @return
     */
    static int findMaxConsecutiveOnes2(int[] nums) {
        int count=0;
        int max=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==1)
            {
                count++;
            }
            else
            {
                if(max<count)
                    max=count;

                count=0;
            }
        }
        return Math.max(max,count);
    }

    /**
     * my solution of this problem
     * @param nums
     * @return
     */
    static int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int i = 0;
        int cur = 0;
        while (i<nums.length) {
            if (nums[i] == 1) cur++;
            else cur=0;
            if (cur > max) max = cur;
            i++;
        }
        return max;
    }
}
