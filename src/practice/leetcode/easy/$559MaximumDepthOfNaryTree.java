package practice.leetcode.easy;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a n-ary tree, find its maximum depth.
 *
 * The maximum depth is the number of nodes along the longest path
 * from the root node down to the farthest leaf node.
 *
 * Nary-Tree input serialization is represented in their level order traversal,
 * each group of children is separated by the null value (See examples).
 *
 *
 *
 * Example 1:
 *
 *
 *
 * Input: root = [1,null,3,2,4,null,5,6]
 * Output: 3
 * Example 2:
 *
 *
 *
 * Input: root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * Output: 5
 *
 *
 * Constraints:
 *
 * The depth of the n-ary tree is less than or equal to 1000.
 * The total number of nodes is between [0, 10^4].
 */
public class $559MaximumDepthOfNaryTree {

    public static void main(String[] args) {
        List<Node> children = new ArrayList<>();
        List<Node> children2 = new ArrayList<>();
        children2.add(new Node(5, null));
        children2.add(new Node(6, null));
        children.add(new Node(3, children2));
        children.add(new Node(2, null));
        children.add(new Node(4, null));
        Node root = new Node(1, children);
        System.out.println(maxDepth(root));
        System.out.println(maxDepth2(root));
    }

    /**
     * my first solution of this problem
     * @param root
     * @return
     */
    static int maxDepth(Node root) {
        if (root == null) return 0;
        if (root.children == null) return 1;
        int max = 0;
        for (Node n : root.children) {
            max = Math.max(max,maxDepth(n));
        }
        return max+1;
    }

    /**
     * the BFS solution of this problem
     * @param root
     * @return
     */
    static int maxDepth2(Node root) {
        if (root == null) return 0;
        int depth = 0;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i=0;i<size;i++) {
                Node n = q.poll();
                if (n.children != null) {
                    for (Node temp : n.children) {
                        q.offer(temp);
                    }
                }
            }
            depth++;
        }
        return depth;
    }
}
