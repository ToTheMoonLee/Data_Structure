package practice.leetcode.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Given two non-empty binary trees s and t, check whether tree t has exactly the same structure
 * and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all
 * of this node's descendants. The tree s could also be considered as a subtree of itself.
 *
 * Example 1:
 * Given tree s:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * Given tree t:
 *    4
 *   / \
 *  1   2
 * Return true, because t has the same structure and node values with a subtree of s.
 * Example 2:
 * Given tree s:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 *     /
 *    0
 * Given tree t:
 *    4
 *   / \
 *  1   2
 * Return false.
 */
public class $572SubtreeOfAnotherTree {

    public static void main(String[] args) {
        TreeNode s = new TreeNode(3);
        s.left = new TreeNode(4);
        s.right = new TreeNode(5);
        s.left.left = new TreeNode(1);
        s.left.right = new TreeNode(2);

        TreeNode t = new TreeNode(4);
        t.left = new TreeNode(1);
        t.right = new TreeNode(2);

        System.out.println(isSubtree(s, t));
        System.out.println(isSubtree2(s, t));
    }

    /**
     * their recursive solution of this problem
     * @param s
     * @param t
     * @return
     */
    static boolean isSubtree2(TreeNode s, TreeNode t) {
        if (s == null) return false;
        if (isSameTree(s, t)) return true;
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    /**
     * my first solution of this problem
     */
    static List<TreeNode> list = new ArrayList<>();
    static boolean isSubtree(TreeNode s, TreeNode t) {
        inOrder(s,t);
        return list.size() !=0;
    }

    static void inOrder(TreeNode s,TreeNode t) {
        if (s == null) return;
        inOrder(s.left,t);
        if (isSameTree(s,t)) {
            list.add(s);
        }
        if (list.size() > 0) return;
        inOrder(s.right,t);
    }

    static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        return false;
    }
}
