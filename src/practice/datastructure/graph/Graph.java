package practice.datastructure.graph;


import java.util.LinkedList;

/**
 * 使用邻接表的方式存储
 */
public class Graph {

    /**
     * 顶点个数
     */
    public int v;
    /**
     * 每个顶点所链接的边
     */
    public LinkedList<Integer>[] adj;

    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int t) {
        adj[s].add(t);
        adj[t].add(s);
    }

}
