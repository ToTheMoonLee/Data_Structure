package practice.leetcode.easy;

import practice.leetcode.ListNode;

import java.util.Stack;

/**
 * Given a singly linked list, determine if it is a palindrome.
 *
 * Example 1:
 *
 * Input: 1->2
 * Output: false
 * Example 2:
 *
 * Input: 1->2->2->1
 * Output: true
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
 */
public class $234PalindromeLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        System.out.println(isPalindrome(head));
        System.out.println(isPalindrome2(head));
        System.out.println(isPalindrome3(head));
    }

    /**
     * their recursion solution of this problem
     */
    static ListNode ref;
    static boolean isPalindrome3(ListNode head) {
        ref = head;
        return check(head);
    }

    static boolean check(ListNode node){
        if(node == null) return true;
        boolean ans = check(node.next);
        boolean isEqual = (ref.val == node.val)? true : false;
        ref = ref.next;
        return ans && isEqual;
    }

    /**
     * my second solution of this problem
     * @param head
     * @return
     */
    static boolean isPalindrome2(ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode pre = null;
        ListNode next = null;
        ListNode cur = head;
        int count = 0;
        while (cur!=null) {
            count++;
            cur = cur.next;
        }
        cur = head;
        int c = count/2;
        while (cur!=null && c!=0) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
            c--;
        }
        if (count%2 == 1) {
            cur = cur.next;
        }
        while (cur!=null) {
            if (cur.val != pre.val) return false;
            cur = cur.next;
            pre = pre.next;
        }
        return true;
    }

    /**
     * my first solution of this problem
     * @param head
     * @return
     */
    static boolean isPalindrome(ListNode head) {
        Stack<ListNode> s = new Stack<>();
        ListNode temp = head;
        while (temp != null) {
            s.push(temp);
            temp = temp.next;
        }
        while (head!=null) {
            if (head.val != s.pop().val) return false;
            head = head.next;
        }
        return true;
    }
}
