package practice.leetcode.easy;

import practice.leetcode.TreeNode;

/**
 * Given a binary tree, find the length of the longest path where each node in the path has the same value.
 * This path may or may not pass through the root.
 *
 * The length of path between two nodes is represented by the number of edges between them.
 *
 *
 *
 * Example 1:
 *
 * Input:
 *
 *               5
 *              / \
 *             4   5
 *            / \   \
 *           1   1   5
 * Output: 2
 *
 *
 *
 * Example 2:
 *
 * Input:
 *
 *               1
 *              / \
 *             4   5
 *            / \   \
 *           4   4   5
 * Output: 2
 *
 *
 *
 * Note: The given binary tree has not more than 10000 nodes. The height of the tree is not more than 1000.
 */
public class $687LongestUnivaluePath {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(1);
        root.right.right = new TreeNode(5);

        System.out.println(longestUnivaluePath(root));
        System.out.println(longestUnivaluePath2(root));
    }

    /**
     * their solution of this problem
     */
    static int ans;
    static int longestUnivaluePath2(TreeNode root) {
        ans = 0;
        arrowLength(root);
        return ans;
    }
    static int arrowLength(TreeNode node) {
        if (node == null) return 0;
        int left = arrowLength(node.left);
        int right = arrowLength(node.right);
        int arrowLeft = 0, arrowRight = 0;
        if (node.left != null && node.left.val == node.val) {
            arrowLeft += left + 1;
        }
        if (node.right != null && node.right.val == node.val) {
            arrowRight += right + 1;
        }
        ans = Math.max(ans, arrowLeft + arrowRight);
        return Math.max(arrowLeft, arrowRight);
    }

    /**
     * my solution of this problem
     * @param root
     * @return
     */
    static int longestUnivaluePath(TreeNode root) {
        if (root == null) return 0;
        return getSame(root)-1;
    }

    static int getSame(TreeNode root) {
        if (root == null) return 0;
        int max = 1;
        if (root.left!=null && root.left.val == root.val) max+= getSamePath(root.left);
        if (root.right!=null && root.right.val == root.val) max+= getSamePath(root.right);
        max = Math.max(max,getSame(root.left));
        return Math.max(max,getSame(root.right));
    }

    static int getSamePath(TreeNode root) {
        if (root == null) return 0;
        int count = 1;
        int l = 0;
        int r = 0;
        if (root.left!=null && root.val== root.left.val) {
            l = getSamePath(root.left);
        }
        if (root.right!=null && root.val== root.right.val) {
            r = getSamePath(root.right);
        }
        return count+Math.max(l,r);
    }
}
