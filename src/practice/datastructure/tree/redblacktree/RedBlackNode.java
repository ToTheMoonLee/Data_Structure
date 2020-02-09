package practice.datastructure.tree.redblacktree;

public class RedBlackNode {

    public RedBlackNode left;
    public RedBlackNode right;
    public int data;
    public boolean isRed = false;

    public RedBlackNode(RedBlackNode left, RedBlackNode right, int data, boolean isRed) {
        this.left = left;
        this.right = right;
        this.data = data;
        this.isRed = isRed;
    }
}
