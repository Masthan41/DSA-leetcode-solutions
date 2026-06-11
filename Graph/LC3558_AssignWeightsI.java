
/*
LeetCode 3558 - Number of ways to Assign Weights to Edges I
Approach: Build an adjacency list representation of the graph, find the maximum depth of the tree, and calculate 2^(maxDepth - 1) to get the number of ways to assign weights.
Time Complexity: O(V + E) where V is the number of vertices and E is the number of edges in the graph.
Space Complexity: O(V + E) for the adjacency list and recursion stack.
*/


import java.util.*;

class LC3558_AssignWeightsI {
    static final long MOD = 1_000_000_007L;

    private long power(long base, long exponent) {
        if (exponent == 0)
            return 1;

        long half = power(base, exponent / 2);

        long result = (half * half) % MOD;

        if (exponent % 2 == 1) {
            result = (result * base) % MOD;
        }

        return result;
    }

    private int getMaxDepth(Map<Integer, List<Integer>> adj, int node, int parent) {

        int depth = 0;

        for (int neighbor : adj.getOrDefault(node, new ArrayList<>())) {
            if (neighbor == parent)
                continue;

            depth = Math.max(depth, getMaxDepth(adj, neighbor, node) + 1);
        }

        return depth;
    }

    public int assignEdgeWeights(int[][] edges) {

        Map<Integer, List<Integer>> adj = new HashMap<>();

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(v);
            adj.computeIfAbsent(v, k -> new ArrayList<>()).add(u);
        }

        int maxDepth = getMaxDepth(adj, 1, 0);

        return (int) power(2, maxDepth - 1);
    }

    public static void main(String[] args) {
        LC3558_AssignWeightsI solution = new LC3558_AssignWeightsI();

        int[][] edges1 = { { 1, 2 }, { 1, 3 }, { 2, 4 }, { 2, 5 } };
        System.out.println(solution.assignEdgeWeights(edges1)); // Output: 4

        int[][] edges2 = { { 1, 2 }, { 1, 3 }, { 3, 4 }, { 3, 5 } };
        System.out.println(solution.assignEdgeWeights(edges2)); // Output: 4

        int[][] edges3 = { { 1, 2 }, { 1, 3 }, { 2, 4 }, { 4, 5 } };
        System.out.println(solution.assignEdgeWeights(edges3)); // Output: 8
    }
}
