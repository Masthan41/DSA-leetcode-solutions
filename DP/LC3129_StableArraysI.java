/*
LeetCode 3129 - Find All Possible Stable Binary Arrays I
Approach: Dynamic Programming (3D DP to track counts of 0s and 1s with constraints)
Time complexity: O(zero * one * limit)
Space complexity: O(zero * one * limit)
*/

class LC3129_StableArraysI {
    public int numberOfStableArrays(int zero, int one, int limit) {
        int MOD = 1_000_000_007;
        long[][][] dp = new long[zero + 1][one + 1][2];

        // Base cases
        for (int i = 0; i <= Math.min(zero, limit); i++)
            dp[i][0][0] = 1;

        for (int j = 0; j <= Math.min(one, limit); j++)
            dp[0][j][1] = 1;

        for (int i = 1; i <= zero; i++) {
            for (int j = 1; j <= one; j++) {

                // Ending with 0
                dp[i][j][0] = (dp[i - 1][j][0] + dp[i - 1][j][1]) % MOD;
                if (i > limit)
                    dp[i][j][0] = (dp[i][j][0] - dp[i - limit - 1][j][1] + MOD) % MOD;

                // Ending with 1
                dp[i][j][1] = (dp[i][j - 1][0] + dp[i][j - 1][1]) % MOD;
                if (j > limit)
                    dp[i][j][1] = (dp[i][j][1] - dp[i][j - limit - 1][0] + MOD) % MOD;
            }
        }

        return (int) ((dp[zero][one][0] + dp[zero][one][1]) % MOD);
    }

    public static void main(String[] args) {
        LC3129_StableArraysI solution = new LC3129_StableArraysI();

        int zero = 2, one = 2, limit = 1;
        int result = solution.numberOfStableArrays(zero, one, limit);
        System.out.println("Number of stable arrays: " + result); // Output: 2
    }
}