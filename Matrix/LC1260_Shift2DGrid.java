/*
LeetCode 1260 - Shift 2D Grid
Approach: Convert the 2D grid into a 1D array, perform the shift operation, and then convert it back to a 2D grid
Time Complexity: O(m*n) where m is the number of rows and n is the number of columns in the grid
Space Complexity: O(m*n) for the new grid
*/

import java.util.*;

class LC1260_Shift2DGrid {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int total = m * n;

        k %= total;

        int[][] ans = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int index = i * n + j;
                int newIndex = (index + k) % total;

                int newRow = newIndex / n;
                int newCol = newIndex % n;

                ans[newRow][newCol] = grid[i][j];
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int[] row : ans) {
            List<Integer> list = new ArrayList<>();
            for (int num : row) {
                list.add(num);
            }
            result.add(list);
        }
        return result;
    }

    public static void main(String[] args) {
        LC1260_Shift2DGrid solution = new LC1260_Shift2DGrid();
        int[][] grid = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        int k = 1;
        List<List<Integer>> result = solution.shiftGrid(grid, k);
        System.out.println(result); // Output: [[9, 1, 2], [3, 4, 5], [6, 7, 8]]
    }
}
