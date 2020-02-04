package practice.datastructure.sort;

public class CountingSort extends BaseSort {

    public static void main(String[] args) {
        int[] testArr = new int[]{5, 3, 2, 4, 4, 3, 2, 1, 5, 4, 2, 3, 5, 2, 3, 4, 2, 0, 2, 1};
        sort(testArr);
        printArr(testArr);
    }

    private static void sort(int[] a) {
        if (a.length <= 1) {
            return;
        }
        // 1. find the max data
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) {
                max = a[i];
            }
        }
        // count the data
        int[] r = new int[max + 1];
        for (int aData : a) {
            r[aData]++;
        }
        // add the data
        for (int i = 1; i < r.length; i++) {
            r[i] = r[i] + r[i - 1];
        }
        // traversal the a[]
        int[] tempArr = new int[a.length];
        for (int aData : a) {
            tempArr[--r[aData]] = aData;
        }
        System.arraycopy(tempArr, 0, a, 0, a.length);
    }
}
