/*
LeetCode 2906 - Construct Product Matrix From Grid

Approach: We can use two passes to construct the product matrix. In the first pass, we calculate the suffix product for each cell starting from the bottom-right corner of the grid. In the second pass, we calculate the prefix product for each cell starting from the top-left corner of the grid and multiply it with the corresponding suffix product to get the final product for each cell in the product matrix.

Time Complexity: O(n * m) where n is the number of rows and m is the number of columns in the grid, since we need to iterate through each cell of the grid twice (once for suffix product and once for prefix product).

Space Complexity: O(1) since we are not using any additional data structures that grow with input size.
*/

class LC2906_ProductMatrix {
    final int MOD = 12345;

    public int[][] constructProductMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int p[][] = new int[n][m];
        long suffix = 1;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                p[i][j] = (int) suffix;
                suffix = (suffix * grid[i][j]) % MOD;
            }
        }

        long prefix = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                p[i][j] = (int) (prefix * p[i][j]) % MOD;
                prefix = (prefix * grid[i][j]) % MOD;
            }
        }
        return p;
    }

    public static void main(String[] args) {
        LC2906_ProductMatrix obj = new LC2906_ProductMatrix();
        int[][] grid = { { 1, 2 }, { 3, 4 } };
        int[][] result = obj.constructProductMatrix(grid);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}