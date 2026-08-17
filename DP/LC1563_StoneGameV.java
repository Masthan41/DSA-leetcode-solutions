/*
LeetCode 1563 - Stone Game V
Approach: Use Dynamic Programming with prefix sums. dp[l][r] stores
the maximum score Alice can get from stones l to r. For every split,
compare the left and right sums and continue with the valid part.
Time Complexity: O(n^3)
Space Complexity: O(n^2)
*/

class LC1563_StoneGameV {
    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;

        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + stoneValue[i];
        }

        int[][] dp = new int[n][n];

        // length of interval
        for (int len = 2; len <= n; len++) {
            for (int l = 0; l + len - 1 < n; l++) {
                int r = l + len - 1;

                for (int k = l; k < r; k++) {
                    int left = prefix[k + 1] - prefix[l];
                    int right = prefix[r + 1] - prefix[k + 1];

                    if (left < right) {
                        dp[l][r] = Math.max(dp[l][r], left + dp[l][k]);
                    } else if (left > right) {
                        dp[l][r] = Math.max(dp[l][r], right + dp[k + 1][r]);
                    } else {
                        dp[l][r] = Math.max(dp[l][r],
                                left + Math.max(dp[l][k], dp[k + 1][r]));
                    }
                }
            }
        }
        return dp[0][n - 1];
    }
}
