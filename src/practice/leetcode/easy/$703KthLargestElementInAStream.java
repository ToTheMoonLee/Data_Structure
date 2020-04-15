package practice.leetcode.easy;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order,
 * not the kth distinct element.
 * <p>
 * Your KthLargest class will have a constructor which accepts an integer k and an integer array nums,
 * which contains initial elements from the stream.
 * For each call to the method KthLargest.add, return the element representing the kth largest element in the stream.
 * <p>
 * Example:
 * <p>
 * int k = 3;
 * int[] arr = [4,5,8,2];
 * KthLargest kthLargest = new KthLargest(3, arr);
 * kthLargest.add(3);   // returns 4
 * kthLargest.add(5);   // returns 5
 * kthLargest.add(10);  // returns 5
 * kthLargest.add(9);   // returns 8
 * kthLargest.add(4);   // returns 8
 * Note:
 * You may assume that nums' length ≥ k-1 and k ≥ 1.
 */
public class $703KthLargestElementInAStream {

    public static void main(String[] args) {
        KthLargest kthLargest = new KthLargest(3, new int[]{4, 5, 8, 2});
        System.out.println(kthLargest.add(3));

    }

    /**
     * their solution of this problem
     */
    static class KthLargest {
        private int k;
        private PriorityQueue<Integer> priorityQueue;

        public KthLargest(int k, int[] nums) {
            this.k = k;
            priorityQueue = new PriorityQueue<>(k);
            for (int num : nums) {
                add(num);
            }
        }

        public int add(int val) {

            if (priorityQueue.size() == k) {

                val = Math.max(val, priorityQueue.poll());
            }
            priorityQueue.add(val);

            return priorityQueue.peek();

        }
    }
}


