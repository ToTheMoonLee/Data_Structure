package practice.leetcode.easy.tree;

import practice.leetcode.TreeNode;

/**
 * Given a binary tree, you need to compute the length of the diameter of the tree.
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
 * This path may or may not pass through the root.
 *
 * Example:
 * Given a binary tree
 *           1
 *          / \
 *         2   3
 *        / \
 *       4   5
 * Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].
 *
 * Note: The length of path between two nodes is represented by the number of edges between them.
 */
public class $543DiameterOfBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(diameterOfBinaryTree(root));
        System.out.println(diameterOfBinaryTree2(root));
        System.out.println(diameterOfBinaryTree3(root));
    }

    static int max3 = 0;
    static int diameterOfBinaryTree3(TreeNode root) {
        if (root == null) return 0;
        findDepth3(root);
        return max3;
    }

    static int findDepth3(TreeNode root) {
        if (root == null) return 0;
        int l = findDepth3(root.left);
        int r = findDepth3(root.right);
        max3 = Math.max(max3,l+r);
        return Math.max(l,r)+1;
    }

    /**
     * my second solution of this problem
     */
    static int max2 = 0;
    static int diameterOfBinaryTree2(TreeNode root) {
        if (root == null) return 0;
        findDepth2(root);
        inOrder2(root);
        return max2;
    }

    static int findDepth2(TreeNode root) {
        if (root == null) return 0;
        root.val = Math.max(findDepth2(root.left),findDepth2(root.right))+1;
        return root.val;
    }
    static void inOrder2(TreeNode node) {
        if (node == null) return;
        inOrder2(node.left);
        int left = node.left == null ? 0 : node.left.val;
        int right = node.right == null ? 0 : node.right.val;
        max2 = Math.max(max,left+right);
        inOrder2(node.right);
    }

    /**
     * my first solution of this problem
     */
    static int max = 0;
    static int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        inOrder(root);
        return max;
    }

    static int findDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(findDepth(root.left),findDepth(root.right))+1;
    }
    static void inOrder(TreeNode node) {
        if (node == null) return;
        inOrder(node.left);
        max = Math.max(max,findDepth(node.left) + findDepth(node.right));
        inOrder(node.right);
    }
}
