package practice.datastructure.sort;

/**
 * best time complexity O(n)
 * worst time complexity O(n²)
 * average time complexity O(n²)
 *
 * 原地排序
 *
 * 稳定排序
 *
 */
public class InsertionSort extends BaseSort {

    public static void main(String[] args) {
        sort(arr2);
        printArr(arr2);
    }

    private static void sort(int[] arr) {
        if (arr.length <= 1) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            int value = arr[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                count++;
                if (arr[j] > value) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = value;
        }
    }
}
