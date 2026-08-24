/*
LeetCode 1872 - Stone Game VIII
Approach: We can use dynamic programming to solve this problem. We create an array `dp` where `dp[i]` represents the maximum score difference the current player can achieve from index `i` to the end. We iterate backwards from the last index and calculate the maximum score difference for each index based on the choices of taking or skipping the stone at that index.
Time Complexity: O(n) since we iterate through the array once.
Space Complexity: O(n) for the `dp` array.
*/

class LC1872_StoneGameVIII {
    public int stoneGameVIII(int[] stones) {
        int n = stones.length;

        int prefix[] = new int[n];
        prefix[0] = stones[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + stones[i];
        }

        int dp[] = new int[n];
        dp[n - 1] = prefix[n - 1];

        for (int i = n - 2; i >= 1; i--) {
            int take = prefix[i] - dp[i + 1];
            int skip = dp[i + 1];

            dp[i] = Math.max(take, skip);
        }
        return dp[1];
    }

    public static void main(String[] args) {
        LC1872_StoneGameVIII solution = new LC1872_StoneGameVIII();
        int[] stones = { 5, 3, 1, 4, 2 };
        int result = solution.stoneGameVIII(stones);
        System.out.println("Maximum score difference: " + result);
    }
}
