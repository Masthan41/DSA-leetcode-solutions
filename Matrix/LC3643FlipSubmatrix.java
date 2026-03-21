/*
LeetCode 3643 - Flip Submatrix Vertically

Approach: Two-Pointer Technique with swapping elements

Time Complexity: O(k^2) for iterating through each k x k submatrix and swapping the elements.

Space Complexity: O(1) as we are only using a constant amount of extra space for the temporary variable used in swapping.
*/

class LC3643FlipSubmatrix {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int stRow = x;
        int endRow = x + k - 1;

        int stCol = y;
        int endCol = y + k - 1;

        for (int i = stRow; i <= endRow; i++) {
            for (int j = stCol; j <= endCol; j++) {
                int temp = grid[stRow][j];
                grid[stRow][j] = grid[endRow][j];
                grid[endRow][j] = temp;
            }
            stRow++;
            endRow--;
        }
        return grid;
    }

    public static void main(String[] args) {
        LC3643FlipSubmatrix solution = new LC3643FlipSubmatrix();
        int[][] grid = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 }
        };
        int x = 1;
        int y = 1;
        int k = 2;

        int[][] result = solution.reverseSubmatrix(grid, x, y, k);
        for (int[] row : result) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}