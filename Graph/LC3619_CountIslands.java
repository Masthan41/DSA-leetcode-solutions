/*
LeetCode 3619 - Count Islands With total value divisible by K.
Approach: Use BFS to traverse the grid and find all islands. For each island, calculate the sum of its values. If the sum is divisible by K, increment the count of such islands.

Time Complexity: O(M * N) where M is the number of rows and N is the number of columns in the grid.
Space Complexity: O(M * N) for the queue used in BFS, in the worst case where the entire grid is filled with land.
*/

import java.util.*;

class LC3619_CountIslands {
    int m, n;
    int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

    public long bfs(int i, int j, int[][] grid) {
        long sum = grid[i][j];
        grid[i][j] = 0;

        Queue<int[]> que = new ArrayDeque<>();
        que.offer(new int[] { i, j });

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            for (int[] dir : directions) {
                int i_ = cur[0] + dir[0];
                int j_ = cur[1] + dir[1];

                if (i_ >= 0 && i_ < m && j_ >= 0 && j_ < n && grid[i_][j_] > 0) {
                    sum += grid[i_][j_];
                    grid[i_][j_] = 0;
                    que.offer(new int[] { i_, j_ });
                }
            }
        }

        return sum;
    }

    public int countIslands(int[][] grid, int k) {
        m = grid.length;
        n = grid[0].length;

        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] > 0) {
                    long sum = bfs(i, j, grid);
                    if (sum % k == 0)
                        count++;
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        LC3619_CountIslands solution = new LC3619_CountIslands();
        int[][] grid = { { 1, 1, 0, 0, 0 }, { 1, 1, 0, 0, 0 }, { 0, 0, 1, 0, 0 }, { 0, 0, 0, 1, 1 } };
        int k = 2;
        int result = solution.countIslands(grid, k);
        System.out.println("Number of islands with sum divisible by " + k + ": " + result);
    }
}