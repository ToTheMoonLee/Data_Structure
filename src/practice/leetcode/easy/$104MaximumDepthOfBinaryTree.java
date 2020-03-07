package practice.leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

public class $104MaximumDepthOfBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(3);

        System.out.println(maxDepth(root));
        System.out.println(maxDepth2(root));
    }

    static int maxDepth2(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth2(root.left), maxDepth2(root.right));
    }

    /**
     * my first solution of this problem
     *
     * @param root
     * @return
     */
    static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList();
        queue.offer(root);
        int count = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            count++;
        }
        return count;
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
