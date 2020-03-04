package practice.leetcode.easy;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 *
 * Example 1:
 *
 * Input: 1->1->2
 * Output: 1->2
 * Example 2:
 *
 * Input: 1->1->2->3->3
 * Output: 1->2->3
 */
public class $RemoveDuplicatesFromSortedList {

    public static void main(String[] args) {

        ListNode first = new ListNode(1);
        first.next = new ListNode(1);
        first.next.next = new ListNode(1);

        ListNode second = new ListNode(1);
        second.next = new ListNode(1);
        second.next.next = new ListNode(2);
        second.next.next.next = new ListNode(3);
        second.next.next.next.next = new ListNode(3);

//        ListNode listNode = deleteDuplicates(first);
//        ListNode listNode = recursionVersion(first);

//        ListNode listNode = deleteDuplicates(second);
        ListNode listNode = recursionVersion(second);

        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    /**
     * other recursion version of this problem
     * @param head
     * @return
     */
    static ListNode recursionVersion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        head.next = recursionVersion(head.next);
        return head.val == head.next.val ? head.next : head;
    }

    /**
     * my solution of this problem
     *
     * @param head
     * @return
     */
    static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode root = head;
        while (root != null) {
            if (root.next != null && root.val == root.next.val) {
                root.next = root.next.next;
            } else {
                root = root.next;
            }

        }
        return head;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
