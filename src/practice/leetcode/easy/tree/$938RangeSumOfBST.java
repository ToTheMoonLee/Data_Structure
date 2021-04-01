package practice.leetcode.easy.tree;

import practice.leetcode.TreeNode;

/**
 * Given the root node of a binary search tree,
 * return the sum of values of all nodes with value between L and R (inclusive).
 *
 * The binary search tree is guaranteed to have unique values.
 *
 *
 *
 * Example 1:
 *
 * Input: root = [10,5,15,3,7,null,18], L = 7, R = 15
 * Output: 32
 * Example 2:
 *
 * Input: root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
 * Output: 23
 *
 *
 * Note:
 *
 * The number of nodes in the tree is at most 10000.
 * The final answer is guaranteed to be less than 2^31.
 */
public class $938RangeSumOfBST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(18);

        System.out.println(rangeSumBST(root, 7, 15));
    }

    /**
     * my solution of this problem
     * @param root
     * @param L
     * @param R
     * @return
     */
    static int rangeSumBST(TreeNode root, int L, int R) {
        if (root == null) return 0;
        if (root.val > R) return rangeSumBST(root.left,L,R);
        if (root.val < L) return rangeSumBST(root.right,L,R);
        return rangeSumBST(root.left,L,R) + root.val + rangeSumBST(root.right,L,R);
    }
}
