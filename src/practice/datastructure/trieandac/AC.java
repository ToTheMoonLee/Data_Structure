package practice.datastructure.trieandac;

import java.util.LinkedList;
import java.util.Queue;

public class AC {

    public static void main(String[] args) {
        insert("abcd");
        insert("bcd");
        insert("cd");
        insert("c");
        insert("cefa");
        buildFailurePointer();

        match("abcdcefa".toCharArray());
    }

    static ACTrieNode root = new ACTrieNode('/');

    public static void match(char[] text) {
        ACTrieNode p = root;
        for (int i = 0; i < text.length; i++) {
            int idx = text[i] - 'a';
            while (p.children[idx] == null && p != root) {
                p = p.fail;
            }
            p = p.children[idx];
            if (p == null) {
                p = root;
            }
            ACTrieNode temp = p;
            while (temp != null) {
                if (temp.isEndingChar) {
                    int index = i - temp.length + 1;
                    System.out.println(" index is " + index);
                }
                temp = temp.fail;
            }
        }
    }

    /**
     * 构造AC自动机
     */
    public static void buildFailurePointer() {
        Queue<ACTrieNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            ACTrieNode p = queue.remove();
            for (int i = 0; i < 26; i++) {
                ACTrieNode pc = p.children[i];
                if (pc == null) {
                    continue;
                }
                if (p == root) {
                    pc.fail = root;
                } else {
                    ACTrieNode q = p.fail;
                    while (q != null) {
                        ACTrieNode qc = q.children[pc.data - 'a'];
                        if (qc != null) {
                            pc.fail = qc;
                            break;
                        }
                        q = q.fail;
                    }
                    if (q == null) {
                        pc.fail = root;
                    }
                }
                queue.add(pc);
            }
        }
    }

    public static void insert(String text) {
        ACTrieNode p = root;
        for (int i = 0; i < text.length(); i++) {
            char data = text.charAt(i);
            if (p.children[data - 'a'] == null) {
                ACTrieNode child = new ACTrieNode(data);
                p.children[data - 'a'] = child;
            }
            p = p.children[data - 'a'];
        }
        p.isEndingChar = true;
        p.length = text.length();
    }

    static class ACTrieNode {
        public char data;
        public ACTrieNode[] children = new ACTrieNode[26];
        public boolean isEndingChar = false;
        public int length = -1;
        public ACTrieNode fail; // 失败指针

        public ACTrieNode(char data) {
            this.data = data;
        }
    }
}
