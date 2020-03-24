package practice.leetcode.easy;

public class ListNode {
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
