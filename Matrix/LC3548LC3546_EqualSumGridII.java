/*
LeetCode 3548 - Equal Sum Grid with Patition II

Approach: 
1. Calculate the total sum of the grid.
2. Check for horizontal cuts by iterating through the rows and maintaining a running sum of the top part. For each cut, calculate the difference between the top and bottom sums and check if it matches any of the corner values or if it can be formed by removing a single element from the top part.
3. Reverse the grid and repeat the horizontal cut check to account for cuts from the bottom.
4. Transpose the grid and repeat the horizontal cut check to account for vertical cuts.

Time Complexity: O(m * n) for calculating the total and checking cuts.

Space Complexity: O(m * n) for the transposed grid and O(n) for the HashSet used in checking cuts.
*/

import java.util.*;

class LC3548_EqualSumGridII {
    long total = 0;

    // Helper to reverse rows
    private void reverse(int[][] grid) {
        int top = 0, bottom = grid.length - 1;

        while (top < bottom) {
            int[] temp = grid[top];
            grid[top] = grid[bottom];
            grid[bottom] = temp;

            top++;
            bottom--;
        }
    }

    public boolean checkHorCuts(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        HashSet<Long> set = new HashSet<>();
        long top = 0;

        for (int i = 0; i < m - 1; i++) {

            for (int j = 0; j < n; j++) {
                set.add((long) grid[i][j]);
                top += grid[i][j];
            }

            long bottom = total - top;
            long diff = top - bottom;

            if (diff == 0)
                return true;

            if (diff == grid[0][0])
                return true;
            if (diff == grid[0][n - 1])
                return true;
            if (diff == grid[i][0])
                return true;

            if (i > 0 && n > 1 && set.contains(diff)) {
                return true;
            }
        }

        return false;
    }

    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // compute total
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                total += grid[i][j];
            }
        }

        // Horizontal
        if (checkHorCuts(grid))
            return true;

        reverse(grid);

        if (checkHorCuts(grid))
            return true;

        reverse(grid);

        // Transpose
        int[][] transposeGrid = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                transposeGrid[j][i] = grid[i][j];
            }
        }

        if (checkHorCuts(transposeGrid))
            return true;

        reverse(transposeGrid);

        return checkHorCuts(transposeGrid);
    }

    public static void main(String[] args) {
        LC3548_EqualSumGridII solution = new LC3548_EqualSumGridII();

        int[][] grid1 = { { 1, 2 }, { 3, 4 } };
        System.out.println(solution.canPartitionGrid(grid1)); // true

        int[][] grid2 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        System.out.println(solution.canPartitionGrid(grid2)); // false
    }
}