package practice.leetcode.easy.tree;

import practice.leetcode.TreeNode;

/**
 * A binary tree is univalued if every node in the tree has the same value.
 *
 * Return true if and only if the given tree is univalued.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: [1,1,1,1,1,null,1]
 * Output: true
 * Example 2:
 *
 *
 * Input: [2,2,2,5,2]
 * Output: false
 *
 *
 * Note:
 *
 * The number of nodes in the given tree will be in the range [1, 100].
 * Each node's value will be an integer in the range [0, 99].
 */
public class $965UnivaluedBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(1);

        System.out.println(isUnivalTree(root));
    }

    /**
     * my solution of this problem
     * @param root
     * @return
     */
    static boolean isUnivalTree(TreeNode root) {
        if (root == null) return true;
        boolean a = (root.left == null || root.val == root.left.val)&&(root.right == null || root.val == root.right.val);
        return isUnivalTree(root.left)&&a&&isUnivalTree(root.right);
    }
}
