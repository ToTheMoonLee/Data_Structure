package practice.leetcode.easy.tree;

import practice.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Given a Binary Search Tree and a target number,
 * return true if there exist two elements in the BST such that their sum is equal to the given target.
 *
 * Example 1:
 *
 * Input:
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Target = 9
 *
 * Output: True
 *
 *
 * Example 2:
 *
 * Input:
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 *
 * Target = 28
 *
 * Output: False
 */
public class $653TwoSum4InputIsABST {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);

        System.out.println(findTarget(root,9));
        System.out.println(findTarget2(root,9));
        System.out.println(findTarget3(root,9));
    }

    /**
     * their smart solution of this problem
     * @param root
     * @param k
     * @return
     */
    static boolean findTarget3(TreeNode root, int k) {
        return dfs(root, root,  k);
    }
    static boolean dfs(TreeNode root,TreeNode cur,int k) {
        if (cur == null) return false;
        return search(root,cur,k-cur.val) || dfs(root,cur.left,k) || dfs(root,cur.right,k);
    }

    static boolean search(TreeNode root,TreeNode cur,int val) {
        if (root == null) return false;
        return root.val == val && root != cur || root.val < val && search(root.right,cur,val) || root.val > val && search(root.left,cur,val);
    }

    /**
     * my second solution of this problem
     */
    static List<Integer> list;
    static boolean findTarget2(TreeNode root, int k) {
        list = new ArrayList<>();
        inOrder(root);
        if (list.size() <=1) return false;
        int i=0;
        int j=list.size()-1;
        while (i<j) {
            int l = list.get(i);
            int r = list.get(j);
            if (l+r == k) return true;
            if (l+r > k) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
    static void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        list.add(root.val);
        inOrder(root.right);
    }

    /**
     * my first solution of this problem
     */
    static HashSet<Integer> set = new HashSet<>();
    static boolean result = false;
    static boolean findTarget(TreeNode root, int k) {
        preOrder(root,k);
        return result;
    }
    static void preOrder(TreeNode root,int k) {
        if (root == null) return;
        if (set.contains(root.val)) {
            result = true;
            return;
        }
        set.add(k-root.val);
        preOrder(root.left,k);
        preOrder(root.right,k);
    }
}
