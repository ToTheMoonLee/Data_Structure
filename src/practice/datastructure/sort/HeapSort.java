package practice.datastructure.sort;

public class HeapSort extends BaseSort {

    public static void main(String[] args) {
        heapSort(arr);
        printArr(arr);
    }

    /**
     * 从倒数第一个非叶子节点开始堆化
     * @param arr
     */
    private static void heapSort(int[] arr) {
        for (int i = (arr.length - 2) / 2; i >= 0; i--) {
            heapify(arr, arr.length, i);
        }
        int k = arr.length;
        while (k > 1) {
            int temp = arr[0];
            arr[0] = arr[k - 1];
            arr[k - 1] = temp;
            k--;
            heapify(arr, k, 0);
        }
    }

    private static void heapify(int[] arr, int n, int i) {
        int maxPos = i;
        while (true) {
            if (i * 2 + 1 < n && arr[i * 2 + 1] > arr[maxPos]) {
                maxPos = i * 2 + 1;
            }
            if (i * 2 + 2 < n && arr[i * 2 + 2] > arr[maxPos]) {
                maxPos = i * 2 + 2;
            }
            if (i == maxPos) {
                break;
            }
            int temp = arr[maxPos];
            arr[maxPos] = arr[i];
            arr[i] = temp;
            i = maxPos;
        }
    }

}
