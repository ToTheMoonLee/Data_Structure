package practice.leetcode.medium;

import practice.leetcode.ListNode;

import java.util.HashMap;

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
