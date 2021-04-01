package practice.leetcode.easy.tree;

import practice.datastructure.util.PrintUtil;
import practice.leetcode.TreeNode;

/**
 * Given a binary search tree and the lowest and highest boundaries as L and R,
 * trim the tree so that all its elements lies in [L, R] (R >= L). You might need to change the root of the tree,
 * so the result should return the new root of the trimmed binary search tree.
 *
 * Example 1:
 * Input:
 *     1
 *    / \
 *   0   2
 *
 *   L = 1
 *   R = 2
 *
 * Output:
 *     1
 *       \
 *        2
 * Example 2:
 * Input:
 *     3
 *    / \
 *   0   4
 *    \
 *     2
 *    /
 *   1
 *
 *   L = 1
 *   R = 3
 *
 * Output:
 *       3
 *      /
 *    2
 *   /
 *  1
 */
public class $669TrimABinarySearchTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(2);

        PrintUtil.printBT(trimBST(root, 1, 2));
    }

    /**
     * my solution of this problem
     * @param root
     * @param l
     * @param r
     * @return
     */
    static TreeNode trimBST(TreeNode root, int l, int r) {
        if (root == null) return null;
        TreeNode left = trimBST(root.left,l,r);
        TreeNode right = trimBST(root.right,l,r);
        if (root.val < l) return right;
        if (root.val > r) return left;
        root.left = left;
        root.right = right;
        return root;
    }
}
