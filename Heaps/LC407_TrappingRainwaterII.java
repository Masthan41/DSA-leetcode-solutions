/*
Leetcode 407 - Trapping Rain Water II
Approach - Use a min-heap (priority queue) to keep track of the boundary cells of the height map. Start by adding all the boundary cells to the heap and marking them as visited. Then, repeatedly extract the cell with the minimum height from the heap and check its unvisited neighbors. For each neighbor, calculate the water that can be trapped based on the difference between the current cell's height and the neighbor's height. Add the neighbor to the heap with an updated height (the maximum of its own height and the current cell's height) and mark it as visited. Continue this process until all cells have been processed.

Time Complexity - O(m * n * log(m * n)) where m is the number of rows and n is the number of columns in the height map. Each cell is processed once, and each insertion/extraction from the heap takes logarithmic time.
Space Complexity - O(m * n) for the priority queue and the visited array.
*/

import java.util.*;

class LC407_TrappingRainwaterII {
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        boolean vis[][] = new boolean[m][n];

        for (int row = 0; row < m; row++) {
            pq.add(new int[] { heightMap[row][0], row, 0 });
            vis[row][0] = true;

            pq.add(new int[] { heightMap[row][n - 1], row, n - 1 });
            vis[row][n - 1] = true;
        }

        for (int col = 0; col < n; col++) {
            pq.add(new int[] { heightMap[0][col], 0, col });
            vis[0][col] = true;

            pq.add(new int[] { heightMap[m - 1][col], m - 1, col });
            vis[m - 1][col] = true;
        }

        int water = 0;
        int directions[][] = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };

        while (!pq.isEmpty()) {
            int cell[] = pq.remove();
            int height = cell[0];
            int i = cell[1];
            int j = cell[2];

            for (int dir[] : directions) {
                int i_ = i + dir[0];
                int j_ = j + dir[1];

                if (i_ >= 0 && i_ < m && j_ >= 0 && j_ < n && !vis[i_][j_]) {
                    water += Math.max(height - heightMap[i_][j_], 0);
                    pq.add(new int[] { Math.max(height, heightMap[i_][j_]), i_, j_ });
                    vis[i_][j_] = true;
                }
            }
        }
        return water;
    }

    public static void main(String[] args) {
        LC407_TrappingRainwaterII solution = new LC407_TrappingRainwaterII();
        // test case 1
        int[][] heightMap1 = {
                { 1, 4, 3, 1, 3, 2 },
                { 3, 2, 1, 3, 2, 4 },
                { 2, 3, 3, 2, 3, 1 }
        };
        System.out.println(solution.trapRainWater(heightMap1)); // Output: 4

        // test case 2
        int[][] heightMap2 = {
                { 3, 3, 3, 3, 3 },
                { 3, 2, 2, 2, 3 },
                { 3, 2, 1, 2, 3 },
                { 3, 2, 2, 2, 3 },
                { 3, 3, 3, 3, 3 }
        };
        System.out.println(solution.trapRainWater(heightMap2)); // Output: 10
    }
}
