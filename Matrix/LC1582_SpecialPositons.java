/*
LeetCode 1582 - Special Positions in a Binary Matrix
Approach: Count 1s in each row and column, then check if a 1 is the only 1 in its row and column.
Time Complexity: O(m*n)
Space Complexity: O(m+n)
*/

class LC1582_SpecialPositons {
    public int numSpecial(int[][] mat) {
        int row[] = new int[mat.length];
        int col[] = new int[mat[0].length];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1) {
                    row[i]++;
                    col[j]++;
                }
            }
        }

        int c = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 1 && row[i] == 1 && col[j] == 1) {
                    c++;
                }
            }
        }
        return c;
    }

    public static void main(String[] args) {
        LC1582_SpecialPositons s = new LC1582_SpecialPositons();
        int mat[][] = { { 1, 0, 0 }, { 0, 0, 1 }, { 1, 0, 0 } };
        System.out.println(s.numSpecial(mat));
    }
}