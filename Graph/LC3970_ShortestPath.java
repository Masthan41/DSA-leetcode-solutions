/*
LeetCode 3970 - Shortest Path with atmost K Identical Consecutive Characters
Approach: We can use Dijkstra's algorithm to find the shortest path from node 0 to node n-1. We will maintain a priority queue (min-heap) to explore the nodes with the minimum distance first. For each node, we will keep track of the number of consecutive identical characters encountered so far. If the count exceeds k, we will not explore that path further. We will also maintain a 2D array to store the minimum distance to reach each node with a specific count of consecutive identical characters.

Time Complexity: O(E log V) where E is the number of edges and V is the number of vertices, as we are using a priority queue to explore the nodes.
Space Complexity: O(V * K) for the 2D array that stores the minimum distance to reach each node with a specific count of consecutive identical characters.
*/

import java.util.*;

class LC3970_ShortestPath {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            adj.computeIfAbsent(u, x -> new ArrayList<>()).add(new int[] { v, wt });
        }

        // result[node][count] = min cost to reach node with 'count' consecutive
        // identical chars
        int[][] result = new int[n][k + 1];
        for (int[] row : result) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        // heap holds {dist, node, count}, ordered by dist
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        result[0][1] = 0;
        pq.offer(new int[] { 0, 0, 1 });

        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int d = top[0];
            int node = top[1];
            int count = top[2];

            if (d > result[node][count])
                continue;

            if (node == n - 1)
                return d;

            if (!adj.containsKey(node))
                continue;

            for (int[] vec : adj.get(node)) {
                int adjNode = vec[0];
                int wt = vec[1];

                int newCount = (labels.charAt(adjNode) == labels.charAt(node)) ? count + 1 : 1;

                if (newCount > k)
                    continue;

                int newDist = d + wt;
                if (newDist < result[adjNode][newCount]) {
                    result[adjNode][newCount] = newDist;
                    pq.offer(new int[] { newDist, adjNode, newCount });
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LC3970_ShortestPath solution = new LC3970_ShortestPath();
        int n = 5;
        int[][] edges = { { 0, 1, 2 }, { 1, 2, 3 }, { 2, 3, 4 }, { 3, 4, 5 } };
        String labels = "ababa";
        int k = 2;
        int result = solution.shortestPath(n, edges, labels, k);
        System.out.println("Shortest path cost: " + result);
    }
}