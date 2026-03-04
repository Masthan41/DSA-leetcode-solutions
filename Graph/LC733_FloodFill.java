/*
LeetCode 733 - Flood Fill
Approach: Use DFS to traverse and update all connected pixels with the same original color.
Time Complexity: O(m*n)
Space Complexity: O(m*n) in worst case due to recursion stack
*/

import java.util.*;

class LC733_FloodFill {
    public void dfs(int img[][], int r, int c, int org, int col) {

        if (r < 0 || c < 0 || r >= img.length || c >= img[0].length) {
            return;
        }

        if (img[r][c] != org)
            return;

        img[r][c] = col;

        dfs(img, r + 1, c, org, col);
        dfs(img, r - 1, c, org, col);
        dfs(img, r, c + 1, org, col);
        dfs(img, r, c - 1, org, col);
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int original = image[sr][sc];

        if (original == color) {
            return image;
        }

        dfs(image, sr, sc, original, color);

        return image;
    }

    public static void main(String[] args) {
        LC733_FloodFill obj = new LC733_FloodFill();
        int image[][] = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
        int sr = 1;
        int sc = 1;
        int color = 2;

        int ans[][] = obj.floodFill(image, sr, sc, color);

        for (int i[] : ans) {
            System.out.println(Arrays.toString(i));
        }
    }
}
