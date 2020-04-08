package practice.leetcode.easy;

/**
 * Given a binary search tree with non-negative values,
 * find the minimum absolute difference between values of any two nodes.
 *
 * Example:
 *
 * Input:
 *
 *    1
 *     \
 *      3
 *     /
 *    2
 *
 * Output:
 * 1
 *
 * Explanation:
 * The minimum absolute difference is 1, which is the difference between 2 and 1 (or between 2 and 3).
 *
 *
 * Note:
 *
 * There are at least two nodes in this BST.
 * This question is the same as 783: https://leetcode.com/problems/minimum-distance-between-bst-nodes/
 */
public class $MinimumAbsoluteDifferenceInBST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        System.out.println(getMinimumDifference(root));
        System.out.println("-----------------------");
        System.out.println(getMinimumDifference2(root));
    }

    /**
     * their inorder traversal solution of this problem
     */
    static int minVal = Integer.MAX_VALUE;
    static TreeNode prev = null;
    static int getMinimumDifference2(TreeNode root) {
        inOrder(root);
        return minVal;
    }

    static void inOrder(TreeNode node) {
        if (node == null) return;
        inOrder(node.left);
        if (prev != null) minVal = Math.min(minVal,node.val - prev.val);
        prev = node;
        inOrder(node.right);
    }

    /**
     * my solution of this problem
     */
    static int min = Integer.MAX_VALUE;
    static int getMinimumDifference(TreeNode root) {
        if (root == null) return min;
        if (root.left !=null) {
            min = Math.min(root.val - getMax(root.left),min);
            min = Math.min(getMinimumDifference(root.left),min);
        }
        if (root.right !=null) {
            min = Math.min(getMin(root.right) - root.val,min);
            min = Math.min(getMinimumDifference(root.right),min);
        }
        return min;

    }

    static int getMin(TreeNode node) {
        if (node.left == null) return node.val;
        return getMin(node.left);
    }

    static int getMax(TreeNode node) {
        if (node.right == null) return node.val;
        return getMax(node.right);
    }
}
