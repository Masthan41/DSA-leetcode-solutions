/*
LeetCode 1878 - Get Biggest Three Rhombus Sums in a Grid
Approach: Daigonal Prefix Sums + TreeSet

Time Complexity: O(m*n*min(m,n)) where m and n are the dimensions of the grid. We iterate through each cell and for each cell, we check for rhombuses of increasing size until we go out of bounds. The number of rhombuses we can check for each cell is limited by the smaller dimension of the grid.

Space Complexity: O(m*n) for the diagonal prefix sums and O(1) for the TreeSet (since it can hold at most 3 elements).
*/

import java.util.*;

public class LC1878_Biggest3Rombhus {
    public int[] getBiggestThree(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        // left to right diagonals prefix
        int[][] d1 = new int[m][n];

        // right to left diagonals prefix
        int[][] d2 = new int[m][n];

        // building d1
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                d1[i][j] = grid[i][j];
                if (i > 0 && j > 0)
                    d1[i][j] += d1[i - 1][j - 1];
            }
        }

        // building d2
        for (int i = 0; i < m; i++) {
            for (int j = n - 1; j >= 0; j--) {
                d2[i][j] = grid[i][j];
                if (i > 0 && j + 1 < n)
                    d2[i][j] += d2[i - 1][j + 1];
            }
        }

        TreeSet<Integer> st = new TreeSet<>();

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {

                // rhombus with side = 0
                addToSet(st, grid[r][c]);

                for (int side = 1; r - side >= 0 && r + side < m && c - side >= 0 && c + side < n; side++) {

                    int sum = 0;

                    int top_r = r - side, top_c = c;
                    int right_r = r, right_c = c + side;
                    int bottom_r = r + side, bottom_c = c;
                    int left_r = r, left_c = c - side;

                    // top to right corner
                    sum += d1[right_r][right_c];
                    if (top_r - 1 >= 0 && top_c - 1 >= 0)
                        sum -= d1[top_r - 1][top_c - 1];

                    // right to bottom corner
                    sum += d2[bottom_r][bottom_c];
                    if (right_r - 1 >= 0 && right_c + 1 < n)
                        sum -= d2[right_r - 1][right_c + 1];

                    // bottom to left corner
                    sum += d1[bottom_r][bottom_c];
                    if (left_r - 1 >= 0 && left_c - 1 >= 0)
                        sum -= d1[left_r - 1][left_c - 1];

                    // left to top corner
                    sum += d2[left_r][left_c];
                    if (top_r - 1 >= 0 && top_c + 1 < n)
                        sum -= d2[top_r - 1][top_c + 1];

                    // remove corners counted twice
                    sum -= grid[top_r][top_c];
                    sum -= grid[right_r][right_c];
                    sum -= grid[bottom_r][bottom_c];
                    sum -= grid[left_r][left_c];

                    addToSet(st, sum);
                }
            }
        }
        return buildAnswer(st);
    }

    private void addToSet(TreeSet<Integer> st, int val) {
        st.add(val);
        if (st.size() > 3)
            st.pollFirst();
    }

    private int[] buildAnswer(TreeSet<Integer> st) {
        int[] res = new int[st.size()];
        int idx = 0;

        Iterator<Integer> it = st.descendingIterator();
        while (it.hasNext())
            res[idx++] = it.next();

        return res;
    }

    public static void main(String[] args) {
        LC1878_Biggest3Rombhus obj = new LC1878_Biggest3Rombhus();
        int[][] grid = { { 3, 4, 5, 1, 3 }, { 3, 3, 4, 2, 3 }, { 20, 30, 200, 40, 10 }, { 1, 5, 5, 4, 1 },
                { 4, 3, 2, 2, 5 } };
        int[] res = obj.getBiggestThree(grid);
        for (int x : res)
            System.out.print(x + " "); // 228 216 211
    }
}
