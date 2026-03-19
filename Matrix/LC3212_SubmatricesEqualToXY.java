/*
LeetCode 3212 - Count Submatrices with Equal Number of X and Y

Approach: Prefix Sums + Brute Force

Time Complexity: O(m*n) for building the prefix sums and O(m*n) for the brute force check, resulting in O(m*n) overall since we are modifying the grid in place.

Space Complexity: O(m*n) for the two prefix sum matrices, CumSumX and CumSumY, which store the cumulative counts of 'X' and 'Y' respectively.
*/

class LC3212_SubmatricesEqualToXY{
    public int numberOfSubmatrices(char[][] grid) {

        int CumSumX[][] = new int[grid.length][grid[0].length];
        int CumSumY[][] = new int[grid.length][grid[0].length];
        int c = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                CumSumX[i][j] = (grid[i][j] == 'X') ? 1 : 0;
                CumSumY[i][j] = (grid[i][j] == 'Y') ? 1 : 0;

                if (i > 0) {
                    CumSumX[i][j] += CumSumX[i - 1][j];
                    CumSumY[i][j] += CumSumY[i - 1][j];
                }
                if (j > 0) {
                    CumSumX[i][j] += CumSumX[i][j - 1];
                    CumSumY[i][j] += CumSumY[i][j - 1];
                }
                if (i > 0 && j > 0) {
                    CumSumX[i][j] -= CumSumX[i - 1][j - 1];
                    CumSumY[i][j] -= CumSumY[i - 1][j - 1];
                }

                if (CumSumX[i][j] == CumSumY[i][j] && CumSumX[i][j] > 0) {
                    c++;
                }
            }
        }
        return c;
    }
    public static void main(String[] args){
        LC3212_SubmatricesEqualToXY obj = new LC3212_SubmatricesEqualToXY();
        char[][] grid = {{'X', 'Y', 'X'}, {'Y', 'X', 'Y'}, {'X', 'Y', 'X'}};
        System.out.println(obj.numberOfSubmatrices(grid)); // Output: 5
    }
}