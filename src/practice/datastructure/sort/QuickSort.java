package practice.datastructure.sort;

public class QuickSort extends BaseSort{

    public static void main(String[] args) {
        quickSort(arr, 0, arr.length - 1);
        printArr(arr);
    }

    private static void quickSort(int[] a, int start, int end) {
        if (start >= end) {
            return;
        }

        int pivot = a[end];
        int i = start;
        int j = start;
        while (j < end) {
            if (a[j] < pivot) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
            }
            j++;
        }
        a[end] = a[i];
        a[i] = pivot;

        quickSort(a, start, i - 1);
        quickSort(a, i + 1, end);
    }
}
