package practice.leetcode.easy;

/**
 * Given a binary tree and a sum, determine
 * if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given the below binary tree and sum = 22,
 *
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \      \
 * 7    2      1
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */
public class $112PathSum {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        System.out.println(hasPathSum(root, 22));
        System.out.println(hasPathSum2(root, 22));
    }

    /**
     * their solution of this problem
     * @param root
     * @param sum
     * @return
     */
    static boolean hasPathSum2(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return sum - root.val == 0;
        return hasPathSum2(root.left, sum - root.val) || hasPathSum2(root.right, sum - root.val);
    }

    /**
     * my solution of this problem
     * @param root
     * @param sum
     * @return
     */
    static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        return getSum(root,0,sum);
    }

    static boolean getSum(TreeNode node,int total, int sum) {
        if (node == null) return total == sum;
        if (node.right == null && node.left == null) return (node.val + total) == sum;
        if (node.right == null) return getSum(node.left,total+node.val,sum);
        if (node.left == null) return getSum(node.right,total+node.val,sum);
        return getSum(node.left,total+node.val,sum) || getSum(node.right,total+node.val,sum) ;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
