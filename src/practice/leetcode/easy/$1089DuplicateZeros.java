package practice.leetcode.easy;

/**
 * Given a fixed length array arr of integers, duplicate each occurrence of zero,
 * shifting the remaining elements to the right.
 *
 * Note that elements beyond the length of the original array are not written.
 *
 * Do the above modifications to the input array in place, do not return anything from your function.
 *
 *
 *
 * Example 1:
 *
 * Input: [1,0,2,3,0,4,5,0]
 * Output: null
 * Explanation: After calling your function, the input array is modified to: [1,0,0,2,3,0,0,4]
 * Example 2:
 *
 * Input: [1,2,3]
 * Output: null
 * Explanation: After calling your function, the input array is modified to: [1,2,3]
 *
 *
 * Note:
 *
 * 1 <= arr.length <= 10000
 * 0 <= arr[i] <= 9
 */
public class $1089DuplicateZeros {

    public static void main(String[] args) {
        duplicateZeros(new int[]{1, 0, 2, 3, 0, 4, 5, 0});
        duplicateZeros2(new int[]{8,4,5,0,0,0,0,7});
    }

    /**
     * their amazing solution of this problem
     * @param arr
     */
    static void duplicateZeros2(int[] arr) {
        int countZero = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) countZero++;
        }
        int len = arr.length + countZero;
        //We just need O(1) space if we scan from back
        //i point to the original array, j point to the new location
        for (int i = arr.length - 1, j = len - 1; i < j; i--, j--) {
            if (arr[i] != 0) {
                if (j < arr.length) arr[j] = arr[i];
            } else {
                if (j < arr.length) arr[j] = arr[i];
                j--;
                if (j < arr.length) arr[j] = arr[i]; //copy twice when hit '0'
            }
        }
    }

    /**
     * my solution of this problem
     * @param arr
     */
    static void duplicateZeros(int[] arr) {
        for (int i=0;i<arr.length;i++) {
            if (arr[i] == 0) {
                for (int j=arr.length-1;j>i;j--) {
                    arr[j] = arr[j-1];
                }
                i++;
            }
        }
    }
}
