/*
LeetCode 1074 - Number of Submatrices That Sum to Target
Approach: we use prefix sums to efficiently calculate submatrix sums.
Time Complexity: O(rows^2 * cols) for processing all possible submatrices, O(1) for each query
Space Complexity: O(cols) for the prefix sum array
*/

import java.util.*;

class LC1074_SubmatricesSum {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int res = 0;

        // prefix sum
        for (int i = 0; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                matrix[i][j] += matrix[i][j - 1];
            }
        }

        // use the same logic as leetcode 560- but for 2D array
        for (int startCol = 0; startCol < cols; startCol++) {
            for (int j = startCol; j < cols; j++) {
                HashMap<Integer, Integer> map = new HashMap<>();
                map.put(0, 1);
                int cumSum = 0;

                for (int row = 0; row < rows; row++) {
                    cumSum += matrix[row][j] - (startCol > 0 ? matrix[row][startCol - 1] : 0);

                    if (map.containsKey(cumSum - target)) {
                        res += map.get(cumSum - target);
                    }
                    map.put(cumSum, map.getOrDefault(cumSum, 0) + 1);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LC1074_SubmatricesSum obj = new LC1074_SubmatricesSum();
        int[][] matrix = { { 0, 1, 0 }, { 1, 1, 1 }, { 0, 1, 0 } };
        int target = 0;
        System.out.println(obj.numSubmatrixSumTarget(matrix, target)); // Output: 4
    }
}
