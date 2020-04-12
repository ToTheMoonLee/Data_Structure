package practice.datastructure.util;


import practice.leetcode.easy.TreeNode;

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

    public static void printBT(TreeNode root) {
        if (root == null) return;
        System.out.println(String.valueOf(root.val));
        printBT(root.left);
        printBT(root.right);
    }
}
