package practice.leetcode.easy;

import java.util.ArrayList;

/**
 * Given two binary trees, write a function to check if they are the same or not.
 *
 * Two binary trees are considered the same
 * if they are structurally identical and the nodes have the same value.
 *
 * Example 1:
 *
 * Input:     1         1
 *           / \       / \
 *          2   3     2   3
 *
 *         [1,2,3],   [1,2,3]
 *
 * Output: true
 * Example 2:
 *
 * Input:     1         1
 *           /           \
 *          2             2
 *
 *         [1,2],     [1,null,2]
 *
 * Output: false
 * Example 3:
 *
 * Input:     1         1
 *           / \       / \
 *          2   1     1   2
 *
 *         [1,2,1],   [1,1,2]
 *
 * Output: false
 */
public class $100SameTree {
    static int i = 0;
    static int j = 0;

    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(1);

        TreeNode q = new TreeNode(1);
        q.left = new TreeNode(1);
        q.right = new TreeNode(2);

        System.out.println(isSameTree(p, q));
        System.out.println(isSameTree2(p, q));
        System.out.println(isSameTree3(p, q));
    }

    /**
     * their solution of this problem
     * @param p
     * @param q
     * @return
     */
    static boolean isSameTree3(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        if (p.val == q.val) {
            return isSameTree3(p.left, q.left) && isSameTree3(p.right, q.right);
        }
        return false;
    }

    /**
     * my second solution of this problem
     * @param p
     * @param q
     * @return
     */
    static boolean isSameTree2(TreeNode p, TreeNode q) {
        if (p == null && q!=null || p!=null && q==null) {
            return false;
        }
        if (p == null) {
            return true;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree2(p.left, q.left) && isSameTree2(p.right, q.right);
    }
    /**
     * my solution of this problem
     * @param p
     * @param q
     * @return
     */
    static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q != null || p != null && q == null) {
            return false;
        }
        if (p == null && q == null) return true;
        ArrayList<TreeNode> list1 = new ArrayList<>();
        ArrayList<TreeNode> list2 = new ArrayList<>();

        preTraversal(list1, p);
        preTraversal(list2, q);


        if (assertSameTree(list1, list2)) return false;
        if (i != list1.size() || j != list2.size()) {
            return false;
        }
        list1.clear();
        list2.clear();
        inTraversal(list1, p);
        inTraversal(list2, q);
        i = 0;
        j = 0;
        if (assertSameTree(list1, list2)) return false;
        if (i != list1.size() || j != list2.size()) {
            return false;
        }
        return true;

    }

    static boolean assertSameTree(ArrayList<TreeNode> list1, ArrayList<TreeNode> list2) {
        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i).val != list2.get(j).val ||
                    list1.get(i).left == null && list2.get(i).left != null
                    || list1.get(i).left != null && list2.get(i).left == null
                    || list1.get(i).right == null && list2.get(i).right != null
                    || list1.get(i).right != null && list2.get(i).right == null) {
                return true;
            } else {
                i++;
                j++;
            }
        }
        return false;
    }

    static void preTraversal(ArrayList<TreeNode> list, TreeNode p) {
        if (p == null) {
            return;
        }
        list.add(p);
        preTraversal(list, p.left);
        preTraversal(list, p.right);
    }

    static void inTraversal(ArrayList<TreeNode> list, TreeNode p) {
        if (p == null) {
            return;
        }
        inTraversal(list, p.left);
        list.add(p);
        inTraversal(list, p.right);
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
