/*
LeetCode 1406 - Stone Game II
Approach: Use Memoization, where we define a recursive function solveForAlice that takes the current player (Alice or Bob), the current index in the piles array, and the current value of M. The function calculates the maximum stones Alice can collect by trying all possible moves (taking x piles where 1 <= x <= 2 * M) and recursively calling itself for the next player. We use a 3D array t to store intermediate results to avoid redundant calculations.
Time Complexity: O(n^3) where n is the number of piles, as we have three parameters (person, i, M) that can each take up to n values.
Space Complexity: O(n^3) for the memoization table t.
*/

import java.util.*;

class LC1140_StoneGameII {
    private int n;
    private int[][][] t = new int[2][101][101]; // t[2][n+1][n+1] ~ O(n^3)

    private int solveForAlice(int[] piles, int person, int i, int M) {
        if (i >= n) {
            return 0;
        }

        if (t[person][i][M] != -1) {
            return t[person][i][M];
        }

        int result = (person == 1) ? -1 : Integer.MAX_VALUE;
        int stones = 0;

        for (int x = 1; x <= Math.min(2 * M, n - i); x++) {
            stones += piles[i + x - 1];

            if (person == 1) { // Alice
                result = Math.max(result, stones + solveForAlice(piles, 0, i + x, Math.max(M, x)));
            } else { // Bob
                result = Math.min(result, solveForAlice(piles, 1, i + x, Math.max(M, x)));
            }
        }

        return t[person][i][M] = result;
    }

    public int stoneGameII(int[] piles) {
        n = piles.length;

        for (int[][] arr2D : t) {
            for (int[] arr1D : arr2D) {
                Arrays.fill(arr1D, -1);
            }
        }

        return solveForAlice(piles, 1, 0, 1);
    }

    public static void main(String[] args) {
        LC1140_StoneGameII obj = new LC1140_StoneGameII();
        System.out.println(obj.stoneGameII(new int[] { 2, 7, 9, 4, 4 })); // 10
        System.out.println(obj.stoneGameII(new int[] { 1, 2, 3, 4, 5, 100 })); // 104
    }
}
