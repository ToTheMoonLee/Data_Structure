package practice.leetcode.medium;

import practice.datastructure.util.PrintUtil;
import practice.leetcode.ListNode;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * input : [1,2,3,4]
 * result : [2,1,4,3]
 *
 */
public class $24SwapNodesInPairs {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        PrintUtil.printListNode(swapPairs(node1));
    }

    static ListNode swapPairs(ListNode head) {
        ListNode pre = new ListNode();
        pre.next = head;
        ListNode next = null;
        ListNode cur = head;
        head = pre;
        while (cur != null && cur.next != null) {
            pre.next = cur.next;
            next = cur.next.next;
            cur.next.next = cur;
            cur.next = next;
            pre = cur;
            cur = next;
        }
        return head.next;
    }

    /**
     * their recursive solution of this problem
     * @param head
     * @return
     */
    static ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode n = head.next;
        head.next = swapPairs2(head.next.next);
        n.next = head;
        return n;
    }
}
