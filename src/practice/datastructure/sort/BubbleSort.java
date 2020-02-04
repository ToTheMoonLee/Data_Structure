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
public class BubbleSort extends BaseSort{

    public static void main(String[] args) {
        sort(arr2);
        printArr(arr2);
    }

    private static void sort2(int[] arr) {
        boolean isSwap = false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                count++;
                if (arr[j] > arr[j + 1]) {
                    isSwap = true;
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
            if (!isSwap) break;
        }
    }

    private static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                count++;
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
