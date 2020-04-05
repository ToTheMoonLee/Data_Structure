package practice.datastructure.util;

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
}
