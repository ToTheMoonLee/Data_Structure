package practice.smallestpath;

import java.util.LinkedList;

public class Graph {

    public int n;
    public LinkedList<Edge>[] adj;

    public Graph(int n) {
        adj = new LinkedList[n];
        this.n = n;
        for (LinkedList<Edge> list : adj) {
            list = new LinkedList<>();
        }
    }

    /**
     * start-->end
     */
    public class Edge {
        public VerTex start;
        public VerTex end;
        public int dist;
    }

    public static class VerTex {
        public int id;
        public int dist;
        public VerTex(int id,int dist) {
            this.id = id;
            this.dist = dist;
        }
    }
}
