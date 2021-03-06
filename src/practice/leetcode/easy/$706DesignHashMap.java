package practice.leetcode.easy;

/**
 * Design a HashMap without using any built-in hash table libraries.
 * <p>
 * To be specific, your design should include these functions:
 * <p>
 * put(key, value) : Insert a (key, value) pair into the HashMap.
 * If the value already exists in the HashMap, update the value.
 * get(key): Returns the value to which the specified key is mapped,
 * or -1 if this map contains no mapping for the key.
 * remove(key) : Remove the mapping for the value key if this map contains the mapping for the key.
 * <p>
 * Example:
 * <p>
 * MyHashMap hashMap = new MyHashMap();
 * hashMap.put(1, 1);
 * hashMap.put(2, 2);
 * hashMap.get(1);            // returns 1
 * hashMap.get(3);            // returns -1 (not found)
 * hashMap.put(2, 1);          // update the existing value
 * hashMap.get(2);            // returns 1
 * hashMap.remove(2);          // remove the mapping for 2
 * hashMap.get(2);            // returns -1 (not found)
 * <p>
 * Note:
 * <p>
 * All keys and values will be in the range of [0, 1000000].
 * The number of operations will be in the range of [1, 10000].
 * Please do not use the built-in HashMap library.
 */
public class $706DesignHashMap {

    public static void main(String[] args) {
        MyHashMap hashMap = new MyHashMap();
        hashMap.put(1, 1);
        hashMap.put(2, 2);
        System.out.println(hashMap.get(1));          // returns 1
        System.out.println(hashMap.get(3));         // returns -1 (not found)

        MyHashMap2 hashMap2 = new MyHashMap2();
        hashMap2.put(1, 1);
        hashMap2.put(2, 2);
        System.out.println(hashMap2.get(1));          // returns 1
        System.out.println(hashMap2.get(3));         // returns -1 (not found)
    }

    /**
     * their faster solution of this problem
     */
    static class MyHashMap2 {

        final ListNode[] nodes = new ListNode[10000];

        public void put(int key, int value) {
            int i = idx(key);
            if (nodes[i] == null)
                nodes[i] = new ListNode(-1, -1);
            ListNode prev = find(nodes[i], key);
            if (prev.next == null)
                prev.next = new ListNode(key, value);
            else prev.next.val = value;
        }

        public int get(int key) {
            int i = idx(key);
            if (nodes[i] == null)
                return -1;
            ListNode node = find(nodes[i], key);
            return node.next == null ? -1 : node.next.val;
        }

        public void remove(int key) {
            int i = idx(key);
            if (nodes[i] == null) return;
            ListNode prev = find(nodes[i], key);
            if (prev.next == null) return;
            prev.next = prev.next.next;
        }

        int idx(int key) {
            return Integer.hashCode(key) % nodes.length;
        }

        ListNode find(ListNode bucket, int key) {
            ListNode node = bucket, prev = null;
            while (node != null && node.key != key) {
                prev = node;
                node = node.next;
            }
            return prev;
        }

        class ListNode {
            int key, val;
            ListNode next;

            ListNode(int key, int val) {
                this.key = key;
                this.val = val;
            }
        }
    }

    /**
     * my mimic solution of this problem
     */
    static class MyHashMap {

        private int buckets = 1000;
        private int itemsPerBucket = 1001;
        private Integer[][] table;

        /**
         * Initialize your data structure here.
         */
        public MyHashMap() {
            table = new Integer[buckets][];
        }

        private int hash(int key) {
            return key % buckets;
        }

        private int pos(int key) {
            return key / buckets;
        }

        /**
         * value will always be non-negative.
         */
        public void put(int key, int value) {
            int hash = hash(key);
            if (table[hash] == null) {
                table[hash] = new Integer[itemsPerBucket];
            }
            table[hash][pos(key)] = value;
        }

        /**
         * Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key
         */
        public int get(int key) {
            int hash = hash(key);
            if (table[hash] != null && table[hash][pos(key)] != null) {
                return table[hash][pos(key)];
            }
            return -1;
        }

        /**
         * Removes the mapping of the specified value key if this map contains a mapping for the key
         */
        public void remove(int key) {
            int hash = hash(key);
            if (table[hash] != null && table[hash][pos(key)] != null) {
                table[hash][pos(key)] = null;
            }
        }
    }
}
