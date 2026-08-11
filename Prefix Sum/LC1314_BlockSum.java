/*
LeetCode 1314 - Matrix block sum
Approach: Use a prefix sum matrix to calculate the sum of elements in a block efficiently. First, create a prefix sum matrix where each element at (i, j) contains the sum of all elements from (0, 0) to (i-1, j-1) in the original matrix. Then, for each element in the original matrix, calculate the sum of the block defined by the range [i-k, i+k] and [j-k, j+k] using the prefix sum matrix.
Time Complexity: O(n^2) where n is the number of rows or columns in the matrix, as we need to fill the prefix sum matrix and then compute the block sums for each element.
Space Complexity: O(n) where n is the number of rows or columns in the matrix, as we use an additional prefix sum matrix of the same size as the input matrix.
*/

import java.util.*;

class LC1314_BlockSum {
    public int[][] matrixBlockSum(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;
        int prefix[][] = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                prefix[i][j] = matrix[i - 1][j - 1] + prefix[i][j - 1] + prefix[i - 1][j] - prefix[i - 1][j - 1];
            }
        }

        int ans[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int r1 = Math.max(i - k, 0);
                int c1 = Math.max(j - k, 0);
                int r2 = Math.min(i + k, m - 1);
                int c2 = Math.min(j + k, n - 1);

                ans[i][j] += prefix[r2 + 1][c2 + 1]
                        - prefix[r1][c2 + 1]
                        - prefix[r2 + 1][c1]
                        + prefix[r1][c1];
            }
        }
        return ans;
    }

    public static void main(String[] a) {
        LC1314_BlockSum solution = new LC1314_BlockSum();
        int[][] matrix = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        int k = 1;
        int[][] result = solution.matrixBlockSum(matrix, k);
        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }
}