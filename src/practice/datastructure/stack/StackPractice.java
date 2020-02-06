package practice.datastructure.stack;


import practice.datastructure.ListNode;

public class StackPractice {
    // Leetcode 20,155,232,844,224,682,496

    public static void main(String[] args) {
//        ArrayStack stack = new ArrayStack(2);
//        System.out.println(" ------ " + stack.push("a"));
//        System.out.println(" ------ " + stack.push("b"));
//        System.out.println(" ------ " + stack.push("c"));
//        System.out.println(" ------ " + stack.pop());
//        System.out.println(" ------ " + stack.pop());
//        System.out.println(" ------ " + stack.pop());

        LinkedNodeStack stack = new LinkedNodeStack();
        System.out.println(" ------ " + stack.push(new ListNode(1)));
        System.out.println(" ------ " + stack.push(new ListNode(2)));
        System.out.println(" ------ " + stack.push(new ListNode(3)));
        System.out.println(" ------ " + stack.pop().val);
        System.out.println(" ------ " + stack.pop().val);
        System.out.println(" ------ " + stack.pop().val);
    }
}

class LinkedNodeStack {

    ListNode head;

    LinkedNodeStack() {
        head = new ListNode(0);
    }

    public boolean push(ListNode data) {
        data.next = head.next;
        head.next = data;
        return true;
    }

    public ListNode pop() {
        if (head.next == null) {
            return null;
        }
        ListNode temp = head.next;
        head.next = temp.next;
        temp.next = null;
        return temp;
    }
}

class ArrayStack {

    int count;
    String[] arr;
    int size;

    ArrayStack(int n) {
        arr = new String[n];
        count = 0;
        size = n;
    }

    public boolean push(String data) {
        if (count == size) {
            return false;
        }
        arr[count++] = data;
        return true;
    }

    public String pop() {
        if (count == 0) {
            return null;
        }
        return arr[--count];
    }
}