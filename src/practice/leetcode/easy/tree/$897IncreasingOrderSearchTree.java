package practice.leetcode.easy.tree;

import practice.datastructure.util.PrintUtil;
import practice.leetcode.TreeNode;

/**
 * Given a binary search tree, rearrange the tree in in-order
 * so that the leftmost node in the tree is now the root of the tree,
 * and every node has no left child and only 1 right child.
 *
 * Example 1:
 * Input: [5,3,6,2,4,null,8,1,null,null,null,7,9]
 *
 *        5
 *       / \
 *     3    6
 *    / \    \
 *   2   4    8
 *  /        / \
 * 1        7   9
 *
 * Output: [1,null,2,null,3,null,4,null,5,null,6,null,7,null,8,null,9]
 *
 *  1
 *   \
 *    2
 *     \
 *      3
 *       \
 *        4
 *         \
 *          5
 *           \
 *            6
 *             \
 *              7
 *               \
 *                8
 *                 \
 *                  9
 *
 *
 * Constraints:
 *
 * The number of nodes in the given tree will be between 1 and 100.
 * Each node will have a unique integer value from 0 to 1000.
 */
public class $897IncreasingOrderSearchTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);

        PrintUtil.printBT(increasingBST(root));
    }

    /**
     * my solution of this problem
     */
    static TreeNode sentinel = new TreeNode(-1);
    static TreeNode temp = sentinel;
    static TreeNode increasingBST(TreeNode root) {
        inOrder(root);
        return sentinel.right;
    }

    static void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        temp.right = new TreeNode(root.val);
        temp = temp.right;
        inOrder(root.right);
    }
}
