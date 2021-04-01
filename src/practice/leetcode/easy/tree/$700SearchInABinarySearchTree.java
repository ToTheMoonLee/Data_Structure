package practice.leetcode.easy.tree;

import practice.datastructure.util.PrintUtil;
import practice.leetcode.TreeNode;

/**
 * Given the root node of a binary search tree (BST) and a value.
 * You need to find the node in the BST that the node's value equals the given value.
 * Return the subtree rooted with that node. If such node doesn't exist, you should return NULL.
 *
 * For example,
 *
 * Given the tree:
 *         4
 *        / \
 *       2   7
 *      / \
 *     1   3
 *
 * And the value to search: 2
 * You should return this subtree:
 *
 *       2
 *      / \
 *     1   3
 * In the example above, if we want to search the value 5, since there is no node with value 5, we should return NULL.
 *
 * Note that an empty tree is represented by NULL,
 * therefore you would see the expected output (serialized tree format) as [], not null.
 */
public class $700SearchInABinarySearchTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        PrintUtil.printBT(searchBST(root,2));
        System.out.println("----------------");
        PrintUtil.printBT(searchBST2(root,2));
    }

    /**
     * my iterative solution of this problem
     * @param root
     * @param val
     * @return
     */
    static TreeNode searchBST2(TreeNode root, int val) {
        if (root == null) return null;
        while (root != null) {
            if (root.val == val) return root;
            if (val > root.val) root = root.right;
            else root = root.left;
        }
        return null;
    }

    /**
     * my recursive solution of this problem
     * @param root
     * @param val
     * @return
     */
    static TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;
        if (root.val == val) return root;
        if (val > root.val) return searchBST(root.right,val);
        else return searchBST(root.left,val);
    }
}
