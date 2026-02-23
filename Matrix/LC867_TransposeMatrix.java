/*
LeetCode 867 - Transpose Matrix
Approach: Create a new matrix with swapped dimensions and fill it by transposing elements
Time Complexity: O(m*n)
Space Complexity: O(m*n)
*/

class LC867_TransposeMatrix {
    public int[][] transpose(int[][] mat) {
        int a[][] = new int[mat[0].length][mat.length];
        for (int i = 0; i < mat[0].length; i++) {
            for (int j = 0; j < mat.length; j++) {
                a[i][j] = mat[j][i];
            }
        }
        return a;
    }
    public static void main(String[] args) {
        LC867_TransposeMatrix solution = new LC867_TransposeMatrix();
        int[][] mat = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        int[][] result = solution.transpose(mat);
        System.out.println("Original Matrix:");
        for (int[] row : mat) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
        System.out.println("Transposed Matrix:");
        for (int[] row : result) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
