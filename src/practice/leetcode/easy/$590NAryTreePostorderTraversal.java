package practice.leetcode.easy;

import practice.datastructure.util.PrintUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class $590NAryTreePostorderTraversal {

    public static void main(String[] args) {
        List<Node> children = new ArrayList<>();
        List<Node> children2 = new ArrayList<>();
        children2.add(new Node(5, null));
        children2.add(new Node(6, null));
        children.add(new Node(3, children2));
        children.add(new Node(2, null));
        children.add(new Node(4, null));
        Node root = new Node(1, children);

        PrintUtil.printList2(postorder(root));
        System.out.println("-----------------");
        PrintUtil.printList2(postorder2(root));
    }

    /**
     * my second iterative solution of this prolbem
     * @param root
     * @return
     */
    static List<Integer> postorder2(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<Node> s = new Stack<>();
        Node pre = null;
        s.push(root);
        while (!s.isEmpty()) {
            Node temp = s.peek();
            if (temp.children == null ||temp.children.size()==0 ||  temp.children.get(temp.children.size()-1) == pre) {
                pre = s.pop();
                list.add(pre.val);
                continue;
            }
            if (temp.children!=null) {
                for (int i=temp.children.size()-1;i>=0;i--) {
                    s.push(temp.children.get(i));
                }
            }
        }
        return list;
    }

    /**
     * my first recursive solution of this problem
     */
    static List<Integer> list = new ArrayList<>();
    static List<Integer> postorder(Node root) {
        if (root == null) return list;
        if (root.children !=null) {
            for (Node n : root.children) {
                postorder(n);
            }
        }
        list.add(root.val);
        return list;
    }
}
