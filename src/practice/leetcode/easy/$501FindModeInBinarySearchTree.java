package practice.leetcode.easy;

import practice.datastructure.util.PrintUtil;

/**
 * Given a binary search tree (BST) with duplicates,
 * find all the mode(s) (the most frequently occurred element) in the given BST.
 *
 * Assume a BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than or equal to the node's key.
 * The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 *
 * For example:
 * Given BST [1,null,2,2],
 *
 *    1
 *     \
 *      2
 *     /
 *    2
 *
 *
 * return [2].
 *
 * Note: If a tree has more than one mode, you can return them in any order.
 *
 * Follow up: Could you do that without using any extra space?
 * (Assume that the implicit stack space incurred due to recursion does not count).
 */
public class $501FindModeInBinarySearchTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(2);
        PrintUtil.printArr(findMode(root));
    }

    /**
     * their space O(1) solution of this problem
     */
    static int curCount = 0;
    static int maxCount = 0;
    static int curval = 0;
    static int modecount = 0;
    static int[] result;
    static int[] findMode(TreeNode root) {
        inOrder(root);
        result = new int[modecount];
        curCount = 0;
        modecount = 0;
        inOrder(root);
        return result;
    }

    static void handle(int val) {
        if (val != curval) {
            curval = val;
            curCount = 0;
        }
        curCount++;
        if (curCount > maxCount) {
            maxCount = curCount;
            modecount = 1;
        } else if (curCount == maxCount) {
            if (result!=null) {
                result[modecount] = val;
            }
            modecount++;
        }
    }

    static void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        handle(root.val);
        inOrder(root.right);
    }
}
