package practice.datastructure.tree.redblacktree;

public class RedBlackTree {

    private RedBlackNode root;
    static RedBlackTree redBlackTree = new RedBlackTree();
    public static void main(String[] args) {

        redBlackTree.initTree();
        redBlackTree.inOrder(redBlackTree.root);

        System.out.println(" root is " + (char) redBlackTree.root.data);
        System.out.println(" root's left is " + (char) redBlackTree.root.left.data);
    }

    private void initTree() {
        put('e');
        put('s');
        put('a');
        put('r');
        put('c');
        put('h');
        put('x');
        put('m');
        put('p');
        put('l');

    }

    private void inOrder(RedBlackNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.println("root color is " + root.isRed + " data is " + (char)root.data);
        inOrder(root.right);
    }

    private void put(int data) {
        root = put(root, data);
        root.isRed = false;
    }

    private RedBlackNode put(RedBlackNode node, int data) {
        if (node == null) {
            return new RedBlackNode(null, null, data, true);
        }
        if (data < node.data) {
            node.left =  put(node.left, data);
        }
        if (data > node.data) {
            node.right = put(node.right, data);
        }
        if (!isRed(node.left) && isRed(node.right)) {
            node = rotateLeft(node);
        }
        if (isRed(node.left) && isRed(node.left.left)) {
            node = rotateRight(node);
        }
        if (isRed(node.left) && isRed(node.right)) {
            flipColors(node);
        }
        return node;
    }

    private void flipColors(RedBlackNode node) {
        node.isRed = true;
        node.left.isRed = false;
        node.right.isRed = false;
    }

    private boolean isRed(RedBlackNode node) {
        if (node == null) {
            return false;
        }
        return node.isRed;
    }

    private RedBlackNode rotateLeft(RedBlackNode h) {
        RedBlackNode x = h.right;
        h.right = x.left;
        x.left = h;
        x.isRed = h.isRed;
        h.isRed = true;
        return x;
    }
    
    private RedBlackNode rotateRight(RedBlackNode h) {
        RedBlackNode x = h.left;
        h.left = x.right;
        x.right = h;
        x.isRed = h.isRed;
        h.isRed = true;
        return x;
    }
}
