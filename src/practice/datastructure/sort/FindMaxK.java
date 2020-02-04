package practice.datastructure.sort;

public class FindMaxK extends BaseSort {

    public static void main(String[] args) {
        System.out.println(" find k is " + findK(arr, 0, arr.length-1, 5));
    }

    private static int findK(int[] a, int start, int end, int k) {
        int pivot = a[end];
        int i = start;
        int j = start;
        while (j < end) {
            if (a[j] >= pivot) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
            }
            j++;
        }
        a[end] = a[i];
        a[i] = pivot;

        if ((i + 1) == k) {
            return a[i];
        } else if (k < (i + 1)) {
            return findK(a, start, i, k);
        } else {
            return findK(a, i + 1, end, k);
        }

    }
}
