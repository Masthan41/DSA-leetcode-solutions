/*
LeetCode 1572 - Diagonal Sum of Matrix
Approach: Iterate through the matrix and sum the elements on the primary and secondary diagonals.
Time Complexity: O(m*n)
Space Complexity: O(1)
*/

class LC1572_DiagonalSum {
    public int diagonalSum(int[][] mat) {
        int sum = 0;
        for (int i = 0; i < mat.length; i++) {
            sum += mat[i][i];

            if (i != mat.length - 1 - i)
                sum += mat[i][mat.length - i - 1];

            // throw exception
            if (mat.length != mat[0].length)
                throw new IllegalArgumentException("Matrix must be square");
        }
        return sum;
    }

    public static void main(String[] args) {
        LC1572_DiagonalSum obj = new LC1572_DiagonalSum();
        int[][] mat = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        System.out.println(obj.diagonalSum(mat)); // Output: 25
    }
}
