package practice.leetcode.easy.tree;

import practice.leetcode.TreeNode;

/**
 * Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST
 * is changed to the original key plus sum of all keys greater than the original key in BST.
 *
 * Example:
 *
 * Input: The root of a Binary Search Tree like this:
 *               5
 *             /   \
 *            2     13
 *
 * Output: The root of a Greater Tree like this:
 *              18
 *             /   \
 *           20     13
 * Note: This question is the same as 1038: https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
 */
public class $538ConvertBSTToGreaterTree {

    /**
     * find more intuition,we can visit this web
     * <a href="https://leetcode.com/problems/convert-bst-to-greater-tree/solution/"/>
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(13);
//        System.out.println(convertBST(root));
        System.out.println(convertBST2(root));
        System.out.println(root.val);
    }

    /**
     * my second solution of this problem
     */
    static int prev = 0;
    static TreeNode convertBST2(TreeNode root) {
        inOrder2(root);
        return root;
    }

    static void inOrder2(TreeNode root) {
        if (root == null) return;
        inOrder2(root.right);
        root.val+=prev;
        prev = root.val;
        inOrder2(root.left);
    }

    /**
     * my first solution of this problem
     */
    static int sum = 0;
    static int curSum = 0;
    static boolean isFirst = true;
    static TreeNode convertBST(TreeNode root) {
        inOrder(root);
        isFirst = false;
        inOrder(root);
        return root;
    }

    static void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        if (isFirst) {
            sum += root.val;
        } else {
            int temp = root.val;
            root.val = sum - curSum;
            curSum += temp;
        }
        inOrder(root.right);
    }
}
