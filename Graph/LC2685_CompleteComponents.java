/*
LeetCode 2685 - Count the Number of Complete Components in a Graph
Approach: Use Disjoint Set Union (DSU) to group nodes into connected components and count the number of edges in each component. A component is complete if it has v nodes and e edges such that e = v * (v - 1) / 2.
Time Complexity: O(n + m) where n is the number of nodes and m is the number of edges
Space Complexity: O(n) for the DSU structure and edge count map
*/

import java.util.*;

class LC2685_CompleteComponents {
    class DSU {
        int[] parent, size;

        DSU(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        int find(int x) {
            if (parent[x] == x)
                return x;
            return parent[x] = find(parent[x]);
        }

        void union(int x, int y) {
            int xRoot = find(x), yRoot = find(y);
            if (xRoot == yRoot)
                return;

            if (size[xRoot] > size[yRoot]) {
                parent[yRoot] = xRoot;
                size[xRoot] += size[yRoot];
            } else {
                parent[xRoot] = yRoot;
                size[yRoot] += size[xRoot];
            }
        }
    }

    public int countCompleteComponents(int n, int[][] edges) {
        DSU dsu = new DSU(n);
        Map<Integer, Integer> edgeCount = new HashMap<>();

        for (int[] edge : edges) {
            dsu.union(edge[0], edge[1]);
        }

        for (int[] edge : edges) {
            int root = dsu.find(edge[0]);
            edgeCount.put(root, edgeCount.getOrDefault(root, 0) + 1);
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            if (dsu.find(i) == i) {
                int v = dsu.size[i];
                int e = edgeCount.getOrDefault(i, 0);

                if ((v * (v - 1)) / 2 == e) {
                    result++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LC2685_CompleteComponents solution = new LC2685_CompleteComponents();
        int n = 6;
        int[][] edges = { { 0, 1 }, { 0, 2 }, { 1, 2 }, { 3, 4 } };
        int result = solution.countCompleteComponents(n, edges);
        System.out.println("Number of complete components: " + result); // Output: 2
    }
}
