/*
Leetcode 56 - Spiral Matrix
Approach - Simulate the spiral traversal by maintaining boundaries for rows and columns.
Time Complexity - O(m × n)
Space Complexity - O(m × n)
*/

import java.util.*;

public class LC56_SpiralMatrix {
    public List<Integer> spiralOrder(int[][] mat) {
        List<Integer> result = new ArrayList<>();

        int StRow = 0;
        int StCol = 0;
        int endRow = mat.length - 1;
        int endCol = mat[0].length - 1;

        while (StRow <= endRow && StCol <= endCol) {

            // top row
            for (int j = StCol; j <= endCol; j++) {
                result.add(mat[StRow][j]);
            }

            // right boundary
            for (int i = StRow + 1; i <= endRow; i++) {
                result.add(mat[i][endCol]);
            }

            // bottom boundary
            for (int j = endCol - 1; j >= StCol; j--) {
                if (StRow == endRow)
                    break;
                result.add(mat[endRow][j]);
            }

            // left boundary
            for (int i = endRow - 1; i >= StRow + 1; i--) {
                if (StCol == endCol)
                    break;
                result.add(mat[i][StCol]);
            }

            StRow++;
            StCol++;
            endRow--;
            endCol--;
        }

        return result;
    }

    public static void main(String[] args) {
        LC56_SpiralMatrix solution = new LC56_SpiralMatrix();
        int[][] mat = {
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        List<Integer> spiralOrder = solution.spiralOrder(mat);
        System.out.println(spiralOrder); // [1, 2, 3, 6, 9, 8, 7, 4, 5]
    }
}
