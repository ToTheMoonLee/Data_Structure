package practice.linkedlist;

public class LinkedList {

    private final static int MAX_SIZE = 20;
    private static InnerLinked[] mArray = new InnerLinked[200];

    public static void init() {
        for (int i = 0; i < MAX_SIZE; i++) {
            mArray[i] = new InnerLinked();
            mArray[i].cur = i + 1;
        }
        mArray[MAX_SIZE - 1].cur = 0;
    }

    public static int malloc() {
        int i = mArray[0].cur;
        if (i > 0) {
            mArray[0].cur = mArray[i].cur;
        }
        return i;
    }

    public static void free(int k) {
        mArray[k].cur = mArray[0].cur;
        mArray[0].cur = k;
    }

    private static int r;
    public static void main(String[] args) {
        init();
        int head = malloc(); // 头节点
        r = head; // r指向队尾

        for (int i = 0; i < 10; i++) {
            int malloc = malloc();
            mArray[malloc].data = "a" + i;
            mArray[r].cur = malloc;
            r = malloc;
        }
        mArray[r].cur = 0;

        printArray();
        System.out.println(" \r\n---------------------------\r\n ");

        String data = "a11";
        addData(head, data);
        String data1 = "a9";
        addData(head, data1);
        String data2 = "a1";
        addData(head, data2);
        String data3 = "a18";
        addData(head, data3);
        String data4 = "a2";
        addData(head, data4);

        printArray();
    }

    private static void addData(int head, String data) {
        int p = head, k = mArray[head].cur;
        while (k != mArray[r].cur && !mArray[k].data.equals(data)) {
            p = k;
            k = mArray[k].cur;
        }
        if (k == mArray[r].cur) {
            int i = malloc();
            mArray[i].data = data;
            mArray[i].cur = mArray[r].cur;
            mArray[r].cur = i;
        } else {
            mArray[p].cur = mArray[k].cur;
            free(k);
            if (k == r) {
                r = p;
            }
        }
    }

    public static void printArray() {
        for (int i = 0; i < MAX_SIZE; i++) {
            System.out.println(" mArray " + i + " is -----> " + mArray[i].data + " cur is ---> " + mArray[i].cur);
        }
    }

    static class InnerLinked {
        public String data;
        public int cur;
    }
}
