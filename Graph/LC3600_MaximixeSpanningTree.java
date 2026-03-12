/*
LeetCode 3600 - Maximize Spanning tree Stability with upgrades.
Approach: Use binary search to find the maximum stability. For each mid value, use a DSU to check if we can connect all nodes with edges that have stability >= mid, and if not, try to upgrade some edges with stability >= mid/2 using the available upgrades (k). If we can connect all nodes, then we can try for a higher mid value, otherwise we need to try a lower mid value.
(Binary search + DSU)

Time Complexity: O(E log S) where E is the number of edges and S is the range of stability values (up to 2e5).

Space Complexity: O(N) for the DSU data structure, where N is the number of nodes.
*/

import java.util.*;

class DSU {

    int par[];
    int rank[];

    public DSU(int n) {
        par = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            par[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int x) {
        if (x == par[x]) {
            return x;
        }
        return par[x] = find(par[x]);
    }

    public boolean union(int x, int y) {
        int xParent = find(x);
        int yParent = find(y);

        if (xParent == yParent) {
            return false;
        }

        if (rank[xParent] > rank[yParent]) {
            par[yParent] = xParent;
        } else if (rank[xParent] < rank[yParent]) {
            par[xParent] = yParent;
        } else {
            par[xParent] = yParent;
            rank[yParent]++;
        }

        return true;
    }
}

class LC3600_MaximixeSpanningTree {

    private boolean check(int n, int[][] edges, int k, int mid) {
        DSU dsu = new DSU(n);

        List<int[]> upgradeCandidates = new ArrayList<>();

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int s = edge[2];
            int m = edge[3];

            if (m == 1) {
                if (s < mid) {
                    return false;
                }
                dsu.union(u, v);
            } else {
                if (s >= mid) {
                    dsu.union(u, v);
                } else if (2 * s >= mid) {
                    upgradeCandidates.add(new int[]{u, v});
                }
            }
        }

        for (int[] edge : upgradeCandidates) {
            int u = edge[0];
            int v = edge[1];

            if (dsu.find(u) != dsu.find(v)) {
                if (k <= 0) {
                    return false;
                }
                dsu.union(u, v);
                k--;
            }
        }

        int root = dsu.find(0);

        for (int node = 1; node < n; node++) {
            if (dsu.find(node) != root) {
                return false;
            }
        }

        return true;
    }

    public int maxStability(int n, int[][] edges, int k) {

        DSU dsu = new DSU(n);

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int m = edge[3];

            if (m == 1) {
                if (dsu.find(u) == dsu.find(v)) {
                    return -1;
                }
                dsu.union(u, v);
            }
        }

        int result = -1;
        int l = 1;
        int r = (int) 2e5;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (check(n, edges, k, mid)) {
                result = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LC3600_MaximixeSpanningTree solution = new LC3600_MaximixeSpanningTree();

        int n = 3;
        int[][] edges = {{0, 1, 2, 1}, {1, 2, 3, 0}};
        int k = 1;

        int result = solution.maxStability(n, edges, k);
        System.out.println(result); // Output: 2
    }
}
