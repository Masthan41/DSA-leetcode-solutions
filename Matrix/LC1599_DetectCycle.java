class LC1599_DetectCycle {
    int m, n;
    int dir[][] = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

    public boolean DetectCycleDFS(int r, int c, int prev_r, int prev_c, char grid[][], boolean vis[][]) {
        if (vis[r][c]) {
            return true;
        }
        vis[r][c] = true;

        for (int d[] : dir) {
            int new_r = r + d[0];
            int new_c = c + d[1];
            if (new_r >= 0 && new_r < m && new_c >= 0 && new_c < n
                    && grid[new_r][new_c] == grid[r][c]) {

                if (new_r == prev_r && new_c == prev_c) {
                    continue;
                } else {
                    if (DetectCycleDFS(new_r, new_c, r, c, grid, vis)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean containsCycle(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        boolean vis[][] = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!vis[i][j]) {
                    if (DetectCycleDFS(i, j, -1, -1, grid, vis)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LC1599_DetectCycle obj = new LC1599_DetectCycle();
        char grid[][] = { { 'a', 'a', 'a', 'a' }, { 'a', 'b', 'b', 'a' }, { 'a', 'b', 'b', 'a' },
                { 'a', 'a', 'a', 'a' } };
        System.out.println(obj.containsCycle(grid));
    }
}
