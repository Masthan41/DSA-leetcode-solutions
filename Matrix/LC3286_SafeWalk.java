/*
LeetCode 3286 - Safe walk through grid
Approach: 0-1 BFS
Key Idea:
Using 0-1 BFS to find the path with the minimum safeness factor.
Time Complexity: O(n^2) where n is the size of the grid, due to 0-1 BFS.
Space Complexity: O(n^2) for storing the distance matrix and visited array.
*/

import java.util.*;

class LC3286_SafeWalk {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();

        int[][] dist = new int[m][n];
        for (int[] row : dist) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        Deque<int[]> dq = new ArrayDeque<>();
        dist[0][0] = grid.get(0).get(0);
        dq.offerFirst(new int[] { 0, 0 });

        int[] dr = { -1, 1, 0, 0 };
        int[] dc = { 0, 0, -1, 1 };

        while (!dq.isEmpty()) {
            int[] cur = dq.pollFirst();
            int r = cur[0], c = cur[1];

            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];

                if (nr < 0 || nr >= m || nc < 0 || nc >= n)
                    continue;

                int cost = grid.get(nr).get(nc);

                if (dist[r][c] + cost < dist[nr][nc]) {
                    dist[nr][nc] = dist[r][c] + cost;

                    if (cost == 0)
                        dq.offerFirst(new int[] { nr, nc });
                    else
                        dq.offerLast(new int[] { nr, nc });
                }
            }
        }
        return dist[m - 1][n - 1] < health;
    }

    public static void main(String[] args) {
        LC3286_SafeWalk solution = new LC3286_SafeWalk();
        List<List<Integer>> grid = List.of(
                List.of(0, 1, 0),
                List.of(0, 0, 1),
                List.of(1, 0, 0));
        int health = 3;
        boolean result = solution.findSafeWalk(grid, health);
        System.out.println("Is there a safe walk? " + result);
    }
}
