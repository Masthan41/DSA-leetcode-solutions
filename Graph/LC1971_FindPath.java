/*
LeetCode 1971 - Find if Path Exists in Graph
Approach: Build an adjacency list representation of the graph and perform DFS from source to destination.
Time Complexity: O(V + E)
Space Complexity: O(V + E)
*/

import java.util.*;

class LC1971_FindPath {
    public boolean dfs(ArrayList<Integer> graph[], int curr, int dest, boolean vis[]) {

        if (curr == dest) {
            return true;
        }

        vis[curr] = true;

        for (int i : graph[curr]) {
            if (!vis[i]) {
                if (dfs(graph, i, dest, vis)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {

        if (source == destination) {
            return true;
        }

        ArrayList<Integer> graph[] = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        // build the graph
        for (int edge[] : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        boolean vis[] = new boolean[n];

        return dfs(graph, source, destination, vis);
    }

    public static void main(String[] args) {
        LC1971_FindPath obj = new LC1971_FindPath();
        int n = 3;
        int edges[][] = { { 0, 1 }, { 1, 2 }, { 2, 0 } };
        int source = 0;
        int destination = 2;

        System.out.println(obj.validPath(n, edges, source, destination));
    }
}
