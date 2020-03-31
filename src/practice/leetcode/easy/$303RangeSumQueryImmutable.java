package practice.leetcode.easy;

/**
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 *
 * Example:
 * Given nums = [-2, 0, 3, -5, 2, -1]
 *
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * Note:
 * You may assume that the array does not change.
 * There are many calls to sumRange function.
 */
public class $303RangeSumQueryImmutable {

    public static void main(String[] args) {
        NumArray2 numArray = new NumArray2(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(numArray.sumRange(0,2));
        System.out.println(numArray.sumRange(2,5));
        System.out.println(numArray.sumRange(0,5));
    }

    /**
     * my second solution of this problem
     */
    static class NumArray2 {
        private int[] sumArr;
        public NumArray2(int[] nums) {
            sumArr = new int[nums.length+1];
            for (int i=0;i<nums.length;i++) {
                sumArr[i+1] = sumArr[i] + nums[i];
            }
        }

        public int sumRange(int i, int j) {
            return sumArr[j+1] - sumArr[i];
        }
    }

    /**
     * my first solution of this problem
     */
    static class NumArray {
        private int[] nums;
        public NumArray(int[] nums) {
            this.nums = nums;
        }

        public int sumRange(int i, int j) {
            int sum = 0;
            while (i<=j) {
                sum+=nums[i++];
            }
            return sum;
        }
    }

}
