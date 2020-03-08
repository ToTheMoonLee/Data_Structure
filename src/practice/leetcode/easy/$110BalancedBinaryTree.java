package practice.leetcode.easy;

import sun.applet.Main;

/**
 * Given a binary tree, determine if it is height-balanced.
 *
 * For this problem, a height-balanced binary tree is defined as:
 *
 * a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
 *
 *
 *
 * Example 1:
 *
 * Given the following tree [3,9,20,null,null,15,7]:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * Return true.
 *
 * Example 2:
 *
 * Given the following tree [1,2,2,3,3,null,null,4,4]:
 *
 *        1
 *       / \
 *      2   2
 *     / \
 *    3   3
 *   / \
 *  4   4
 * Return false.
 */
public class $110BalancedBinaryTree {

    public static void main(String[] args) {

        TreeNode root1 = new TreeNode(3);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);

        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(2);
        root2.left.left = new TreeNode(3);
        root2.left.right = new TreeNode(3);
        root2.left.left.left = new TreeNode(4);
        root2.left.left.right = new TreeNode(4);


        System.out.println(isBalanced(root1));
        System.out.println(isBalanced(root2));

        System.out.println(isBalanced2(root1));
        System.out.println(isBalanced2(root2));
    }

    /**
     * their solution of this problem
     * @param root
     * @return
     */
    static boolean isBalanced2(TreeNode root) {
        if (root == null) {
            return true;
        }

        return height(root) != -1;
    }

    static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int lH = height(root.left);
        if (lH == -1) {
            return -1;
        }

        int rH = height(root.right);
        if (rH == -1) {
            return -1;
        }

        if (Math.abs(lH - rH) > 1) {
            return -1;
        }

        return Math.max(height(root.left), height(root.right)) + 1;
    }

    /**
     * my solution of this problem, faster than 10.98%.
     * @param root
     * @return
     */
    static boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        if (Math.abs(getHeight(root.left) - getHeight(root.right)) <=1) {
            return isBalanced(root.left) &&  isBalanced(root.right);
        }
        return false;
    }

    static int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(root.left),getHeight(root.right));
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
