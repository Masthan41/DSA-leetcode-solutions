/*
LeetCode 322 - Coin Change
Approach: Greedy + Sorting

Time Complexity: O(n log n)
Space Complexity: O(1)
*/

import java.util.Arrays;

public class LC322_CoinChange {
    public int coinChange(int[] coins, int amount) {
        int dp[] = new int[amount + 1];

        Arrays.fill(dp, amount + 1);

        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {

                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        LC322_CoinChange s = new LC322_CoinChange();
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println(s.coinChange(coins, amount)); // 3
    }
}
