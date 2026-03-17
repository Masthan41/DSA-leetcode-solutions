/*
LeetCode 1727 - Largest Submatrix With Rearrangements
Approach: Sorting each row and calculating the area of the largest rectangle that can be formed with the heights of the columns.

Time Complexity: O(m * nlog(n)) due to sorting each row.
Space Complexity: O(m * nlogn) due to sorting each row and storing the sorted heights.
*/

import java.util.*;

class LC1727_LargestSubmatrix {
    public int largestSubmatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int prev[] = new int[n];
        int res = 0;

        for (int i = 0; i < m; i++) {
            int curr[] = mat[i].clone();
            for (int j = 0; j < n; j++) {
                if (curr[j] != 0) {
                    curr[j] += prev[j];
                }
            }
            int sorted[] = curr.clone();
            Arrays.sort(sorted);
            for (int ptr = 0; ptr < n; ptr++) {
                int base = (n - ptr);
                int height = sorted[ptr];
                res = Math.max(base * height, res);
            }
            prev = curr;
        }
        return res;
    }

    public static void main(String[] args) {
        LC1727_LargestSubmatrix solution = new LC1727_LargestSubmatrix();
        int[][] mat = { { 0, 0, 1 }, { 1, 1, 1 }, { 1, 0, 1 } };
        System.out.println(solution.largestSubmatrix(mat)); // Output: 4
    }
}