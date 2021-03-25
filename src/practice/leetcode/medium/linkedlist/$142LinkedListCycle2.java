package practice.leetcode.medium.linkedlist;

import practice.leetcode.ListNode;

import java.util.HashMap;

/**
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
 *
 * There is a cycle in a linked list if there is some node in
 * the list that can be reached again by continuously following the next pointer.
 * Internally, pos is used to denote the index of the node that tail's next pointer is connected to.
 * Note that pos is not passed as a parameter.
 *
 * Notice that you should not modify the linked list.
 */
public class $142LinkedListCycle2 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;

        System.out.println(detectCycle(node1).val);
    }

    /**
     * my solution of this problem,and beat only 15.86%
     * @param head
     * @return
     */
    static ListNode detectCycle(ListNode head) {
        int i = 0;
        HashMap<ListNode, Integer> hashMap = new HashMap<>();
        while (head != null) {
            if (hashMap.get(head) != null) {
                return head;
            }
            hashMap.put(head, i++);
            head = head.next;
        }
        return null;
    }

    /**
     * their amazing solution of this problem, beat 100%
     * @param head
     * @return
     */
    static ListNode detectCycle2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow){
                ListNode slow2 = head;
                while (slow2 != slow){
                    slow = slow.next;
                    slow2 = slow2.next;
                }
                return slow;
            }
        }
        return null;
    }
}
