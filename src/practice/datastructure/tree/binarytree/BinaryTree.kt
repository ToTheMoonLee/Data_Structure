package practice.datastructure.tree.binarytree

import java.util.*
import kotlin.collections.ArrayList

/**
 * pre order is      A->B->D->E->C->F->G->
 * in order is       D->B->E->A->F->C->G->
 * post order is     D->E->B->F->G->C->A->
 */
class BinaryTree : BaseTree() {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val binaryTree = BinaryTree()
            val root = binaryTree.initTree()
            println("-------- preOrder start --------")
            binaryTree.preOrder(root)
            println()
            println("-------- preOrder end --------")

            println()
            println("-------- inOrder start --------")
            binaryTree.inOrder(root)
            println()
            println("-------- inOrder end --------")

            println()
            println("-------- postOrder start --------")
            binaryTree.postOrder(root)
            println()
            println("-------- postOrder end --------")

            println()
            println("-------- levelOrder start --------")
            binaryTree.levelOrder(root)
            println()
            println("-------- levelOrder end --------")

        }
    }

    fun preOrder(root: TreeNode?) {
        if (root == null) {
            return
        }
        print("${root.data}->")
        preOrder(root.leftChild)
        preOrder(root.rightChild)
    }

    fun inOrder(root: TreeNode?) {
        if (root == null) {
            return
        }
        inOrder(root.leftChild)
        print("${root.data}->")
        inOrder(root.rightChild)
    }

    fun postOrder(root: TreeNode?) {
        if (root == null) {
            return
        }
        postOrder(root.leftChild)
        postOrder(root.rightChild)
        print("${root.data}->")
    }

    fun levelOrder(root: TreeNode?) {
        val queue: Queue<TreeNode> = LinkedList()
        queue.offer(root)
        val treeArray = ArrayList<TreeNode>()

        while (!queue.isEmpty()) {
            val treeNode = queue.poll()
            treeArray.add(treeNode)
            if (treeNode.leftChild != null) {
                queue.offer(treeNode.leftChild)
            }
            if (treeNode.rightChild != null) {
                queue.offer(treeNode.rightChild)
            }
        }
        for (item in treeArray) {
            print("${item.data}-->")
        }
    }
}













