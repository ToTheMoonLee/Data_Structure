package practice.leetcode.easy.tree;

import practice.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Consider all the leaves of a binary tree.  From left to right order,
 * the values of those leaves form a leaf value sequence.
 *
 *     1       3
 *    / \     / \
 *   4  5    4  5
 *
 *
 * For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).
 *
 * Two binary trees are considered leaf-similar if their leaf value sequence is the same.
 *
 * Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
 *
 *
 *
 * Constraints:
 *
 * Both of the given trees will have between 1 and 200 nodes.
 * Both of the given trees will have values between 0 and 200
 */
public class $872LeafSimilarTrees {

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(4);
        root1.right = new TreeNode(5);

        TreeNode root2 = new TreeNode(3);
        root2.left = new TreeNode(4);
        root2.right = new TreeNode(5);

        System.out.println(leafSimilar(root1, root2));
        System.out.println(leafSimilar2(root1, root2));
    }

    /**
     * their dfs solution of this problem
     * @param root1
     * @param root2
     * @return
     */
    static boolean leafSimilar2(TreeNode root1, TreeNode root2) {
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root1);
        s2.push(root2);
        while (!s1.isEmpty()&&!s2.isEmpty()) {
            if (dfs(s1)!=dfs(s2)) return false;
        }
        return s1.isEmpty() && s2.isEmpty();
    }

    static int dfs(Stack<TreeNode> stack) {
        while(true) {
            TreeNode t = stack.pop();
            if (t.left!=null) stack.push(t.left);
            if (t.right!=null) stack.push(t.right);
            if (t.left == null && t.right == null) return t.val;
        }
    }

    /**
     * my solution of this problem
     */
    static List<Integer> list1 = new ArrayList<>();
    static List<Integer> list2 = new ArrayList<>();
    static boolean leafSimilar(TreeNode root1, TreeNode root2) {
        inOrder(root1,true);
        inOrder(root2,false);
        if (list1.size()!=list2.size()) return false;
        for (int i=0;i<list1.size();i++) {
            if (list1.get(i)!=list2.get(i)) return false;
        }
        return true;
    }

    static void inOrder(TreeNode root,boolean a) {
        if (root == null) return;
        inOrder(root.left,a);
        if (root.left == null && root.right == null) {
            if (a) list1.add(root.val);
            else list2.add(root.val);
        }
        inOrder(root.right,a);
    }
}
