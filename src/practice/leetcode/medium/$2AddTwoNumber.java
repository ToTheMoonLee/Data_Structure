package practice.leetcode.medium;

import practice.datastructure.tree.binarytree.TreeNode;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * <p>
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * <p>
 * Add the two numbers and return it as a linked list.
 * <p>
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * <p>
 * Example:
 * <p>
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class $2AddTwoNumber {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

//        ListNode result = new Solution().addTwoNumbers(l1, l2);
        ListNode result = new Solution().addTwoNumbers2(l1, l2);

        StringBuilder stringBuilder = new StringBuilder();
        while (result != null) {
            if (result.next == null) {
                stringBuilder.append(result.val);
            } else {
                stringBuilder.append(result.val).append(" -> ");
            }
            result = result.next;
        }
        System.out.println(stringBuilder);
    }

    static class Solution {

        /**
         * the amazing version of others
         * <a href="https://leetcode.com/problems/add-two-numbers/discuss/1010/Is-this-Algorithm-optimal-or-what">
         * @param l1
         * @param l2
         * @return
         */
        ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
            ListNode c1 = l1;
            ListNode c2 = l2;
            ListNode sentinel = new ListNode(0);
            ListNode d = sentinel;
            int sum = 0;
            while (c1 != null || c2 != null) {
                sum /= 10;
                if (c1 != null) {
                    sum += c1.val;
                    c1 = c1.next;
                }
                if (c2 != null) {
                    sum += c2.val;
                    c2 = c2.next;
                }
                d.next = new ListNode(sum % 10);
                d = d.next;
            }
            if (sum / 10 == 1) {
                d.next = new ListNode(1);
            }
            return sentinel.next;
        }

        /**
         * my first correct solution when I failed 7 times
         *
         * @param l1
         * @param l2
         * @return
         */
        ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode curL1 = l1;
            ListNode curL2 = l2;
            int add = 0;
            while (curL1 != null && curL2 != null) {
                int result = 0;
                int total = curL1.val + curL2.val + add;
                if (total >= 10) {
                    result = total % 10;
                    add = 1;
                } else {
                    result = total;
                    add = 0;
                }
                curL1.val = result;
                if (curL2.next != null && curL1.next == null) {
                    curL2.next.val += add;
                    curL1.next = curL2.next;
                    break;
                }
                if (curL1.next != null && curL2.next == null) {
                    curL1.next.val += add;
                    break;
                }
                if (curL1.next == null && curL2.next == null && add == 1) {
                    curL1.next = new ListNode(1);
                    break;
                }
                curL1 = curL1.next;
                curL2 = curL2.next;
            }
            if (curL1 != null && curL1.next != null) {
                curL1 = curL1.next;
            }
            while (curL1 != null) {
                if (curL1.val >= 10) {
                    curL1.val = curL1.val % 10;
                    if (curL1.next == null) {
                        curL1.next = new ListNode(1);
                        curL1 = curL1.next;
                    } else {
                        curL1 = curL1.next;
                        curL1.val += 1;
                    }

                } else {
                    break;
                }
            }
            return l1;
        }
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
