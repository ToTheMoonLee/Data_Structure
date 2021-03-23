package practice.leetcode.easy;

import practice.leetcode.ListNode;

/**
 * Remove all elements from a linked list of integers that have value val.
 * <p>
 * Example:
 * <p>
 * Input:  1->2->6->3->4->5->6, val = 6
 * Output: 1->2->3->4->5
 */
public class $203RemoveLinkedListElements {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(6);

//        ListNode result = removeElements(head, 6);
        ListNode result = removeElements2(head, 6);
        StringBuilder sb = new StringBuilder();
        while (result != null) {
            sb.append(result.val + "->");
            result = result.next;
        }
        sb.delete(sb.length() - 2, sb.length());
        System.out.println(sb.toString());
    }

    /**
     * their recursion solution of this problem
     * @param head
     * @param val
     * @return
     */
    static ListNode removeElements2(ListNode head, int val) {
        if (head == null) return null;
        head.next = removeElements2(head.next, val);
        return head.val == val ? head.next : head;
    }

    /**
     * my solution of this problem
     *
     * @param head
     * @param val
     * @return
     */
    static ListNode removeElements(ListNode head, int val) {
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode pre = sentinel;
        while (head != null) {
            if (head.val == val) {
                pre.next = pre.next.next;
            } else {
                pre = pre.next;
            }
            head = head.next;
        }
        return sentinel.next;
    }
}
