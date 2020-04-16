package practice.leetcode.easy;

/**
 * Design a HashSet without using any built-in hash table libraries.
 *
 * To be specific, your design should include these functions:
 *
 * add(value): Insert a value into the HashSet.
 * contains(value) : Return whether the value exists in the HashSet or not.
 * remove(value): Remove a value in the HashSet. If the value does not exist in the HashSet, do nothing.
 *
 * Example:
 *
 * MyHashSet hashSet = new MyHashSet();
 * hashSet.add(1);
 * hashSet.add(2);
 * hashSet.contains(1);    // returns true
 * hashSet.contains(3);    // returns false (not found)
 * hashSet.add(2);
 * hashSet.contains(2);    // returns true
 * hashSet.remove(2);
 * hashSet.contains(2);    // returns false (already removed)
 *
 * Note:
 *
 * All values will be in the range of [0, 1000000].
 * The number of operations will be in the range of [1, 10000].
 * Please do not use the built-in HashSet library.
 */
public class $705DesignHashSet {

    public static void main(String[] args) {
        MyHashSet hashSet = new MyHashSet();
        hashSet.add(1);
        hashSet.add(2);

        System.out.println(hashSet.contains(1));
        System.out.println(hashSet.contains(3));

        System.out.println("---------------------");

        MyHashSet2 hashSet2 = new MyHashSet2();
        hashSet2.add(1);
        hashSet2.add(2);

        System.out.println(hashSet2.contains(1));
        System.out.println(hashSet2.contains(3));

        System.out.println("---------------------");

        MyHashSet3 hashSet3 = new MyHashSet3();
        hashSet3.add(1);
        hashSet3.add(2);

        System.out.println(hashSet3.contains(1));
        System.out.println(hashSet3.contains(3));

    }

    /**
     * their reasonable solution of this problem
     */
    static class MyHashSet3 {

        private int buckets = 1000;
        private int itemsPerBucket = 1001;
        private boolean[][] table;

        /** Initialize your data structure here. */
        public MyHashSet3() {
            table = new boolean[buckets][];
        }

        public int hash(int key) {
            return key % buckets;
        }

        public int pos(int key) {
            return key / buckets;
        }

        public void add(int key) {
            int hashkey = hash(key);

            if (table[hashkey] == null) {
                table[hashkey] = new boolean[itemsPerBucket];
            }
            table[hashkey][pos(key)] = true;
        }

        public void remove(int key) {
            int hashkey = hash(key);

            if (table[hashkey] != null)
                table[hashkey][pos(key)] = false;
        }

        /** Returns true if this set did not already contain the specified element */
        public boolean contains(int key) {
            int hashkey = hash(key);
            return table[hashkey] != null && table[hashkey][pos(key)];
        }
    }

    /**
     * my second solution of this problem
     */
    static class MyHashSet2 {

        boolean[] b = new boolean[1000001];
        /** Initialize your data structure here. */
        public MyHashSet2() {

        }

        public void add(int key) {
            b[key] = true;
        }

        public void remove(int key) {
            b[key] = false;
        }

        /** Returns true if this set contains the specified element */
        public boolean contains(int key) {
            return b[key];
        }
    }


    /**
     * my first solution of this problem
     */
    static class MyHashSet {

        Integer[] ints = new Integer[1000001];
        /** Initialize your data structure here. */
        public MyHashSet() {

        }

        public void add(int key) {
            ints[key] = key;
        }

        public void remove(int key) {
            ints[key] = null;
        }

        /** Returns true if this set contains the specified element */
        public boolean contains(int key) {
            return ints[key] !=null;
        }
    }
}
