package practice.leetcode;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {}

    public ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "val is " + val + " --- " + super.toString();
    }
}
