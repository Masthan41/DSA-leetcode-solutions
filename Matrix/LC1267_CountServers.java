/*
LeetCode 1267 - Count Servers that Can Communicate
Approach: Count the number of servers in each row and column, and then count the servers that have at least one other server in the same row or column
Time Complexity: O(m*n) where m is the number of rows and n is the number of columns in the grid
Space Complexity: O(m+n) for the row and column server counts
*/

import java.util.*;

class LC1267_CountServers {
    public int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] colServerCount = new int[n];
        int[] rowAkelaServerCol = new int[m];
        Arrays.fill(rowAkelaServerCol, -1);

        int resultServers = 0;

        for (int row = 0; row < m; row++) {
            int countServersRow = 0;
            for (int col = 0; col < n; col++) {
                if (grid[row][col] == 1) {
                    countServersRow++;
                    colServerCount[col]++;
                    rowAkelaServerCol[row] = col;
                }
            }

            if (countServersRow > 1) {
                resultServers += countServersRow;
                rowAkelaServerCol[row] = -1;
            }
        }

        for (int row = 0; row < m; row++) {
            if (rowAkelaServerCol[row] != -1) {
                int col = rowAkelaServerCol[row];
                if (colServerCount[col] > 1) {
                    resultServers++;
                }
            }
        }
        return resultServers;
    }

    public static void main(String[] args) {
        LC1267_CountServers solution = new LC1267_CountServers();
        int[][] grid = {
                { 1, 0 },
                { 0, 1 }
        };
        System.out.println(solution.countServers(grid)); // Output: 0
    }
}
