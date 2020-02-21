package practice.datastructure.tree.binarytree

/**
 * pre order is      A->B->D->E->C->F->G->
 * in order is       D->B->E->A->F->C->G->
 * post order is     D->E->B->F->G->C->A->
 */
open class BaseTree {

    fun initTree(): TreeNode {
        val root = TreeNode("A", null, null)
        val treeB = TreeNode("B", null, null)
        val treeC = TreeNode("C", null, null)
        val treeD = TreeNode("D", null, null)
        val treeE = TreeNode("E", null, null)
        val treeF = TreeNode("F", null, null)
        val treeG = TreeNode("G", null, null)

        root.leftChild = treeB
        root.rightChild = treeC
        treeB.leftChild = treeD
        treeB.rightChild = treeE
        treeC.leftChild = treeF
        treeC.rightChild = treeG

        return root
    }

}
