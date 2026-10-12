/*
LeetCode 1337 - K Weakest Rows in a Matrix
Approach: Use a min-heap to keep track of the k weakest rows.
Time Complexity: O(n * m + n * log k) where n is the number of rows and m is the number of columns.
Space Complexity: O(k) as we are storing at most k elements in the heap.
*/

import java.util.PriorityQueue;

class LC1337_KWeakestRows {
    public int[] kWeakestRows(int[][] mat, int k) {
        int n = mat.length;
        int m = mat[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> {
                    if (a[0] != b[0]) {
                        return Integer.compare(b[0], a[0]);
                    }
                    return Integer.compare(b[1], a[1]);
                });

        for (int i = 0; i < n; i++) {
            int c = 0;
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 1) {
                    c++;
                }
            }
            pq.add(new int[] { c, i });
            if (pq.size() > k) {
                pq.remove();
            }
        }

        int ans[] = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            int curr[] = pq.remove();
            ans[i] = curr[1];
        }
        return ans;
    }

    public static void main(String[] args) {
        LC1337_KWeakestRows sol = new LC1337_KWeakestRows();

        int[][] mat1 = {
                { 1, 1, 0, 0, 0 },
                { 1, 1, 1, 1, 0 },
                { 1, 0, 0, 0, 0 },
                { 1, 1, 0, 0, 0 },
                { 1, 1, 1, 1, 1 }
        };
        int k1 = 3;
        int[] result1 = sol.kWeakestRows(mat1, k1);
        System.out.print("Test Case 1: ");
        for (int num : result1) {
            System.out.print(num + " ");
        }
        System.out.println(); // Expected: [2, 0, 3]

        int[][] mat2 = {
                { 1, 0 },
                { 0, 0 },
                { 1, 0 }
        };
        int k2 = 2;
        int[] result2 = sol.kWeakestRows(mat2, k2);
        System.out.print("Test Case 2: ");
        for (int num : result2) {
            System.out.print(num + " ");
        }
        System.out.println(); // Expected: [1, 0]
    }
}
