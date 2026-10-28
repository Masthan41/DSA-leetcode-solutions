/*
LeetCode 3882 - Minimum XOR Path in a Grid
Approach: Dynamic Programming (Using BitSet to track reachable XOR values at each cell in the grid.) in bitset, we can store all possible XOR values that can be achieved at each cell. The final answer will be the minimum XOR value in the bottom-right cell's BitSet.

Time complexity: O(m*n*1024) where m is the number of rows and n is the number of columns in the grid. The 1024 comes from the maximum possible XOR value (since grid values are between 0 and 1023).
                => O(m*n) for the DP part, since 1024 is a constant.

Space complexity: O(m*n*1024) for the BitSet storage at each cell. However, since 1024 is a constant, we can consider it as O(m*n) for practical purposes.
*/

import java.util.BitSet;

class LC3882_MinXORPath {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        BitSet[][] dp = new BitSet[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = new BitSet(1024);
            }
        }

        dp[0][0].set(grid[0][0]);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0)
                    continue;

                BitSet up = new BitSet(1024); // [i-1][j]
                BitSet left = new BitSet(1024); // [i][j-1]

                if (i > 0) {
                    up = (BitSet) dp[i - 1][j].clone();
                }
                if (j > 0) {
                    left = (BitSet) dp[i][j - 1].clone();
                }

                BitSet combined = (BitSet) up.clone();
                combined.or(left); // OR operation

                for (int xorVal = 0; xorVal < 1024; xorVal++) {
                    if (combined.get(xorVal)) {
                        int resultXorVal = xorVal ^ grid[i][j];
                        dp[i][j].set(resultXorVal);
                    }
                }
            }
        }

        // Find the minimum XOR value in the bottom-right cell's BitSet
        for (int xorVal = 0; xorVal < 1024; xorVal++) {
            if (dp[m - 1][n - 1].get(xorVal)) {
                return xorVal;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LC3882_MinXORPath sol = new LC3882_MinXORPath();

        // Test 1: Single cell
        System.out.println(sol.minCost(new int[][] { { 5 } }));
        // Expected: 5

        // Test 2: Two cells in a row
        System.out.println(sol.minCost(new int[][] { { 7, 7 } }));
        // Expected: 0

        // Test 3: Two cells in a column
        System.out.println(sol.minCost(new int[][] { { 2 }, { 4 } }));
        // Expected: 6

        // Test 4: Unsorted input
        System.out.println(sol.minCost(new int[][] { { 1, 2 }, { 3, 4 } }));
        // Expected: 0

        // Test 5: Larger grid
        System.out.println(sol.minCost(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }));
        // Expected: Some value based on the XOR path

        // Test 6: All equal values
        System.out.println(sol.minCost(new int[][] { { 10, 10 }, { 10, 10 } }));
        // Expected: Some value based on the XOR path

        // Test 7: Contains a zero
        System.out.println(sol.minCost(new int[][] { { 0, 2 }, { 3, 4 } }));
        // Expected: Some value based on the XOR path

        // Test 8: One very large value and small values
        System.out.println(sol.minCost(new int[][] { { 1, 2 }, { 100, 3 } }));
        // Expected: Some value based on the XOR path
    }
}
