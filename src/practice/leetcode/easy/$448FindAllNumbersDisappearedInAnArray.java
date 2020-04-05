package practice.leetcode.easy;

import practice.datastructure.util.PrintUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array),
 * some elements appear twice and others appear once.
 *
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 *
 * Could you do it without extra space and in O(n) runtime?
 * You may assume the returned list does not count as extra space.
 *
 * Example:
 *
 * Input:
 * [4,3,2,7,8,2,3,1]
 *
 * Output:
 * [5,6]
 */
public class $448FindAllNumbersDisappearedInAnArray {

    public static void main(String[] args) {
        int[] nums = new int[]{4, 3, 2, 7, 8, 2, 3, 1};
        PrintUtil.printList2(findDisappearedNumbers(nums));
        System.out.println("-------------------");
        PrintUtil.printList2(findDisappearedNumbers2(nums));
        System.out.println("-------------------");
        PrintUtil.printList2(findDisappearedNumbers3(nums));
        System.out.println("-------------------");
        PrintUtil.printList2(findDisappearedNumbers4(nums));
    }

    /**
     * their amazing without extra space solution of this problem
     * @param nums
     * @return
     */
    static List<Integer> findDisappearedNumbers4(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i=0;i<nums.length;i++) {
            int val = Math.abs(nums[i])-1;
            if (nums[val] > 0) {
                nums[val] = -nums[val];
            }
        }
        for (int i=0;i<nums.length;i++) {
            if (nums[i]>0) list.add(i+1);
        }
        return list;
    }

    /**
     * my third solution of this problem
     * @param nums
     * @return
     */
    static List<Integer> findDisappearedNumbers3(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int[] arr = new int[nums.length+1];
        for (int i=0;i<nums.length;i++) {
            arr[nums[i]] = 1;
        }
        for (int i=1;i<arr.length;i++) {
            if (arr[i]==0) list.add(i);
        }
        return list;
    }

    /**
     * my second solution of this problem
     * @param nums
     * @return
     */
    static List<Integer> findDisappearedNumbers2(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int[] arr = new int[nums.length+1];
        for (int i=0;i<=nums.length;i++) {
            arr[i] = i;
        }
        for (int i=0;i<nums.length;i++) {
            arr[nums[i]] = 0;
        }
        for (int i=0;i<arr.length;i++) {
            if (arr[i]!=0) list.add(arr[i]);
        }
        return list;
    }

    /**
     * my first solution of this problem
     * @param nums
     * @return
     */
    static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i=0;i<nums.length;i++) {
            list.add(i+1);
        }
        for (int i=0;i<nums.length;i++) {
            list.set(nums[i]-1,0);
        }
//        Iterator<Integer> it = list.iterator();
//        while (it.hasNext()) {
//            Integer i = it.next();
//            if (i == 0) it.remove();
//        }
        list.removeIf(i -> i == 0);
        return list;
    }
}
