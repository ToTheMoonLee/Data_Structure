package practice.leetcode.easy;

/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 *
 * For this problem, a height-balanced binary tree is defined as a binary tree
 * in which the depth of the two subtrees of every node never differ by more than 1.
 *
 * Example:
 *
 * Given the sorted array: [-10,-3,0,5,9],
 *
 * One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 */
public class $108ConvertSortedArrayToBinarySearchTree {

    public static void main(String[] args) {
        TreeNode root = sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        preOrder(root);
        System.out.println();
        TreeNode root1 = sortedArrayToBST2(new int[]{});
        preOrder(root1);
    }

    /**
     * their solution of this problem
     * @param nums
     * @return
     */
    static TreeNode sortedArrayToBST2(int[] nums) {
        if (nums == null) return null;
        return makeBST(nums, 0, nums.length - 1);
    }

    /**
     * my solution of this problem
     * @param nums
     * @return
     */
    static TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        int start = 0;
        int end = nums.length - 1;
        int mid = (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = makeBST(nums,start,mid-1);
        root.right = makeBST(nums,mid+1,end);
        return root;
    }

    static TreeNode makeBST(int[] nums,int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = makeBST(nums,start,mid-1);
        node.right = makeBST(nums,mid+1,end);
        return node;
    }


    static void preOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.print(root.val + "->");
        preOrder(root.left);
        preOrder(root.right);
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
