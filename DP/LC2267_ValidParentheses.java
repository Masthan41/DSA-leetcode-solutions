/*
LeetCode 2267 - check if there is a Valid Parentheses string path
Approach: Use dynamic programming to check if there is a valid parentheses string path in the grid. We maintain a 3D boolean array `t` where `t[i][j][openCount]` indicates whether there is a valid path from cell (i, j) to the bottom-right corner with `openCount` open parentheses. We iterate through the grid from bottom-right to top-left, updating the DP table based on the current cell's character and the possible moves (down and right). The final answer is determined by checking if there is a valid path starting from the top-left corner with one open parenthesis.

Time complexity: O(m * n * (m + n)) because we iterate through each cell in the grid and for each cell, we check all possible open parentheses counts up to the maximum path length (m + n - 1).
Space complexity: O(m * n * (m + n)) for the DP table `t` which stores the valid path information for each cell and open parentheses count.
*/

class LC2267_ValidParentheses {
    int m, n;
    boolean[][][] t;

    public boolean hasValidPath(char[][] grid) {
        m = grid.length;
        n = grid[0].length;

        if ((m + n - 1) % 2 == 1)
            return false;

        if (grid[0][0] != '(' || grid[m - 1][n - 1] != ')') {
            return false;
        }

        t = new boolean[m][n][201];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {

                for (int openCount = 0; openCount <= i + j + 1; openCount++) {
                    if (i == m - 1 && j == n - 1) {
                        t[i][j][openCount] = (openCount == 0);
                        continue;
                    }

                    t[i][j][openCount] = false;

                    // move down
                    if (i + 1 < m) {
                        int newOpCount = (grid[i + 1][j] == '(') ? openCount + 1 : openCount - 1;
                        if (newOpCount >= 0 && t[i + 1][j][newOpCount]) {
                            t[i][j][openCount] = true;
                        }
                    }

                    // move right
                    if (j + 1 < n) {
                        int newOpCount = (grid[i][j + 1] == '(') ? openCount + 1 : openCount - 1;
                        if (newOpCount >= 0 && t[i][j + 1][newOpCount]) {
                            t[i][j][openCount] = true;
                        }
                    }
                }
            }
        }
        return t[0][0][1];
    }

    public static void main(String[] a) {
        LC2267_ValidParentheses s = new LC2267_ValidParentheses();
        char[][] grid = { { '(', '(', '(' }, { ')', '(', ')' }, { '(', '(', ')' }, { '(', '(', ')' } };
        System.out.println(s.hasValidPath(grid)); // Output: true

        char[][] grid2 = { { '(', ')' }, { '(', '(' }, { ')', ')' } };
        System.out.println(s.hasValidPath(grid2)); // Output: false
    }
}
