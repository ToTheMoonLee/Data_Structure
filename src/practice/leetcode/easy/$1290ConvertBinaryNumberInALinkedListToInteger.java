package practice.leetcode.easy;

import practice.leetcode.ListNode;

/**
 * Given head which is a reference node to a singly-linked list.
 * The value of each node in the linked list is either 0 or 1.
 * The linked list holds the binary representation of a number.
 *
 * Return the decimal value of the number in the linked list.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: head = [1,0,1]
 * Output: 5
 * Explanation: (101) in base 2 = (5) in base 10
 * Example 2:
 *
 * Input: head = [0]
 * Output: 0
 * Example 3:
 *
 * Input: head = [1]
 * Output: 1
 * Example 4:
 *
 * Input: head = [1,0,0,1,0,0,1,1,1,0,0,0,0,0,0]
 * Output: 18880
 * Example 5:
 *
 * Input: head = [0,0]
 * Output: 0
 *
 *
 * Constraints:
 *
 * The Linked List is not empty.
 * Number of nodes will not exceed 30.
 * Each node's value is either 0 or 1.
 */
public class $1290ConvertBinaryNumberInALinkedListToInteger {

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(0);
        root.next.next = new ListNode(1);
        System.out.println(getDecimalValue(root));
        System.out.println(getDecimalValue2(root));
    }

    /**
     * their solution of this problem
     * @param head
     * @return
     */
    static int getDecimalValue2(ListNode head) {
        int ans = 0;
        while (head != null) {
            ans = (ans << 1) | head.val;
            head = head.next;
        }
        return ans;
    }

    /**
     * my solution of this problem
     */
    static int i=0;
    static int getDecimalValue(ListNode head) {
        return getAns(head);
    }

    static int getAns(ListNode head) {
        if (head == null) return 0;
        int res = getAns(head.next);
        int cur = (head.val == 0) ? 0 : (int)Math.pow(2,i);
        i++;
        return res + cur;
    }
}
