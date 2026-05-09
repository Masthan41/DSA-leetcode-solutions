/*
LeetCode 1914 - Cyclically Rotate Grid
Approach: Extract each layer of the grid into a list, rotate the list by k positions, and then place the rotated values back into their respective positions in the grid.

Time Complexity: O(m*n) for extracting and placing back the values for each layer, where m and n are the dimensions of the grid. Since we have at most min(m/2, n/2) layers, the overall time complexity is O(m*n).

Space Complexity: O(m*n) in the worst case for storing the values of the layers in a list, especially when the grid is small and has many layers. However, since we are only storing one layer at a time, the space complexity can be considered O(max(m, n)) for the largest layer.
*/

import java.util.*;

class LC1914_GridRotation {
    public int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        int layers = Math.min(m / 2, n / 2);

        for (int layer = 0; layer < layers; layer++) {
            List<Integer> nums = new ArrayList<>();

            int top = layer;
            int bottom = m - layer - 1;
            int left = layer;
            int right = n - layer - 1;

            // Top row (left -> right)
            for (int j = left; j <= right; j++) {
                nums.add(grid[top][j]);
            }

            // Right column (top -> bottom)
            for (int i = top + 1; i <= bottom - 1; i++) {
                nums.add(grid[i][right]);
            }

            // Bottom row (right -> left)
            for (int j = right; j >= left; j--) {
                nums.add(grid[bottom][j]);
            }

            // Left column (bottom -> top)
            for (int i = bottom - 1; i >= top + 1; i--) {
                nums.add(grid[i][left]);
            }

            int norm = k % nums.size();

            Collections.rotate(nums, -norm);
            int idx = 0;

            // Top row
            for (int j = left; j <= right; j++) {
                grid[top][j] = nums.get(idx++);
            }

            // right col
            for (int i = top + 1; i <= bottom - 1; i++) {
                grid[i][right] = nums.get(idx++);
            }

            // Bottom row
            for (int j = right; j >= left; j--) {
                grid[bottom][j] = nums.get(idx++);
            }

            // Left col
            for (int i = bottom - 1; i >= top + 1; i--) {
                grid[i][left] = nums.get(idx++);
            }
        }
        return grid;
    }

    public static void main(String[] args) {
        LC1914_GridRotation solution = new LC1914_GridRotation();
        int[][] grid = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 }
        };
        int k = 2;
        int[][] result = solution.rotateGrid(grid, k);
        for (int[] row : result) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
