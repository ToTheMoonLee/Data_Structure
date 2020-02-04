package practice.datastructure.queue;

public class QueuePractice {

    public static void main(String[] args) {
        CycleArrayQueue cycleArrayQueue = new CycleArrayQueue(3);
        cycleArrayQueue.enqueue("a");
        cycleArrayQueue.enqueue("b");
        cycleArrayQueue.enqueue("c");
        cycleArrayQueue.enqueue("d");
        System.out.println(" --------- " + cycleArrayQueue.dequeue());
        System.out.println(" --------- " + cycleArrayQueue.dequeue());
        System.out.println(" --------- " + cycleArrayQueue.dequeue());
        System.out.println(" --------- " + cycleArrayQueue.dequeue());
        System.out.println(" --------- " + cycleArrayQueue.dequeue());
    }

}

class CycleArrayQueue {

    String[] items;
    int count;
    int size;
    int head;
    int tail;

    public CycleArrayQueue(int n) {
        items = new String[n];
        count = 0;
        size = n;
        head = tail = 0;
    }

    public boolean enqueue(String data) {
        if ((tail + 1) % size == head) {
            return false;
        }
        items[tail] = data;
        tail = (tail + 1) % size;
        count++;
        return true;
    }

    public String dequeue() {
        if (tail == head) {
            return null;
        }
        String temp = items[head];
        head = (head + 1) % size;
        count--;
        return temp;
    }
}
