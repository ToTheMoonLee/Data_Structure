package practice.leetcode.easy.tree;

import practice.leetcode.TreeNode;

/**
 * You are given a binary tree in which each node contains an integer value.
 *
 * Find the number of paths that sum to a given value.
 *
 * The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).
 *
 * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 *
 * Example:
 *
 * root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *
 *       10
 *      /  \
 *     5   -3
 *    / \    \
 *   3   2   11
 *  / \   \
 * 3  -2   1
 *
 * Return 3. The paths that sum to 8 are:
 *
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3. -3 -> 11
 */
public class $437PathSum3 {

    /**
     * their amazing solution of this problem
     * <a href="https://leetcode.com/problems/path-sum-iii/discuss/91878/17-ms-O(n)-java-Prefix-sum-method"/>
     * @param args
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);

        root.left.right = new TreeNode(2);
        root.left.right.right = new TreeNode(1);

        root.right = new TreeNode(-3);
        root.right.right = new TreeNode(11);

        System.out.println(pathSum(root, 8));
    }

    /**
     * their recusive solution of this problem
     * @param root
     * @param sum
     * @return
     */
    static int pathSum(TreeNode root,int sum) {
        if (root == null) return 0;
        return pathSumFrom(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }
    static int pathSumFrom(TreeNode root,int sum) {
        if (root == null) return 0;
        return ((root.val == sum) ? 1 : 0) + pathSumFrom(root.left, sum - root.val) + pathSumFrom(root.right, sum - root.val);
    }
}
