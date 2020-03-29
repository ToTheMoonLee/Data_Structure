package practice.leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Invert a binary tree.
 *
 * Example:
 *
 * Input:
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 * Output:
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 * Trivia:
 * This problem was inspired by this original tweet by Max Howell:
 *
 * Google: 90% of our engineers use the software you wrote (Homebrew),
 * but you can’t invert a binary tree on a whiteboard so f*** off.
 */
public class $226InvertBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        inOrderPrint(invertTree(root));
        System.out.println();
        System.out.println("------------------");
        System.out.println();
        inOrderPrint(invertTree2(root));
    }

    static void inOrderPrint(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + "->");
        inOrderPrint(root.left);
        inOrderPrint(root.right);
    }

    /**
     * my iterative solution of this problem
     * @param root
     * @return
     */
    static TreeNode invertTree2(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return root;
    }

    /**
     * my recursive solution of this problem
     * @param root
     * @return
     */
    static TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode temp = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right = temp;
        return root;
    }
}
