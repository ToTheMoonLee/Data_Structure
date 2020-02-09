package practice.datastructure.heap;

public class Heap {

    public int[] arr;
    public int count; // 当前容器中存入的个数
    public int n;     // 最大存入数量

    public Heap(int capacity) {
        arr = new int[capacity + 1]; // 从1开始存
        count = 0;
        n = capacity;
    }

    public void traversal() {
        for (int i = 1; i <= count; i++) {
            System.out.println(" arr[" + i + "] is " + arr[i]);
        }
    }

    public boolean put(int data) {
        if (count >= n) {
            return false;
        }
        arr[++count] = data;
        int i = count;
        while (i / 2 > 0 && arr[i] > arr[i / 2]) {
            int temp = arr[i];
            arr[i] = arr[i / 2];
            arr[i / 2] = temp;
            i = i / 2;
        }
        return true;
    }

    public int deleteTop() {
        if (count < 1) {
            return -1;
        }
        int result = arr[1];
        arr[1] = arr[count--];
        heapify(arr, count, 1);
        return result;
    }

    public void heapify(int[] arr, int n, int i) {
        int maxPos = i;
        while (true) {
            if (2 * i <= n && arr[maxPos] < arr[2 * i]) {
                maxPos = 2 * i;
            }
            if (2 * i + 1 <= n && arr[maxPos] < arr[2 * i + 1]) {
                maxPos = 2 * i + 1;
            }
            if (maxPos == i) {
                break;
            }
            int temp = arr[i];
            arr[i] = arr[maxPos];
            arr[maxPos] = temp;
            i = maxPos;
        }
    }
}
