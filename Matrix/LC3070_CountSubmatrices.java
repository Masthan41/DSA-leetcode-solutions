/*
LeetCode 3070 - Count Submatrices That Sum to K
Approach: Prefix Sums + Brute Force

Time Complexity: O(m*n) for building the prefix sums and O(m*n) for the brute force check, resulting in O(m*n) overall since we are modifying the grid in place.

Space Complexity: O(1) since we are modifying the input grid in place and not using any additional data structures that grow with input size.
*/

class LC3070_CountSubmatrices {
    public int countSubmatrices(int[][] grid, int k) {
        int c = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i > 0) {
                    grid[i][j] += grid[i - 1][j];
                }
                if (j > 0) {
                    grid[i][j] += grid[i][j - 1];
                }
                if (i > 0 && j > 0) {
                    grid[i][j] -= grid[i - 1][j - 1];
                }
                if (grid[i][j] <= k) {
                    c++;
                }
            }
        }
        return c;
    }

    public static void main(String[] args) {
        LC3070_CountSubmatrices s = new LC3070_CountSubmatrices();
        int[][] grid = { { 7, 6, 3 }, { 6, 6, 1 } };
        int k = 18;
        System.out.println(s.countSubmatrices(grid, k)); // Output: 4

        int[][] grid2 = { { 1, 2, 3 }, { 4, 5, 6 } };
        int k2 = 21;
        System.out.println(s.countSubmatrices(grid2, k2)); // Output: 6
    }
}