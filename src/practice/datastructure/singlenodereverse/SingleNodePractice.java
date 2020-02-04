package practice.datastructure.singlenodereverse;

public class SingleNodePractice {

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        Node iterator = node1;
        System.out.println(" iterator data is " + iterator.data);
        while (iterator.next != null) {
            System.out.println(" iterator data is " + iterator.next.data);
            iterator = iterator.next;
        }

        System.out.println(" -------------------------- ");
       iterator = reverseNode(node1);
        System.out.println(" iterator data is " + iterator.data);
        while (iterator.next != null) {
            System.out.println(" iterator data is " + iterator.next.data);
            iterator = iterator.next;
        }

    }


    public static Node reverseNode(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node nextNode = null;
        Node preNode = null;
        while (head != null) {
            nextNode = head.next;
            head.next = preNode;
            preNode = head;
            head = nextNode;
        }
        return preNode;
    }
}


class Node {

    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
    }
}