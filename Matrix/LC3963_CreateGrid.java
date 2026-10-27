/*
LeetCode 3963 - Create Grid
Approach: Create a grid with specific patterns by iterating through the rows and columns and filling in the values based on the given conditions.
Time Complexity: O(m * n) as we need to iterate through all elements of the grid.
Space Complexity: O(m * n) as we are storing the grid.
*/

class LC3963_CreateGrid {
    public String[] createGrid(int m, int n) {
        String ans[][] = new String[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == n - 1) {
                    ans[i][j] = ".";
                } else {
                    ans[i][j] = "#";
                }
            }
        }

        String[] res = new String[m];
        for (int i = 0; i < m; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(ans[i][j]);
            }
            res[i] = sb.toString();
        }
        return res;
    }

    public static void main(String[] args) {
        LC3963_CreateGrid gridCreator = new LC3963_CreateGrid();
        int m = 4;
        int n = 5;
        String[] grid = gridCreator.createGrid(m, n);
        for (String row : grid) {
            System.out.println(row);
        }
    }
}
