/*
Leetcode 74 - Search a 2D Matrix
Approach - Start from top right corner and move left or down based on comparison (Binary search)
Time Complexity - O(m + n)
Space Complexity - O(1)
*/

public class LC74_SearchInMatrix {
    public static boolean searchMatrix(int matrix[][], int key) {
        int row = 0, col = matrix[0].length - 1;

        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == key) {
                return true;
            } else if (key < matrix[row][col]) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int matrix[][] = {
            {1, 4, 7, 11, 15},
            {2, 5, 8, 12, 19},
            {3, 6, 9, 16, 22},
            {10, 13, 14, 17, 24},
            {18, 21, 23, 26, 30}
        };
        int key = 5;
        System.out.println(searchMatrix(matrix, key)); // true
    }
}
