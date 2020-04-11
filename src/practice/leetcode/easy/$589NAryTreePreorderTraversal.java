package practice.leetcode.easy;

import practice.datastructure.util.PrintUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given an n-ary tree, return the preorder traversal of its nodes' values.
 *
 * Nary-Tree input serialization is represented in their level order traversal,
 * each group of children is separated by the null value (See examples).
 *
 *
 *
 * Follow up:
 *
 * Recursive solution is trivial, could you do it iteratively?
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: root = [1,null,3,2,4,null,5,6]
 * Output: [1,3,5,6,2,4]
 * Example 2:
 *
 *
 *
 * Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * Output: [1,2,3,6,7,11,14,4,8,12,5,9,13,10]
 */
public class $589NAryTreePreorderTraversal {

    public static void main(String[] args) {
        List<Node> children = new ArrayList<>();
        List<Node> children2 = new ArrayList<>();
        children2.add(new Node(5, null));
        children2.add(new Node(6, null));
        children.add(new Node(3, children2));
        children.add(new Node(2, null));
        children.add(new Node(4, null));
        Node root = new Node(1, children);

        PrintUtil.printList2(preorder(root));
        System.out.println("-----------------");
        PrintUtil.printList2(preorder2(root));
    }

    /**
     * my second iterative solution of this problem
     * @param root
     * @return
     */
    static List<Integer> preorder2(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node n = stack.pop();
            list.add(n.val);
            if (n.children!=null) {
                for (int i=n.children.size()-1;i>=0;i--) {
                    stack.push(n.children.get(i));
                }
            }
        }
        return list;
    }

    /**
     * my first recursive solution of this problem
     */
    static List<Integer> list = new ArrayList<>();
    static List<Integer> preorder(Node root) {
        if (root == null) return list;
        list.add(root.val);
        if (root.children!=null) {
            for (Node n : root.children) {
                preorder(n);
            }
        }
        return list;
    }
}
