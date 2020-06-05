package practice.smallestpath;

public class PriorityQueue {


    public static void main(String[] args) {
        Graph.VerTex v1 = new Graph.VerTex(0,1);
        Graph.VerTex v2 = new Graph.VerTex(1,3);
        Graph.VerTex v3 = new Graph.VerTex(2,7);
        Graph.VerTex v4 = new Graph.VerTex(3,2);
        Graph.VerTex v5 = new Graph.VerTex(4,6);
        PriorityQueue q = new PriorityQueue(100);
        q.add(v1);
        q.add(v2);
        q.add(v3);
        q.add(v4);
        q.add(v5);
        for (int i=1;i<6;i++) {
            System.out.println(q.arr[i].dist);
        }
        System.out.println("--------------");
        for (int i=0;i<5;i++) {
            System.out.println(q.index[i]);
        }
    }

    public Graph.VerTex[] arr;
    public int[] index;
    public int n;
    public int cur = 1;

    public PriorityQueue(int n) {
        this.n = n;
        arr = new Graph.VerTex[n+1];
        index = new int[n];
    }

    public void update(Graph.VerTex v) {
        int temp = arr[index[v.id]].dist;
        arr[index[v.id]].dist = v.dist;
        if (temp > v.dist) {
            heapBottomToTop(v,index[v.id]);
        } else {
            heapToToBottom(index[v.id]);
        }
    }

    public void delete() {
        swap(0,cur-1);
        arr[cur-1] = null;
        cur--;
        heapToToBottom(0);
    }

    public void add(Graph.VerTex v) {
        if (cur == 1) {
            arr[cur] = v;
            index[v.id] = cur;
            cur++;
        } else {
            arr[cur] = v;
            index[v.id] = cur;
            heapBottomToTop(v,cur);
            cur++;
        }
    }

    private void heapToToBottom(int position) {
        int min = position;
        while (true) {
            if (position * 2 < cur && arr[min].dist > arr[position * 2].dist) {
                min = position * 2;
            }
            if (position * 2 + 1 < cur && arr[min].dist > arr[position * 2 + 1].dist) {
                min = position * 2;
            }
            if (min == position) {
                break;
            }
            swap(min,position);
            position = min;
        }
    }

    private void heapBottomToTop(Graph.VerTex v,int position) {
        int temp = position;
        while (temp/2 >=1 && arr[temp/2].dist > v.dist) {
            swap(temp, temp / 2);
            temp = temp/2;
        }
    }

    private void swap(int a, int b) {
        Graph.VerTex vA = arr[a];
        Graph.VerTex vB = arr[b];

        int pA = index[vA.id];
        index[vA.id] = index[vB.id];
        index[vB.id] = pA;

        arr[a] = vB;
        arr[b] = vA;

    }
}
