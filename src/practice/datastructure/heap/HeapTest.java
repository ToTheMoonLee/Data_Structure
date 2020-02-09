package practice.datastructure.heap;

public class HeapTest {

    public static void main(String[] args) {
        Heap heap = new Heap(10);
        heap.put(1);
        heap.put(2);
        heap.put(3);
        heap.put(4);
        heap.put(5);
        heap.put(6);
        heap.put(7);
        heap.put(8);
        heap.put(9);
        boolean result10 = heap.put(10);
        System.out.println(" result 10 is " + result10);
        boolean result11 = heap.put(11);
        System.out.println(" result 11 is " + result11);
        heap.traversal();
        int i = heap.deleteTop();
        System.out.println(" delete is " + i);
        System.out.println(" -------------------- ");
        heap.traversal();
    }
}
