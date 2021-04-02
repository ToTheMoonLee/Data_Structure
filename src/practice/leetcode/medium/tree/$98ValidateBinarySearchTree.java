package practice.leetcode.medium.tree;

import practice.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 *
 * A valid BST is defined as follows:
 *
 * The left subtree of a node contains only nodes with keys less than the node's key.
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 *
 */
public class $98ValidateBinarySearchTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(isValidBST(root));
    }

    /**
     * their recursive solution of this problem, and faster than mine(but I don't know why)
     * @param root
     * @return
     */
    static boolean isValidBST3(TreeNode root) {
        return helper(root,null,null);
    }

    static boolean helper(TreeNode root, Integer minVal, Integer maxVal) {
        if (root == null) return true;
        if (minVal!=null && root.val <= minVal) return false;
        if (maxVal!=null && root.val >= maxVal) return false;
        return helper(root.left,minVal,root.val) && helper(root.right,root.val,maxVal);
    }

    /**
     * my recursive solution of this problem
     */
    static List<Integer> list = new ArrayList<>();
    static boolean isValidBST(TreeNode root) {
        traverse(root);
        if (list.size() == 0) return false;
        if (list.size() == 1) return true;
        for (int i=1;i<list.size();i++) {
            if (list.get(i) <= list.get(i-1)) return false;
        }
        return true;
    }

    static void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.left);
        list.add(root.val);
        traverse(root.right);
    }

    /**
     * their iterative solution of this problem
     * @param root
     * @return
     */
    static boolean isValidBST2(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode pre = null;
        while (root!=null || !stack.isEmpty()) {
            while (root!=null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (pre !=null && pre.val >= root.val) return false;
            pre = root;
            root = root.right;
        }
        return true;
    }
}
