package practice.leetcode.medium;

import practice.datastructure.util.PrintUtil;

import java.util.*;

/**
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 *
 * Some courses may have prerequisites,
 * for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 *
 * Given the total number of courses and a list of prerequisite pairs,
 * return the ordering of courses you should take to finish all courses.
 *
 * There may be multiple correct orders, you just need to return one of them.
 * If it is impossible to finish all courses, return an empty array.
 *
 * Example 1:
 *
 * Input: 2, [[1,0]]
 * Output: [0,1]
 * Explanation: There are a total of 2 courses to take. To take course 1 you should have finished
 *              course 0. So the correct course order is [0,1] .
 * Example 2:
 *
 * Input: 4, [[1,0],[2,0],[3,1],[3,2]]
 * Output: [0,1,2,3] or [0,2,1,3]
 * Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both
 *              courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
 *              So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .
 * Note:
 *
 * The input prerequisites is a graph represented by a list of edges, not adjacency matrices.
 * Read more about how a graph is represented.
 * You may assume that there are no duplicate edges in the input prerequisites.
 */
public class $210CourseSchedule2 {

    public static void main(String[] args) {
        PrintUtil.printArr(findOrder(2,new int[0][0]));
        PrintUtil.printArr(findOrder2(2,new int[0][0]));
    }

    /**
     * my first solution of this problem
     * @param numCourses
     * @param prerequisites
     * @return
     */
    static int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] degrees = new int[numCourses];
        LinkedList[] adj = new LinkedList[numCourses];
        int[] ans = new int[numCourses];
        for (int i=0;i<adj.length;i++) {
            adj[i] = new LinkedList();
        }
        for (int i=0;i<prerequisites.length;i++) {
            adj[prerequisites[i][1]].add(prerequisites[i][0]);
            degrees[prerequisites[i][0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i=0;i<degrees.length;i++) {
            if (degrees[i]==0) {
                q.offer(i);
            }
        }
        int k = 0;
        while (!q.isEmpty()) {
            int temp = q.poll();
            ans[k++] = temp;
            for (Object o : adj[temp]) {
                int i = (int)o;
                degrees[i]--;
                if (degrees[i] == 0) {
                    q.offer(i);
                }
            }
        }
        return k!= ans.length? new int[0] : ans;
    }

    /**
     * their dfs solution of this problem
     */
    static int WHITE = 1;
    static int GRAY = 2;
    static int BLACK = 3;

    static boolean isPossible;
    static Map<Integer, Integer> color;
    static Map<Integer, List<Integer>> adjList;
    static List<Integer> topologicalOrder;

    static void init(int numCourses) {
        isPossible = true;
        color = new HashMap<Integer, Integer>();
        adjList = new HashMap<Integer, List<Integer>>();
        topologicalOrder = new ArrayList<Integer>();

        // By default all vertces are WHITE
        for (int i = 0; i < numCourses; i++) {
            color.put(i, WHITE);
        }
    }

    static void dfs(int node) {

        // Don't recurse further if we found a cycle already
        if (!isPossible) {
            return;
        }

        // Start the recursion
        color.put(node, GRAY);

        // Traverse on neighboring vertices
        for (Integer neighbor : adjList.getOrDefault(node, new ArrayList<Integer>())) {
            if (color.get(neighbor) == WHITE) {
                dfs(neighbor);
            } else if (color.get(neighbor) == GRAY) {
                // An edge to a GRAY vertex represents a cycle
                isPossible = false;
            }
        }

        // Recursion ends. We mark it as black
        color.put(node, BLACK);
        topologicalOrder.add(node);
    }

    static int[] findOrder2(int numCourses, int[][] prerequisites) {

        init(numCourses);

        // Create the adjacency list representation of the graph
        for (int i = 0; i < prerequisites.length; i++) {
            int dest = prerequisites[i][0];
            int src = prerequisites[i][1];
            List<Integer> lst = adjList.getOrDefault(src, new ArrayList<Integer>());
            lst.add(dest);
            adjList.put(src, lst);
        }

        // If the node is unprocessed, then call dfs on it.
        for (int i = 0; i < numCourses; i++) {
            if (color.get(i) == WHITE) {
                dfs(i);
            }
        }

        int[] order;
        if (isPossible) {
            order = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                order[i] = topologicalOrder.get(numCourses - i - 1);
            }
        } else {
            order = new int[0];
        }

        return order;
    }
}
