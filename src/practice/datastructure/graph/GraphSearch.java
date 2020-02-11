package practice.datastructure.graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 所要遍历的图如下，找出从1--7的路径
 * 分别使用广度优先遍历和深度优先遍历
 *
 *         0--1--2
 *         |  |  |
 *         3--4--5
 *            |  |
 *            6--7
 *
 */
public class GraphSearch {

    private static boolean mIsFound = false;

    public static void main(String[] args) {
        Graph graph = new Graph(8);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 5);
        graph.addEdge(5, 7);
        graph.addEdge(7 ,6);
        graph.addEdge(6 ,4);
        graph.addEdge(4 ,3);
        graph.addEdge(0 ,3);
        graph.addEdge(1 ,4);
        graph.addEdge(5, 4);

        broadthFirstSearch(graph, 0, 6);
        System.out.println("--------------");
        depthFirstSearch(graph, 0, 6);
    }

    private static void depthFirstSearch(Graph graph, int s, int t) {
        boolean[] visit = new boolean[graph.v];
        int[] prev = new int[graph.v];
        visit[s] = true;
        for (int i = 0; i < graph.v; i++) {
            prev[i] = -1;
        }
        recursionSearch(graph, s, t, prev, visit);
        print(prev, s, t);
    }

    private static void recursionSearch(Graph graph, int w, int t, int[] prev, boolean[] visit) {
        if (mIsFound) {
            return;
        }
        visit[w] = true;
        if (w == t) {
            mIsFound = true;
            return;
        }
        for (int i = 0; i < graph.adj[w].size(); i++) {
            Integer q = graph.adj[w].get(i);
            if (!visit[q]) {
                prev[q] = w;
                recursionSearch(graph, q, t, prev, visit);
            }
        }
    }

    private static void broadthFirstSearch(Graph graph, int s, int t) {
        if (s == t) {
            return;
        }
        // 是否被访问
        boolean[] visit = new boolean[graph.v];
        // s--t访问路径
        int[] prev = new int[graph.v];
        for (int i = 0; i < graph.v; i++) {
            visit[i] = false;
            prev[i] = -1;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);
        visit[s] = true;
        while (!queue.isEmpty()) {
            Integer k = queue.poll();
            for (int i = 0; i < graph.adj[k].size(); i++) {
                Integer node = graph.adj[k].get(i);
                if (!visit[node]) {
                    prev[node] = k;
                    if (node == t) {
                        print(prev, s, t);
                        return;
                    }
                    visit[node] = true;
                    queue.offer(node);
                }
            }
        }
    }

    private static void print(int[] prev, int s, int t) {
        if (prev[t] != -1 && prev[s] != prev[t]) {
            print(prev, s, prev[t]);
        }
        System.out.println(" prev ---> " + t);
    }
}
