/*
LeetCode 1886 - Determine Whether Matrix Can Be Rotated To Another Matrix
Approach: Rotate and Compare

Time Complexity: O(n^2) for rotating the matrix and comparing it with the target matrix, where n is the size of the matrix. We perform at most 4 rotations, so the overall time complexity is O(4 * n^2) which simplifies to O(n^2).

Space Complexity: O(1) since we are rotating the matrix in place and not using any additional data structures that grow with input size.
*/

class LC1886_RotateMatrix{
    public void rotate(int mat[][]) {
        //Transpose
        for (int i = 0; i < mat.length; i++) {
            for (int j = i; j < mat.length; j++) {
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }

        //reverse each row
        for (int i = 0; i < mat.length; i++) {
            int left = 0, right = mat.length - 1;
            while (left < right) {
                int temp = mat[i][left];
                mat[i][left] = mat[i][right];
                mat[i][right] = temp;
                left++;
                right--;
            }
        }
    }

    public boolean findRotation(int[][] mat, int[][] target) {
        for (int c = 0; c <= 4; c++) {
            boolean eq = true;
            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < mat.length; j++) {
                    if (mat[i][j] != target[i][j]) {
                        eq = false;
                        break;
                    }
                }
                if (!eq)
                    break;
            }
            if (eq)
                return true;

            rotate(mat);
        }
        return false;
    }
    public static void main(String[] args){
        int[][] mat = {{0,1},{1,0}};
        int[][] target = {{1,0},{0,1}};

        LC1886_RotateMatrix obj = new LC1886_RotateMatrix();
        System.out.println(obj.findRotation(mat, target));
    }
}