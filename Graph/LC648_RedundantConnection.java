/*
LeetCode 648 - Redundant Connection
Approach: Use Union-Find (Disjoint Set Union) to detect the redundant edge in a graph that forms a cycle.
Time Complexity: O(n * α(n)) where α is the inverse Ackermann function
Space Complexity: O(n)
*/

import java.util.*;

class LC648_RedundantConnection {
    int parent[];

    public int find(int x) {
        if (parent[x] == x)
            return x;

        return parent[x] = find(parent[x]);
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }

        for (int e[] : edges) {
            int u = e[0];
            int v = e[1];

            int pu = find(u);
            int pv = find(v);

            if (pu == pv)
                return e;

            parent[pu] = pv;
        }
        return new int[0];
    }

    public static void main(String[] args) {
        LC648_RedundantConnection obj = new LC648_RedundantConnection();
        int edges[][] = { { 1, 2 }, { 1, 3 }, { 2, 3 } };

        int ans[] = obj.findRedundantConnection(edges);

        System.out.println(Arrays.toString(ans));
    }
}
