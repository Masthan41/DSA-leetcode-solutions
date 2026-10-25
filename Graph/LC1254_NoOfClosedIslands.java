/*
LeetCode 1254 - Number of Closed Islands
Approach: Depth-First Search (DFS)
Time complexity: O(M * N) where M is the number of rows and N is the number of columns
Space complexity: O(M * N) where M is the number of rows and N is the number of columns
*/

class LC1254_NoOfClosedIslands {
    private int m, n;

    private boolean dfs(int[][] grid, int r, int c) {
        // Out of bounds: touched the border, so not closed
        if (r < 0 || r >= m || c < 0 || c >= n)
            return false;

        // Water: closed on this side
        if (grid[r][c] == 1)
            return true;

        // Mark as visited
        grid[r][c] = 1;

        // Explore all 4 directions (no short-circuiting, so the full island gets
        // marked)
        boolean left = dfs(grid, r, c - 1);
        boolean right = dfs(grid, r, c + 1);
        boolean up = dfs(grid, r - 1, c);
        boolean down = dfs(grid, r + 1, c);

        return left && right && up && down;
    }

    public int closedIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    if (dfs(grid, i, j)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        LC1254_NoOfClosedIslands solution = new LC1254_NoOfClosedIslands();
        int[][] grid = {
                { 1, 1, 1, 1, 0, 1, 1 },
                { 1, 0, 0, 1, 0, 1, 0 },
                { 1, 0, 1, 1, 0, 1, 1 },
                { 1, 0, 0, 0, 0, 0, 1 },
                { 1, 1, 1, 1, 1, 1, 1 }
        };
        int result = solution.closedIsland(grid);
        System.out.println("Number of closed islands: " + result);
    }
}