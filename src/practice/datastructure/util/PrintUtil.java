package practice.datastructure.util;


import practice.leetcode.ListNode;
import practice.leetcode.TreeNode;

import java.util.List;

public class PrintUtil {

    public static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(" arr[" + i + "] = " + arr[i]);
        }
    }

    public static void printList(List<String> list) {
        for (String s : list) {
            System.out.println(s);
        }
    }
    public static void printList2(List<Integer> list) {
        for (Integer s : list) {
            System.out.println(s);
        }
    }
    public static void printList3(List<List<Integer>> list) {
        for (List<Integer> arr : list) {
            for (int i = 0; i < arr.size(); i++) {
                System.out.print(arr.get(i));
                if (i != arr.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
            System.out.println(" --------------- ");
        }
    }
    public static void printList4(List<Boolean> list) {
        for (Boolean s : list) {
            System.out.println(s);
        }
    }
    public static void printArr(String[] arr) {
        for (String s : arr) {
            System.out.println(s);
        }
    }
    public static void printArr(int[][] arr) {
        for (int i=0;i<arr.length;i++) {
            for (int j=0;j<arr[i].length;j++) {
                System.out.print(arr[i][j]);
                if (j == arr[i].length-1) {
                    System.out.println();
                }
            }
        }
    }

    public static void printListNode(ListNode head) {
        while (head != null) {
            System.out.println("val is : " + head.val);
            head = head.next;
        }
    }

    public static void printBT(TreeNode root) {
        if (root == null) return;
        System.out.println(String.valueOf(root.val));
        printBT(root.left);
        printBT(root.right);
    }
}
