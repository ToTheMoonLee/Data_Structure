package practice.datastructure.sort;

public abstract class BaseSort {

    static int count = 0;
    static int[] arr = new int[]{45, 2, 1, 66, 3, 8};
    static int[] arr2 = new int[]{1,2,3,4,5,6};

    static void printArr(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(" arr[" + i + "] = " + arr[i] + ", count ==  " + count);
        }
    }
}
