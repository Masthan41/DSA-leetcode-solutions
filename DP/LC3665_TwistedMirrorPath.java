/*
LeetCode 3665 - Twisted Mirror Path count
Approach: Use dynamic programming to count unique paths in a grid with mirrors. Each cell can either be empty (0) or contain a mirror (1). The robot can move right or down, and when it encounters a mirror, it changes direction.

Time complexity: O(m * n) where m is the number of rows and n is the number of columns in the grid. We iterate through each cell and compute the number of unique paths to that cell based on the previous cells.
Space complexity: O(m * n * 2) for the DP table, where we store the number of unique paths to each cell from two possible directions (left and up).
*/

class LC3665_TwistedMirrorPath {
    int LEFT = 0;
    int UP = 1;
    int MOD = 1_000_000_007;
    int m, n;

    public int uniquePaths(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        int[][][] t = new int[m + 1][n + 1][2];

        for (int row = m - 1; row >= 0; row--) {
            for (int col = n - 1; col >= 0; col--) {
                for (int cameFrom = 0; cameFrom < 2; cameFrom++) {

                    // Destination reached
                    if (row == m - 1 && col == n - 1) {
                        t[row][col][cameFrom] = 1;
                        continue;
                    }

                    if (grid[row][col] == 1) {
                        if (cameFrom == LEFT)
                            t[row][col][cameFrom] = t[row + 1][col][UP];
                        else
                            t[row][col][cameFrom] = t[row][col + 1][LEFT];
                        continue;
                    }

                    long total = 0;
                    total += t[row][col + 1][LEFT];
                    total += t[row + 1][col][UP];

                    t[row][col][cameFrom] = (int) (total % MOD);
                }
            }
        }
        return t[0][0][LEFT];
    }

    public static void main(String[] args) {
        LC3665_TwistedMirrorPath solution = new LC3665_TwistedMirrorPath();
        int[][] grid = {
                { 0, 0, 1 },
                { 0, 1, 0 },
                { 0, 0, 0 }
        };
        int result = solution.uniquePaths(grid);
        System.out.println("Number of unique paths: " + result);
    }
}