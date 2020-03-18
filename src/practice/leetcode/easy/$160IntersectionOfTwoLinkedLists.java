package practice.leetcode.easy;

/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * <p>
 * For example, the following two linked lists:
 * A:     a1->a2
 * \
 * c1->c2->c3
 * /
 * B: b1->b2->b3
 * begin to intersect at node c1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * A:       4->1
 * \
 * 8->4->5
 * /
 * B:   5->0->1
 * <p>
 * Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * Output: Reference of the node with value = 8
 * Input Explanation: The intersected node's value is 8
 * (note that this must not be 0 if the two lists intersect). From the head of A, it reads as [4,1,8,4,5].
 * From the head of B, it reads as [5,0,1,8,4,5]. There are 2 nodes before the intersected node in A;
 * There are 3 nodes before the intersected node in B.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * A:    0->9->1
 * \
 * 2->4
 * /
 * B:         3
 * <p>
 * Input: intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * Output: Reference of the node with value = 2
 * Input Explanation: The intersected node's value is 2 (note that this must not be 0 if the two lists intersect).
 * From the head of A, it reads as [0,9,1,2,4]. From the head of B, it reads as [3,2,4].
 * There are 3 nodes before the intersected node in A; There are 1 node before the intersected node in B.
 * <p>
 * <p>
 * Example 3:
 * <p>
 * A:   2->6->4
 * B:      1->5
 * <p>
 * Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * Output: null
 * Input Explanation: From the head of A, it reads as [2,6,4]. From the head of B,
 * it reads as [1,5]. Since the two lists do not intersect, intersectVal must be 0,
 * while skipA and skipB can be arbitrary values.
 * Explanation: The two lists do not intersect, so return null.
 * <p>
 * <p>
 * Notes:
 * <p>
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 */
public class $160IntersectionOfTwoLinkedLists {

    public static void main(String[] args) {
        ListNode headA = new ListNode(0);
        headA.next = new ListNode(9);
        headA.next.next = new ListNode(1);
        ListNode intersected = new ListNode(2);
        headA.next.next.next = intersected;
        headA.next.next.next.next = new ListNode(4);
        ListNode headB = new ListNode(3);
        headB.next = intersected;
        System.out.println(getIntersectionNode(headA, headB));
        System.out.println(getIntersectionNode2(headA, headB));
    }

    /**
     * their amazing solution of this problem
     * @param headA
     * @param headB
     * @return
     */
    static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode a = headA;
        ListNode b = headB;
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }

    /**
     * my solution of this problem
     * @param headA
     * @param headB
     * @return
     */
    static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        int aSize = 0;
        int bSize = 0;
        ListNode temp = headA;
        while (temp != null) {
            aSize++;
            temp = temp.next;
        }
        temp = headB;
        while (temp != null) {
            bSize++;
            temp = temp.next;
        }
        while (aSize > bSize) {
            headA = headA.next;
            aSize--;
        }
        while (bSize > aSize) {
            headB = headB.next;
            bSize--;
        }
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            return "val is " + val + " --- " + super.toString();
        }
    }
}
