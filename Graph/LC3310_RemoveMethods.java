/*
LeetCode 3310 - Remove Methods from project
Approach: Use DFS to traverse the graph starting from the suspicious method k. Mark all reachable methods as suspicious and decrement their in-degrees. After the DFS, check if any suspicious method has a non-zero in-degree, which indicates that it cannot be removed. If any such method exists, return all methods; otherwise, return the list of non-suspicious methods.
Time Complexity: O(V + E) where V is the number of methods (nodes) and E is the number of invocations (edges)
Space Complexity: O(V) for the adjacency list, in-degree array, and suspicious array
*/

import java.util.*;

class LC3310_RemoveMethods {
    public void dfs(int curr, List<List<Integer>> adj, int[] inDegree, boolean[] suspicious) {
        suspicious[curr] = true;
        for (int ngbr : adj.get(curr)) {
            inDegree[ngbr]--;
            if (!suspicious[ngbr]) {
                dfs(ngbr, adj, inDegree, suspicious);
            }
        }
    }

    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        // O(V+E), V = nodes , E = edges
        // graph - adjacency list
        List<List<Integer>> adj = new ArrayList<>(); // u -> {ngbr1, ngbr2} //O(V+E)
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        int[] inDegree = new int[n]; // O(V)
        boolean[] suspicious = new boolean[n]; // O(V)

        for (int[] edge : invocations) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            inDegree[v]++;
        }

        // DFS
        dfs(k, adj, inDegree, suspicious);

        List<Integer> result = new ArrayList<>();
        boolean cannotRemove = false;

        for (int i = 0; i < n; i++) {
            if (suspicious[i] && inDegree[i] > 0) {
                cannotRemove = true;
                break;
            }
            if (!suspicious[i]) {
                result.add(i);
            }
        }

        if (cannotRemove) {
            List<Integer> vec = new ArrayList<>(); // 0, 1, 2,... n-1
            for (int i = 0; i < n; i++) {
                vec.add(i);
            }
            return vec;
        }

        return result;
    }

    public static void main(String[] a) {
        LC3310_RemoveMethods solution = new LC3310_RemoveMethods();
        int n = 5;
        int k = 2;
        int[][] invocations = { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 4 } };
        List<Integer> remaining = solution.remainingMethods(n, k, invocations);
        System.out.println(remaining); // Output: [0]
    }
}
