/*
LeetCode 2492 - Minimum Score of a Path Between Two Cities
Approach: Depth-First Search (DFS) to find the minimum edge weight in the connected component containing city 1
Time Complexity: O(n + m) where n is the number of cities and m is the number of roads
Space Complexity: O(n + m) for the adjacency list and visited array
*/

import java.util.*;

class LC2492_MinScore {
    private void dfs(Map<Integer, List<int[]>> adj, int u, boolean[] visited, int[] result) {
        visited[u] = true;

        for (int[] edge : adj.getOrDefault(u, new ArrayList<>())) {
            int v = edge[0];
            int cost = edge[1];

            result[0] = Math.min(result[0], cost);

            if (!visited[v]) {
                dfs(adj, v, visited, result);
            }
        }

    }

    public int minScore(int n, int[][] roads) {
        Map<Integer, List<int[]>> adj = new HashMap<>();

        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int cost = road[2];

            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(new int[] { v, cost });
            adj.computeIfAbsent(v, k -> new ArrayList<>()).add(new int[] { u, cost });
        }

        boolean[] visited = new boolean[n + 1];
        int[] result = { Integer.MAX_VALUE };

        dfs(adj, 1, visited, result);

        return result[0];
    }

    public static void main(String[] args) {
        LC2492_MinScore obj = new LC2492_MinScore();
        int n = 4;
        int[][] roads = { { 1, 2, 9 }, { 2, 3, 6 }, { 2, 4, 5 }, { 1, 4, 7 } };
        int res = obj.minScore(n, roads);
        System.out.println(res);
    }
}
