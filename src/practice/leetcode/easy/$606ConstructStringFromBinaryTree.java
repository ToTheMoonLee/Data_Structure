package practice.leetcode.easy;

/**
 * You need to construct a string consists of parenthesis and
 * integers from a binary tree with the preorder traversing way.
 *
 * The null node needs to be represented by empty parenthesis pair "()".
 * And you need to omit all the empty parenthesis pairs that don't affect the one-to-one mapping relationship
 * between the string and the original binary tree.
 *
 * Example 1:
 * Input: Binary tree: [1,2,3,4]
 *        1
 *      /   \
 *     2     3
 *    /
 *   4
 *
 * Output: "1(2(4))(3)"
 *
 * Explanation: Originallay it needs to be "1(2(4)())(3()())",
 * but you need to omit all the unnecessary empty parenthesis pairs.
 * And it will be "1(2(4))(3)".
 * Example 2:
 * Input: Binary tree: [1,2,3,null,4]
 *        1
 *      /   \
 *     2     3
 *      \
 *       4
 *
 * Output: "1(2()(4))(3)"
 *
 * Explanation: Almost the same as the first example,
 * except we can't omit the first parenthesis pair to break the one-to-one mapping relationship
 * between the input and the output.
 */
public class $606ConstructStringFromBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);

        System.out.println(tree2str(root));
        System.out.println(tree2str2(root));
        System.out.println(tree2str3(root));
    }

    /**
     * their faster solution of this problem
     * @param t
     * @return
     */
    static String tree2str3(TreeNode t) {
        if (t == null) return "";
        StringBuilder result = new StringBuilder();
        preorder(t, result);

        String tmp = result.toString();

        return tmp.substring(1, tmp.length() - 1);
    }

    static void preorder(TreeNode root, StringBuilder tree_str) {
        if (root == null) return;
        tree_str.append("(");
        tree_str.append(root.val); // preorder, add val

        // if node has only right child, append () for left child
        if (root.left == null && root.right != null) {
            tree_str.append("()");
        }

        preorder(root.left, tree_str);
        preorder(root.right, tree_str);

        tree_str.append(")");
    }

    /**
     * my second solution of this problem,beats 49%
     * @param t
     * @return
     */
    static String tree2str2(TreeNode t) {
        if (t == null) return "";
        if (t.left == null && t.right == null) return String.valueOf(t.val);
        if (t.right==null) {
            return t.val+"("+tree2str(t.left)+")";
        } else if (t.left == null) {
            return t.val+"()("+tree2str(t.right)+")";
        } else {
            return t.val+"("+tree2str(t.left)+")("+ tree2str(t.right) +")";
        }
    }

    /**
     * my first solution of this problem,beats 6%
     * @param t
     * @return
     */
    static String tree2str(TreeNode t) {
        if (t == null) return "";
        StringBuilder sb = new StringBuilder();
        sb.append(t.val);
        if (t.left == null && t.right == null) return sb.toString();
        if (t.right==null) {
            sb.append("(").append(tree2str(t.left)).append(")");
        } else if (t.left == null) {
            sb.append("()").append("(").append(tree2str(t.right)).append(")");
        } else {
            sb.append("(").append(tree2str(t.left)).append(")").append("(").append(tree2str(t.right)).append(")");
        }

        return sb.toString();
    }
}
