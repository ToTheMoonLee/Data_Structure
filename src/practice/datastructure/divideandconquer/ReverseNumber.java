package practice.datastructure.divideandconquer;

import practice.datastructure.util.PrintUtil;

/**
 * 使用分治思想，并借助归并排序，拿到逆序数
 */
public class ReverseNumber {

    private static int reverseNums = 0;

    public static void main(String[] args) {
        int[] test1 = new int[]{5};
        int[] test2 = new int[]{1,5, 4, 2, 6, 3, 7};
        getReverseNumber(test2);
        System.out.println(" reverse number is " + reverseNums);
        PrintUtil.printArr(test2);
    }

    private static void getReverseNumber(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
    }

    private static void mergeSort(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }
        int mid = start + ((end - start) >> 1);
        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);
        merge(nums, start, mid, end);
    }

    private static void merge(int[] nums, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= end) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                reverseNums = reverseNums + mid - i + 1;
                temp[k++] = nums[j++];
            }
        }
        while (i <= mid) {
            temp[k++] = nums[i++];
        }
        while (j <= end) {
            temp[k++] = nums[j++];
        }
        for (int aTemp : temp) {
            nums[start++] = aTemp;
        }
    }
}
