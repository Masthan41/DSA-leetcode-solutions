class LC3546_EqualSumGrid {
    public boolean canPartitionGrid(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        long RowSum[] = new long[m];
        long ColSum[] = new long[n];

        long total = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                total += grid[i][j];
                RowSum[i] += grid[i][j];
                ColSum[j] += grid[i][j];
            }
        }

        if (total % 2 != 0)
            return false;

        //horizontal cut
        long upper = 0;
        for (int i = 0; i < m - 1; i++) {
            upper += RowSum[i];
            if (upper == total - upper) {
                return true;
            }
        }

        //Vertical cut
        long lower = 0;
        for (int j = 0; j < n - 1; j++) {
            lower += ColSum[j];
            if (lower == total - lower) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        LC3546_EqualSumGrid obj = new LC3546_EqualSumGrid();
        int[][] grid = {{1, 2}, {3, 4}};
        System.out.println(obj.canPartitionGrid(grid)); // Output: true
    }    
}
