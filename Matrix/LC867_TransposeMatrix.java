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
}
