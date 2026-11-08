import java.util.Arrays;

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
