package practice.leetcode.medium.tree;

import practice.leetcode.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * <p>
 * According to the definition of LCA on Wikipedia:
 * “The lowest common ancestor is defined
 * between two nodes p and q as the lowest node in T that has both p and q as descendants
 * (where we allow a node to be a descendant of itself).”
 */
public class $236LowestCommonAncestorOfABinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        System.out.println(lowestCommonAncestor(root, new TreeNode(5), new TreeNode(1)).val);
        System.out.println(lowestCommonAncestor3(root, new TreeNode(5), new TreeNode(1)).val);
    }

    /**
     * their more concise solution of this problem
     * @param root
     * @param p
     * @param q
     * @return
     */
    static TreeNode lowestCommonAncestor3(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q)  return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null)   return root;
        return left != null ? left : right;
    }

    /**
     * my solution of this problem
     */
    static TreeNode result;

    static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        helper(root, p, q);
        return result;
    }

    static boolean helper(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return false;
        boolean leftHasNode = helper(root.left, p, q);
        boolean rightHasNode = helper(root.right, p, q);
        boolean curNode = root.val == p.val || root.val == q.val;
        boolean isDone = (root.val == p.val && (leftHasNode || rightHasNode))
                || (root.val == q.val && (leftHasNode || rightHasNode)) ||
                (leftHasNode && rightHasNode);
        if (isDone) result = root;
        return leftHasNode || rightHasNode || curNode;
    }


    /**
     * their concise recursive solution of this problem
     */
    static TreeNode ans;
    static TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        // Traverse the tree
        recurseTree(root, p, q);
        return ans;
    }

    static boolean recurseTree(TreeNode currentNode, TreeNode p, TreeNode q) {

        // If reached the end of a branch, return false.
        if (currentNode == null) {
            return false;
        }

        // Left Recursion. If left recursion returns true, set left = 1 else 0
        int left = recurseTree(currentNode.left, p, q) ? 1 : 0;

        // Right Recursion
        int right = recurseTree(currentNode.right, p, q) ? 1 : 0;

        // If the current node is one of p or q
        int mid = (currentNode == p || currentNode == q) ? 1 : 0;


        // If any two of the flags left, right or mid become True
        if (mid + left + right >= 2) {
            ans = currentNode;
        }

        // Return true if any one of the three bool values is True.
        return (mid + left + right > 0);
    }

    /**
     * their iterative solution of this problem,but slower
     * @param root
     * @param p
     * @param q
     * @return
     */
    static TreeNode lowestCommonAncestor4(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> stack = new Stack<>();
        HashMap<TreeNode,TreeNode> parents = new HashMap<>();
        parents.put(root,null);
        stack.push(root);

        while (!parents.containsKey(p) || !parents.containsKey(q)) {
            TreeNode node = stack.pop();
            if (node.left!=null) {
                stack.push(node.left);
                parents.put(node.left,node);
            }
            if (node.right!=null) {
                stack.push(node.right);
                parents.put(node.right,node);
            }
        }
        HashSet<TreeNode> set = new HashSet<>();
        while (p!=null) {
            set.add(p);
            p = parents.get(p);
        }
        while (!set.contains(q)) {
            q = parents.get(q);
        }
        return q;
    }

}
