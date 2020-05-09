package practice.leetcode.easy;

import practice.datastructure.util.PrintUtil;

import java.util.HashMap;
import java.util.Stack;

public class $1022SumOfRootToLeafBinaryNumbers {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(0);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(1);

        System.out.println(sumRootToLeaf(root));
        System.out.println(sumRootToLeaf2(root));
        System.out.println(sumRootToLeaf3(root));

        int[] a = new int[]{1, 5, 0, -1, 3, 6, 5, 10, -3, -10};
        quickSort(a, 0, a.length-1);
        PrintUtil.printArr(a);
    }

    static void quickSort(int[] nums,int start,int end) {
        if (start >= end) return;
        int pivot = nums[end];
        int i = start;
        int j = start;
        while (j<end) {
            if (nums[j]>pivot) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                i++;
                j++;
            } else {
                j++;
            }
        }
        nums[end] = nums[i];
        nums[i] = pivot;
        quickSort(nums,start,i-1);
        quickSort(nums,i+1,end);
    }

    /**
     * their solution of this problem
     * @param root
     * @return
     */
    static int sumRootToLeaf3(TreeNode root) {
        return helper(root,0);
    }

    static int helper(TreeNode root, int val) {
        if (root == null) return 0;
        val = val*2+root.val;
        return root.left == root.right ? val : helper(root.left,val) + helper(root.right,val);
    }

    /**
     * my second solution of this problem,29%
     * @param root
     * @return
     */
    static int sumRootToLeaf2(TreeNode root) {
        HashMap<TreeNode,Integer> map = new HashMap<>();
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        map.put(root,1);
        int b = 0;
        int ans = 0;
        int curBits = 1;
        while (!s.isEmpty()) {
            TreeNode temp = s.pop();
            int level = map.get(temp);
            if (curBits == 1 && level == 1) {
                b |= temp.val;
            } else if (curBits < level) {
                b = b<<1;
                b |= temp.val;
                curBits++;
            } else {
                while (curBits >=level) {
                    b = b>>1;
                    curBits--;
                }
                b = b<<1;
                b |= temp.val;
                curBits++;
            }
            if (temp.left == null && temp.right == null) {
                ans+=b;
            }
            if (temp.left != null) {
                s.push(temp.left);
                map.put(temp.left,level+1);
            }
            if (temp.right != null) {
                s.push(temp.right);
                map.put(temp.right,level+1);
            }
        }
        return ans;
    }

    /**
     * my first solution of this problem ,6%
     * @param root
     * @return
     */
    static int sumRootToLeaf(TreeNode root) {
        HashMap<TreeNode,Integer> map = new HashMap<>();
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        map.put(root,1);
        String b = "";
        int ans = 0;
        while (!s.isEmpty()) {
            TreeNode temp = s.pop();
            int level = map.get(temp);
            if (b.length() < level) {
                b = b+temp.val;
            } else {
                b = b.substring(0,level-1);
                b = b+temp.val;
            }
            if (temp.left == null && temp.right == null) {
                ans+=getInt(b);
            }
            if (temp.left != null) {
                s.push(temp.left);
                map.put(temp.left,level+1);
            }
            if (temp.right != null) {
                s.push(temp.right);
                map.put(temp.right,level+1);
            }
        }
        return ans;
    }

    static int getInt(String s) {
        int res = 0;
        for (int i=s.length()-1;i>=0;i--) {
            if (s.charAt(i)=='1') {
                res = res + (int)Math.pow(2,s.length()-1-i);
            }
        }
        return res;
    }
}
