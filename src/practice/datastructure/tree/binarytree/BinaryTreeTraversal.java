package practice.datastructure.tree.binarytree;

import java.util.Stack;

/**
 * pre order is      A->B->D->E->C->F->G->
 * in order is       D->B->E->A->F->C->G->
 * post order is     D->E->B->F->G->C->A->
 */
public class BinaryTreeTraversal extends BaseTree {

    public static void main(String[] args) {
        BinaryTreeTraversal binaryTreeTraversal = new BinaryTreeTraversal();
        TreeNode root = binaryTreeTraversal.initTree();

        System.out.println("-------- preOrder start --------");
        binaryTreeTraversal.preOrder(root);
        System.out.println("-------- preOrder end --------");
        System.out.println();

        System.out.println("-------- inOrder start --------");
        binaryTreeTraversal.inOrder(root);
        System.out.println("-------- inOrder end --------");
        System.out.println();

        System.out.println("-------- postOrder start --------");
        binaryTreeTraversal.postOrder(root);
        System.out.println("-------- postOrder end --------");
        System.out.println();
    }

    private void preOrder(TreeNode root) {
        if (root == null) {
            System.out.println("empty tree");
            return;
        }
        TreeNode temp = root;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(temp);
        while (!stack.isEmpty()) {
            temp = stack.pop();
            System.out.print(temp.getData() + "->");
            if (temp.getRightChild() != null) {
                stack.push(temp.getRightChild());
            }
            if (temp.getLeftChild() != null) {
                stack.push(temp.getLeftChild());
            }
        }
        System.out.println();
    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            System.out.println("empty tree");
            return;
        }
        TreeNode temp = root;
        Stack<TreeNode> stack = new Stack<>();
        while (temp != null || !stack.isEmpty()) {
            while (temp != null) {
                stack.push(temp);
                temp = temp.getLeftChild();
            }
            temp = stack.pop();
            System.out.print(temp.getData() + "->");
            if (temp.getRightChild() != null) {
                temp = temp.getRightChild();
            } else {
                temp = null;
            }
        }
        System.out.println();
    }

    private void postOrder(TreeNode root) {
        if (root == null) {
            System.out.println("empty tree");
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        TreeNode pre = null;
        while (temp != null || !stack.isEmpty()) {
            while (temp != null) {
                stack.push(temp);
                temp = temp.getLeftChild();
            }
            temp = stack.peek();
            if (temp.getRightChild() == null || temp.getRightChild() == pre) {
                temp = stack.pop();
                System.out.print(temp.getData() + "->");
                pre = temp;
                temp = null;
            } else {
                temp = temp.getRightChild();
            }
        }
        System.out.println();
    }
}
