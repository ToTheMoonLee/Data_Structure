package practice.datastructure.sort;

public class MergeSort extends BaseSort {

    public static void main(String[] args) {
        mergeSort(arr,0,arr.length-1);
        printArr(arr);
    }

    private static void mergeSort(int[] a, int start, int end) {
        if (start >= end) {
            return;
        }
        int middle = (start + end) / 2;
        mergeSort(a, start, middle);
        mergeSort(a, middle + 1, end);
        merge(a, start, middle, end);
    }

    private static void merge(int[] a, int start, int middle, int end) {
        int[] temp = new int[a.length];
        int i = start;
        int j = middle + 1;
        int k = 0;
        while (i <= middle && j <= end) {
            if (a[i] <= a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }

        while (i <= middle) {
            temp[k++] = a[i++];
        }
        while (j <= end) {
            temp[k++] = a[j++];
        }

        for (int index = 0; index < k; index++) {
            a[start + index] = temp[index];
        }
    }

}
