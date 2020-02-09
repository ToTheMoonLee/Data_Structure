package practice.datastructure.tree.binarysearchtree

import practice.datastructure.tree.binarytree.BaseTree

class BinarySearchTree : BaseTree() {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val arr = arrayOf(17, 50, 13, 18, 34, 58, 16, 25, 51, 66, 19, 27, 55)
            val binarySearchTree = BinarySearchTree()
            println("----------------------- initial binary tree")
            val root = binarySearchTree.initBinarySearchTree(arr)
            binarySearchTree.inOrder(root)

            println()
            println("----------------------- insert node")
            binarySearchTree.insert(root, IntTreeNode(null, null, 30))
            binarySearchTree.inOrder(root)

            println()
            println("----------------------- find node")
            val result = binarySearchTree.find(root, 25)
            println(
                " find 25 --- node data is  ${result?.data}, " +
                        "left data is ${result?.left?.data}, right data is ${result?.right?.data}"
            )
            println("find 100 --- node is ${binarySearchTree.find(root, 100)}")


            println()
            println("----------------------- delete node")
            binarySearchTree.delete(root, 15)
            binarySearchTree.inOrder(root)

            println()
            println("----------------------- recursion insert")
            binarySearchTree.recursionInsert(root,
                IntTreeNode(null, null, 15)
            )
            binarySearchTree.inOrder(root)


            println()
            println("----------------------- recursionDelete node")
            binarySearchTree.recursionDelete(root, 15)
            binarySearchTree.inOrder(root)
        }
    }

    fun recursionDelete(root: IntTreeNode?, data: Int): IntTreeNode? {
        if (root == null) {
            return null
        }
        if (data < root.data) {
            root.left = recursionDelete(root.left, data)
        } else if (data > root.data) {
            root.right = recursionDelete(root.right, data)
        } else {
            if (root.left == null) {
                return root.right
            }
            if (root.right == null) {
                return root.left
            }
            var min = root.right
            while (min != null) {
                min = min.left
            }
            root.data = min?.data ?: -1
            root.right = recursionDelete(root.right, min?.data ?: -1)
        }
        return root
    }

    fun recursionInsert(root: IntTreeNode?, node: IntTreeNode) : IntTreeNode? {
        if (root == null) {
            return node
        }
        when {
            node.data < root.data -> root.left = recursionInsert(root.left, node)
            node.data > root.data -> root.right = recursionInsert(root.right, node)
        }
        return root
    }

    fun delete(root: IntTreeNode?, data: Int): IntTreeNode? {
        var target = root
        var parentTarget: IntTreeNode? = null
        while (target != null && data != target.data) {
            parentTarget = target
            target = if (data < target.data) {
                target.left
            } else {
                target.right
            }
        }
        if (target == null) {
            return root
        }
        if (target.left != null && target.right != null) {
            var min = target.right
            var minP = target
            while (min?.left != null) {
                minP = min
                min = min.left
            }
            target.data = min?.data ?: -1
            parentTarget = minP
            target = min
        }

        var child: IntTreeNode? = null
        if (target?.left != null) {
            child = target.left
        } else if (target?.right != null) {
            child = target.right
        }

        when {
            parentTarget == null -> return child
            parentTarget.left == target -> parentTarget.left = child
            else -> parentTarget.right = child
        }
        return root
    }

    fun find(root: IntTreeNode?, data: Int): IntTreeNode? {
        if (root == null) {
            return null
        }
        var curNode = root
        while (curNode != null) {
            curNode = when {
                data < curNode.data -> curNode.left
                data > curNode.data -> curNode.right
                else -> return curNode
            }
        }
        return curNode
    }

    fun inOrder(root: IntTreeNode?) {
        if (root == null) {
            return
        }
        inOrder(root.left)
        print("${root.data}->")
        inOrder(root.right)
    }

    fun initBinarySearchTree(arr: Array<Int>): IntTreeNode {
        val root = IntTreeNode(null, null, 33)

        for (item in arr) {
            insert(root, IntTreeNode(null, null, item))
        }
        return root
    }

    fun insert(root: IntTreeNode?, node: IntTreeNode): IntTreeNode? {
        if (root == null) {
            return node
        }
        var curNode = root;
        while (curNode != null) {
            if (node.data < curNode.data) {
                if (curNode.left == null) {
                    curNode.left = node
                    return root
                }
                curNode = curNode.left
            } else {
                if (curNode.right == null){
                    curNode.right = node
                    return root
                }
                curNode = curNode.right
            }

        }
        return root
    }
}

