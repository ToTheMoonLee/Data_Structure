package practice.leetcode.easy.tree;

import practice.datastructure.util.PrintUtil;
import practice.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return all root-to-leaf paths.
 * <p>
 * Note: A leaf is a node with no children.
 * <p>
 * Example:
 * <p>
 * Input:
 * <p>
 * 1
 * /   \
 * 2     3
 * \
 * 5
 * <p>
 * Output: ["1->2->5", "1->3"]
 * <p>
 * Explanation: All root-to-leaf paths are: 1->2->5, 1->3
 */
public class $257BinaryTreePath {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);

        List<String> strings = binaryTreePaths(root);
        List<String> strings1 = binaryTreePaths2(root);
        List<String> strings3 = binaryTreePaths3(root);

        PrintUtil.printList(strings);
        System.out.println();
        System.out.println("-------------------");
        System.out.println();
        PrintUtil.printList(strings1);
        System.out.println();
        System.out.println("-------------------");
        System.out.println();
        PrintUtil.printList(strings3);
    }

    static List<String> binaryTreePaths3(TreeNode root) {
        List<String> paths = new ArrayList<>();
        Stack<TreeNode> treeStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        treeStack.push(root);
        stringStack.push("");

        while (!treeStack.isEmpty()) {
            TreeNode treeNode = treeStack.pop();
            String curString = stringStack.pop();
            if (treeNode.right == null && treeNode.left == null) paths.add(curString + treeNode.val);
            if (treeNode.left != null) {
                treeStack.push(treeNode.left);
                stringStack.push(curString + treeNode.val + "->");
            }
            if (treeNode.right != null) {
                treeStack.push(treeNode.right);
                stringStack.push(curString + treeNode.val + "->");
            }
        }
        return paths;
    }

    /**
     * their recursive solution of this problem
     *
     * @param root
     * @return
     */
    static List<String> binaryTreePaths2(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root == null) return paths;
        if (root.left == null && root.right == null) {
            paths.add(root.val + "");
            return paths;
        }
        for (String path : binaryTreePaths2(root.left)) {
            paths.add(root.val + "->" + path);
        }
        for (String path : binaryTreePaths2(root.right)) {
            paths.add(root.val + "->" + path);
        }
        return paths;
    }

    /**
     * my solution of this problem
     *
     * @param root
     * @return
     */
    static List<String> binaryTreePaths(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        List<String> list = new ArrayList<>();
        if (root != null) getList(list, root, sb);
        return list;
    }

    static void getList(List<String> list, TreeNode root, StringBuilder sb) {
        if (root.left == null && root.right == null) {
            sb.append(root.val);
            list.add(sb.toString());
        }
        if (root.left != null) {
            getList(list, root.left, new StringBuilder(sb).append(root.val).append("->"));
        }
        if (root.right != null) {
            getList(list, root.right, new StringBuilder(sb).append(root.val).append("->"));
        }
    }
}
