/*
LeetCode 200 - Number of Islands
Approach: DFS iteration using recursion
Time complexity: O(n * m) where n is the number of rows and m is the number of columns in the grid
Space complexity: O(n * m) where n is the number of rows and m is the number of columns in the grid
*/

class LC200_NoOfIslands {

    public void dfs(int i, int j, boolean vis[][], char grid[][]) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || vis[i][j] || grid[i][j] != '1') {
            return;
        }

        vis[i][j] = true;
        dfs(i - 1, j, vis, grid);
        dfs(i, j - 1, vis, grid);
        dfs(i + 1, j, vis, grid);
        dfs(i, j + 1, vis, grid);
    }

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        boolean vis[][] = new boolean[n][m];
        int islands = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!vis[i][j] && grid[i][j] == '1') {
                    dfs(i, j, vis, grid);
                    islands++;
                }
            }
        }
        return islands;
    }

    public static void main(String[] args) {
        LC200_NoOfIslands solution = new LC200_NoOfIslands();

        char[][] grid = {
            {'1', '1', '0', '0', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '1', '0', '0'},
            {'0', '0', '0', '1', '1'}
        };
        int result = solution.numIslands(grid);
        System.out.println(result); // Output: 3
    }
}
