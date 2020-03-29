package practice.leetcode.easy;

import java.util.Stack;

/**
 * Implement the following operations of a queue using stacks.
 *
 * push(x) -- Push element x to the back of queue.
 * pop() -- Removes the element from in front of queue.
 * peek() -- Get the front element.
 * empty() -- Return whether the queue is empty.
 * Example:
 *
 * MyQueue queue = new MyQueue();
 *
 * queue.push(1);
 * queue.push(2);
 * queue.peek();  // returns 1
 * queue.pop();   // returns 1
 * queue.empty(); // returns false
 * Notes:
 *
 * 1. You must use only standard operations of a stack -- which means only push to top,
 * peek/pop from top, size, and is empty operations are valid.
 * 2. Depending on your language, stack may not be supported natively.
 * You may simulate a stack by using a list or deque (double-ended queue),
 * as long as you use only standard operations of a stack.
 * 3. You may assume that all operations are valid (for example,
 * no pop or peek operations will be called on an empty queue).
 */
public class ImplementQueueUsingStacks {

    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        MyQueue2 q2 = new MyQueue2();
        q.push(1);
        q.push(2);
        q.push(3);
        q2.push(1);
        q2.push(2);
        q2.push(3);
        System.out.println(q.pop());
        System.out.println(q.pop());
        System.out.println(q.pop());
        System.out.println();
        System.out.println("-----------------------");
        System.out.println();
        System.out.println(q2.pop());
        System.out.println(q2.pop());
        System.out.println(q2.pop());
    }

    /**
     * their solution of this problem
     */
    static class MyQueue2 {

        Stack<Integer> input;
        Stack<Integer> output;

        /** Initialize your data structure here. */
        public MyQueue2() {
            input = new Stack<>();
            output = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            input.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            peek();
            return output.pop();
        }

        /** Get the front element. */
        public int peek() {
            if (output.isEmpty()) {
                while (!input.isEmpty()) {
                    output.push(input.pop());
                }
            }
            return output.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return input.isEmpty() && output.isEmpty();
        }
    }

    /**
     * their solution of this problem
     */
    static class MyQueue {

        Stack<Integer> s1;
        Stack<Integer> s2;

        /** Initialize your data structure here. */
        public MyQueue() {
            s1 = new Stack<>();
            s2 = new Stack<>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            int size = s1.size();
            for (int i=0;i<size;i++) {
                s2.push(s1.pop());
            }
            s1.push(x);
            size = s2.size();
            for (int i=0;i<size;i++) {
                s1.push(s2.pop());
            }
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            return s1.pop();
        }

        /** Get the front element. */
        public int peek() {
            return s1.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return s1.isEmpty();
        }
    }

}
