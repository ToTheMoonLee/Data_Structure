package practice.leetcode.hard;

import java.util.LinkedList;

/**
 * You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
 *
 * Return the max sliding window.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
 * Output: [3,3,5,5,6,7]
 * Explanation:
 * Window position                Max
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 */
public class $239SlidingWindowMaximum {

    public static void main(String[] args) {

    }

    /**
     * their dequeue solution of this problem
     * @param nums
     * @param k
     * @return
     */
    static int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length-k + 1];
        LinkedList<Integer> window = new LinkedList<>();
        for (int i=0;i<nums.length;i++) {
            while (!window.isEmpty() && window.peekFirst() <= i-k) {
                window.pollFirst();
            }
            while (!window.isEmpty() && nums[window.peekLast()] < nums[i]) {
                window.pollLast();
            }
            window.addLast(i);
            if (i>=k-1) {
                result[i-k+1] = nums[window.peekFirst()];
            }
        }
        return result;
    }

    /**
     * their dp solution of this problem
     * @see <a herf="https://leetcode.com/problems/sliding-window-maximum/discuss/65881/O(n)-solution-in-Java-with-two-simple-pass-in-the-array"></a>
     * @param in
     * @param w
     * @return
     */
    static int[] slidingWindowMax(final int[] in, final int w) {
        final int[] max_left = new int[in.length];
        final int[] max_right = new int[in.length];

        max_left[0] = in[0];
        max_right[in.length - 1] = in[in.length - 1];

        for (int i = 1; i < in.length; i++) {
            max_left[i] = (i % w == 0) ? in[i] : Math.max(max_left[i - 1], in[i]);

            final int j = in.length - i - 1;
            max_right[j] = (j % w == 0) ? in[j] : Math.max(max_right[j + 1], in[j]);
        }

        final int[] sliding_max = new int[in.length - w + 1];
        for (int i = 0, j = 0; i + w <= in.length; i++) {
            sliding_max[j++] = Math.max(max_right[i], max_left[i + w - 1]);
        }

        return sliding_max;
    }
}
