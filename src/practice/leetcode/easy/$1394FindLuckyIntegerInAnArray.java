package practice.leetcode.easy;

/**
 * Given an array of integers arr,
 * a lucky integer is an integer which has a frequency in the array equal to its value.
 *
 * Return a lucky integer in the array.
 * If there are multiple lucky integers return the largest of them. If there is no lucky integer return -1.
 *
 *
 *
 * Example 1:
 *
 * Input: arr = [2,2,3,4]
 * Output: 2
 * Explanation: The only lucky number in the array is 2 because frequency[2] == 2.
 * Example 2:
 *
 * Input: arr = [1,2,2,3,3,3]
 * Output: 3
 * Explanation: 1, 2 and 3 are all lucky numbers, return the largest of them.
 * Example 3:
 *
 * Input: arr = [2,2,2,3,3]
 * Output: -1
 * Explanation: There are no lucky numbers in the array.
 * Example 4:
 *
 * Input: arr = [5]
 * Output: -1
 * Example 5:
 *
 * Input: arr = [7,7,7,7,7,7,7]
 * Output: 7
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 500
 * 1 <= arr[i] <= 500
 */
public class $1394FindLuckyIntegerInAnArray {

    public static void main(String[] args) {
        System.out.println(findLucky(new int[]{2, 2, 3, 4}));
    }

    /**
     * my solutiono of this problem
     * @param arr
     * @return
     */
    static int findLucky(int[] arr) {
        int[] temp = new int[501];
        for (int i=0;i<arr.length;i++) {
            temp[arr[i]]++;
        }
        for (int i=temp.length-1;i>0;i--) {
            if (i == temp[i] ) return i;
        }
        return -1;
    }
}