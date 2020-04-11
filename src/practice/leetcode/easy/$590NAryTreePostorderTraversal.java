package practice.leetcode.easy;

import practice.datastructure.util.PrintUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given an n-ary tree, return the postorder traversal of its nodes' values.
 *
 * Nary-Tree input serialization is represented in their level order traversal, each group of children is separated by the null value (See examples).
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
 * Output: [5,6,3,2,4,1]
 * Example 2:
 *
 *
 *
 * Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * Output: [2,6,14,11,7,3,12,8,4,13,9,10,5,1]
 *
 *
 * Constraints:
 *
 * The height of the n-ary tree is less than or equal to 1000
 * The total number of nodes is between [0, 10^4]
 */
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
