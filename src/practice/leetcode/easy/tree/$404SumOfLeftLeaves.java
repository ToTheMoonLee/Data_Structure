package practice.leetcode.easy.tree;

import practice.leetcode.TreeNode;

import java.util.Stack;

/**
 * Find the sum of all left leaves in a given binary tree.
 *
 * Example:
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 */
public class $404SumOfLeftLeaves {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(sumOfLeftLeaves(root));
        System.out.println(sumOfLeftLeaves2(root));
        System.out.println(sumOfLeftLeaves3(root));
    }

    /**
     * their iterative solution of this problem
     * @param root
     * @return
     */
    static int sumOfLeftLeaves3(TreeNode root) {
        if (root == null) return 0;
        Stack<TreeNode> stack = new Stack<>();
        int result = 0;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.left!=null) {
                if (node.left.left == null && node.left.right==null) result+=node.left.val;
                else stack.push(node.left);
            }
            if (node.right!=null) {
                stack.push(node.right);
            }
        }
        return result;
    }

    /**
     * their recursive solution of this problem
     * @param root
     * @return
     */
    static int sumOfLeftLeaves2(TreeNode root) {
        if(root == null) return 0;
        int ans = 0;
        if(root.left != null) {
            if(root.left.left == null && root.left.right == null) ans += root.left.val;
            else ans += sumOfLeftLeaves2(root.left);
        }
        ans += sumOfLeftLeaves2(root.right);

        return ans;
    }

    /**
     * my solution of this problem
     * @param root
     * @return
     */
    static int sumOfLeftLeaves(TreeNode root) {
        if (root == null) return 0;
        if (root.right == null && root.left == null) return 0;
        return getSum(root);
    }

    static int getSum(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return root.val;
        if (hasRightLeft(root)) return getSum(root.left);
        return getSum(root.left) + getSum(root.right);
    }

    static boolean hasRightLeft(TreeNode root) {
        if (root!=null && root.right!=null && root.right.left == null && root.right.right == null) return true;
        return false;
    }
}
