/*
LeetCode 2946 - Matrix Similarity
Approach: Simulation, Verifying matrix identity after cyclic row shifts using modular arithmetic.

Time Complexity: O(m*n) where m is the number of rows and n is the number of columns in the matrix.
Space Complexity: O(1) since we are modifying the input grid in place.
*/

class LC2946_MatrixSimilarity{
    public boolean areSimilar(int[][] mat, int k) {
        if (k == 0)
            return true;

        k = k % mat[0].length;

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                int finalIdx;

                if (i % 2 == 0) { // even so left shift
                    finalIdx = (j + k) % mat[0].length;
                } else { //odd so right shift
                    finalIdx = (j - k + mat[0].length) % mat[0].length;
                }

                if (mat[i][j] != mat[i][finalIdx]) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        LC2946_MatrixSimilarity obj = new LC2946_MatrixSimilarity();
        int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int k = 3;
        System.out.println(obj.areSimilar(mat, k)); // Output: true
    }
}