package practice.leetcode.easy;

import practice.datastructure.util.PrintUtil;

import java.util.LinkedList;

/**
 * Given two arrays of integers nums and index.
 * Your task is to create target array under the following rules:
 *
 * Initially target array is empty.
 * From left to right read nums[i] and index[i], insert at index index[i] the value nums[i] in target array.
 * Repeat the previous step until there are no elements to read in nums and index.
 * Return the target array.
 *
 * It is guaranteed that the insertion operations will be valid.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [0,1,2,3,4], index = [0,1,2,2,1]
 * Output: [0,4,1,3,2]
 * Explanation:
 * nums       index     target
 * 0            0        [0]
 * 1            1        [0,1]
 * 2            2        [0,1,2]
 * 3            2        [0,1,3,2]
 * 4            1        [0,4,1,3,2]
 * Example 2:
 *
 * Input: nums = [1,2,3,4,0], index = [0,1,2,3,0]
 * Output: [0,1,2,3,4]
 * Explanation:
 * nums       index     target
 * 1            0        [1]
 * 2            1        [1,2]
 * 3            2        [1,2,3]
 * 4            3        [1,2,3,4]
 * 0            0        [0,1,2,3,4]
 * Example 3:
 *
 * Input: nums = [1], index = [0]
 * Output: [1]
 *
 *
 * Constraints:
 *
 * 1 <= nums.length, index.length <= 100
 * nums.length == index.length
 * 0 <= nums[i] <= 100
 * 0 <= index[i] <= i
 */
public class $1389CreateTargetArrayInTheGivenOrder {

    public static void main(String[] args) {
        PrintUtil.printArr(createTargetArray(new int[]{1, 2, 3, 4, 0}, new int[]{0, 1, 2, 3, 0}));
    }

    /**
     * my second solution of this problem
     * @param nums
     * @param index
     * @return
     */
    static int[] createTargetArray2(int[] nums, int[] index) {
        int[] result = new int[index.length];
        int max = 0;
        for (int i=0;i<index.length;i++) {
            if (index[i]>=max) {
                result[max] = nums[i];
            } else {
                for (int j=max;j>index[i];j--) {
                    result[j] = result[j-1];
                }
                result[index[i]] = nums[i];
            }
            max++;
        }

        return result;
    }

    /**
     * my fisrt solution of this problem
     * @param nums
     * @param index
     * @return
     */
    static int[] createTargetArray(int[] nums, int[] index) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i=0;i<index.length;i++) {
            list.add(index[i],nums[i]);
        }
        int[] result = new int[list.size()];
        for (int i=0;i<result.length;i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
