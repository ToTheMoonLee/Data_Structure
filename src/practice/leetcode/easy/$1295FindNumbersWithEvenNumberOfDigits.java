package practice.leetcode.easy;

/**
 * Given an array nums of integers, return how many of them contain an even number of digits.
 *
 *
 * Example 1:
 *
 * Input: nums = [12,345,2,6,7896]
 * Output: 2
 * Explanation:
 * 12 contains 2 digits (even number of digits).
 * 345 contains 3 digits (odd number of digits).
 * 2 contains 1 digit (odd number of digits).
 * 6 contains 1 digit (odd number of digits).
 * 7896 contains 4 digits (even number of digits).
 * Therefore only 12 and 7896 contain an even number of digits.
 * Example 2:
 *
 * Input: nums = [555,901,482,1771]
 * Output: 1
 * Explanation:
 * Only 1771 contains an even number of digits.
 *
 *
 * Constraints:
 *
 * 1 <= nums.length <= 500
 * 1 <= nums[i] <= 10^5
 */
public class $1295FindNumbersWithEvenNumberOfDigits {

    public static void main(String[] args) {
        System.out.println(findNumbers(new int[]{12, 345, 2, 6, 7896}));
        System.out.println(findNumbers2(new int[]{12, 345, 2, 6, 7896}));
    }

    /**
     * their a little cute solution of this problem
     * @param nums
     * @return
     */
    static int findNumbers2(int[] nums) {
        int count=0;
        for(int i =0 ; i< nums.length; i++){
            if((nums[i]>9 && nums[i]<100) || (nums[i]>999 && nums[i]<10000) || (nums[i]>99999 && nums[i]<1000000)){
                count++;
            }
        }
        return count;
    }

    /**
     * my first solution of this problem
     * @param nums
     * @return
     */
    static int findNumbers(int[] nums) {
        int ans = 0;
        for (int i : nums) {
            ans+= isEven(i) ? 1 : 0;
        }
        return ans;
    }

    static boolean isEven(int num) {
        int count = 0;
        while (num!=0) {
            num /= 10;
            count++;
        }
        return count%2 == 0;
    }
}
