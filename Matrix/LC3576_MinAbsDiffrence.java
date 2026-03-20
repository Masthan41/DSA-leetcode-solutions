/*
LeetCode 3576 - Minimum Absolute Difference in a Submatrix

Approach: Brute Force with TreeSet and Sorting

Time Complexity: O(m*n*k^2*log(k)) for iterating through each k x k submatrix and sorting the unique values within it. The sorting step dominates the time complexity, resulting in O(m*n*k^2*log(k^2)) overall.

Space Complexity: O(k^2) for the TreeSet that stores the unique values of each k x k submatrix, which is at most k^2 in size.
*/

import java.util.*;

class LC3576_MinAbsDiffrence{
    public int[][] minAbsDiff(int[][] grid, int k) {

        int res[][] = new int[grid.length - k + 1][grid[0].length - k + 1];

        for (int i = 0; i <= grid.length - k; i++) {
            for (int j = 0; j <= grid[0].length - k; j++) {

                TreeSet<Integer> val = new TreeSet<>();

                for (int r = i; r <= i + k - 1; r++) {
                    for (int c = j; c <= j + k - 1; c++) {
                        val.add(grid[r][c]);
                    }
                }
                if (val.size() == 1) {
                    res[i][j] = 0;
                    continue;
                }

                int minAbsDiff = Integer.MAX_VALUE;
                Integer prev = null;
                for (int value : val) {
                    if (prev != null) {
                        minAbsDiff = Math.min(minAbsDiff, value - prev);
                    }
                    prev = value;
                }
                res[i][j] = minAbsDiff;
            }
        }
        return res;
    }
    public static void main(String[] args){
        LC3576_MinAbsDiffrence obj = new LC3576_MinAbsDiffrence();
        int grid[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int k = 2;
        int res[][] = obj.minAbsDiff(grid, k);
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }
}