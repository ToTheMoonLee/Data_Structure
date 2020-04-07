package practice.leetcode.easy;

import practice.datastructure.util.PrintUtil;

import java.util.HashMap;
import java.util.Stack;

/**
 * You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2.
 * Find all the next greater numbers for nums1's elements in the corresponding places of nums2.
 *
 * The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2.
 * If it does not exist, output -1 for this number.
 *
 * Example 1:
 * Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * Output: [-1,3,-1]
 * Explanation:
 *     For number 4 in the first array, you cannot find the next greater number for it in the second array,
 *     so output -1.
 *     For number 1 in the first array, the next greater number for it in the second array is 3.
 *     For number 2 in the first array, there is no next greater number for it in the second array,
 *     so output -1.
 * Example 2:
 * Input: nums1 = [2,4], nums2 = [1,2,3,4].
 * Output: [3,-1]
 * Explanation:
 *     For number 2 in the first array, the next greater number for it in the second array is 3.
 *     For number 4 in the first array, there is no next greater number for it in the second array,
 *     so output -1.
 * Note:
 * All elements in nums1 and nums2 are unique.
 * The length of both nums1 and nums2 would not exceed 1000.
 */
public class $496NextGreaterElement1 {

    public static void main(String[] args) {
        int[] num1 = new int[]{4,1,2};
        int[] num2 = new int[]{1, 3, 4, 2};
        PrintUtil.printArr(nextGreaterElement(num1,num2));
        System.out.println("----------------------");
        PrintUtil.printArr(nextGreaterElement2(num1,num2));
        System.out.println("----------------------");
        PrintUtil.printArr(nextGreaterElement3(num1,num2));
    }

    /**
     * their amazing solution of this problem
     * @param nums1
     * @param nums2
     * @return
     */
    static int[] nextGreaterElement3(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int i=0;i<nums2.length;i++) {
            int n = nums2[i];
            while (!stack.isEmpty() && stack.peek()<n) {
                map.put(stack.pop(),n);
            }
            stack.push(n);
        }
        for (int i=0;i<nums1.length;i++) {
            nums1[i] = map.getOrDefault(nums1[i],-1);
        }
        return nums1;
    }

    /**
     * my second solution of this problem
     * @param nums1
     * @param nums2
     * @return
     */
    static int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<nums2.length;i++) {
            map.put(nums2[i],i);
        }
        for (int i=0;i<nums1.length;i++) {
            int j = map.get(nums1[i]);
            result[i] = -1;
            for (;j<nums2.length;j++) {
                if (nums2[j]>nums1[i]) {
                    result[i] = nums2[j];
                    break;
                }
            }
        }
        return result;
    }

    /**
     * my first solution of this problem
     * @param nums1
     * @param nums2
     * @return
     */
    static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length];
        for (int i=0;i<nums1.length;i++) {
            result[i] = -1;
            int a = nums1[i];
            int j=0;
            while (nums2[j++]!=a) {}
            for (;j<nums2.length;j++) {
                if (nums2[j]>a) {
                    result[i] = nums2[j];
                    break;
                }
            }
        }
        return result;
    }
}
