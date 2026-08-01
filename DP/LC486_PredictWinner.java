/*
LeetCode 486 - Predict the Winner
Approach: Use Memoization, fill the dp table with -1, and recursively calculate the maximum score difference between the two players. The first player tries to maximize their score while the second player tries to minimize it.
Time Complexity: O(n^2) where n is the length of the nums array, as we are filling a dp table of size n x n.
Space Complexity: O(n^2) for the dp table and O(n) for the recursion stack.
*/

import java.util.*;

class LC486_PredictWinner {
    int dp[][] = new int[21][21];

    public int solve(int nums[], int i, int j) {
        if (i > j) {
            return 0;
        }

        if (i == j) {
            return nums[i];
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int take_i = nums[i] - solve(nums, i + 1, j);

        int take_j = nums[j] - solve(nums, i, j - 1);

        return dp[i][j] = Math.max(take_i, take_j);
    }

    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;

        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }
        return solve(nums, 0, n - 1) >= 0;
    }

    public static void main(String[] a) {
        LC486_PredictWinner obj = new LC486_PredictWinner();
        int[] nums = { 1, 5, 2 };
        System.out.println(obj.predictTheWinner(nums));
    }
}