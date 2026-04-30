/*
LeetCode 3742 - Maximum Path Score with Limited Negative Cells
Approach: Dynamic Programming
Use a 3D DP array where dp[i][j][c] represents the maximum score


Time complexity: O(m * n * k) where m and n are the dimensions of the grid and k is the maximum allowed negative cells. We fill the DP table for each cell and each cost up to k.

Space complexity: O(m * n * k) for the DP table. However, we can optimize this to O(n * k) by only keeping the current and next row in memory since we only need the next row's values to compute the current row.
*/

class LC3742_MaxPath {
    public int maxPathScore(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int[][][] dp = new int[m + 1][n + 1][k + 1];

        // initialize with -1 (invalid state)
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                for (int c = 0; c <= k; c++) {
                    dp[i][j][c] = -1;
                }
            }
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                for (int cost = k; cost >= 0; cost--) {

                    int newCost = cost + (grid[i][j] > 0 ? 1 : 0);

                    if (newCost > k)
                        continue;

                    // base case
                    if (i == m - 1 && j == n - 1) {
                        dp[i][j][cost] = grid[i][j];
                        continue;
                    }

                    int down = -1, right = -1;

                    if (i + 1 < m)
                        down = dp[i + 1][j][newCost];

                    if (j + 1 < n)
                        right = dp[i][j + 1][newCost];

                    int bestNext = Math.max(down, right);

                    if (bestNext != -1) {
                        dp[i][j][cost] = grid[i][j] + bestNext;
                    }
                }
            }
        }

        return dp[0][0][0];
    }

    public static void main(String[] args) {
        LC3742_MaxPath sol = new LC3742_MaxPath();
        int[][] grid = { { 1, -1, 0 }, { 0, 1, -1 }, { -1, 0, 1 } };
        int k = 2;
        System.out.println(sol.maxPathScore(grid, k)); // Output: 3
    }
}