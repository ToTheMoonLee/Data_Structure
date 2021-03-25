package practice.leetcode.hard;

import practice.datastructure.util.PrintUtil;
import practice.leetcode.ListNode;

/**
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 *
 * k is a positive integer and is less than or equal to the length of the linked list.
 * If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
 *
 * Follow up:
 *
 * Could you solve the problem in O(1) extra memory space?
 * You may not alter the values in the list's nodes, only nodes itself may be changed.
 *
 * example: Input: head = [1,2,3,4,5], k = 2 Output: [2,1,4,3,5]
 */
public class $25ReverseNodesInkGroup {

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

        PrintUtil.printListNode(reverseKGroup(node1, 2));
    }

    /**
     *
     * my solution of this problem, faster than 100%
     *
     * @param head
     * @param k
     * @return
     */
    static ListNode reverseKGroup(ListNode head, int k) {
        int i = 0;
        ListNode preLink = new ListNode();
        preLink.next = head;
        ListNode returnHead = preLink;
        ListNode nextLink = null;
        while (head != null) {
            i++;
            head = head.next;
            if (i == k) {
                nextLink = head;
                ListNode pre = preLink;
                ListNode cur = preLink.next;
                ListNode next = null;
                while (cur.next != nextLink) {
                    next = cur.next;
                    cur.next = pre;
                    pre = cur;
                    cur = next;
                }
                cur.next = pre;
                preLink.next.next = nextLink;
                next = preLink.next;
                preLink.next = cur;
                preLink = next;
                i = 0;
            }
        }
        return returnHead.next;
    }

    /**
     * their recursive solution of this problem
     * @param head
     * @param k
     * @return
     */
    static ListNode reverseKGroup2(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        while (curr != null && count != k) { // find the k+1 node
            curr = curr.next;
            count++;
        }
        if (count == k) { // if k+1 node is found
            curr = reverseKGroup(curr, k); // reverse list with k+1 node as head
            // head - head-pointer to direct part,
            // curr - head-pointer to reversed part;
            while (count-- > 0) { // reverse current k-group:
                ListNode tmp = head.next; // tmp - next head in direct part
                head.next = curr; // preappending "direct" head to the reversed list
                curr = head; // move head of reversed part to a new node
                head = tmp; // move "direct" head to the next node in direct part
            }
            head = curr;
        }
        return head;
    }
}
