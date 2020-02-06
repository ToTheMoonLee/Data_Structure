package practice.datastructure.hascycle;


import practice.datastructure.ListNode;

import java.util.HashSet;

public class HasCycle {

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(1);
        ListNode c = new ListNode(1);
        ListNode d = new ListNode(1);
        ListNode e = new ListNode(1);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = b;

//        System.out.println(" has next = " + hasCycle(a));
        System.out.println(" has next = " + hasCycle2(a));
    }

    public static boolean hasCycle2(ListNode head) {
        if (head == null) {
            return false;
        }

        HashSet<ListNode> hashSet = new HashSet<>();
        while (head != null) {
            if (hashSet.contains(head)) {
                return true;
            }
            hashSet.add(head);
            head = head.next;
        }
        return false;
    }

    public static boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode walker = head;
        ListNode runner = head;
        while (runner.next != null && runner.next.next != null) {
            walker = walker.next;
            runner = runner.next.next;
            if (walker == runner) {
                return true;
            }
        }
        return false;
    }
}
