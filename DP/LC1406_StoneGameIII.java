/*
LeetCode 1406 - Stone Game III
Approach: Use Memoization, fill the dp table with -1, and recursively calculate the maximum score difference between the two players. The first player tries to maximize their score while the second player tries to minimize it. The first player can take 1, 2, or 3 stones from the beginning of the array, and we calculate the score difference accordingly.
Time Complexity: O(n) where n is the length of the stoneValue array, as we are filling a dp table of size n.
Space Complexity: O(n) for the dp table and O(n) for the recursion stack.
*/

import java.util.*;

class LC1406_StoneGameIII {
    int n;
    int dp[];

    public int solve(int stones[], int i) {
        if (i >= n) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int result = stones[i] - solve(stones, i + 1);

        if (i + 1 < n) {
            result = Math.max(result, stones[i] + stones[i + 1] - solve(stones, i + 2));
        }

        if (i + 2 < n) {
            result = Math.max(result, stones[i] + stones[i + 1] + stones[i + 2] - solve(stones, i + 3));
        }

        return dp[i] = result;
    }

    public String stoneGameIII(int[] stoneValue) {
        n = stoneValue.length;

        dp = new int[n];
        Arrays.fill(dp, -1);

        int diff = solve(stoneValue, 0);

        if (diff > 0) {
            return "Alice";
        }
        if (diff < 0) {
            return "Bob";
        }
        return "Tie";
    }

    public static void main(String[] args) {
        LC1406_StoneGameIII obj = new LC1406_StoneGameIII();
        int[] stoneValue = { 1, 2, 3, 7 };
        String result = obj.stoneGameIII(stoneValue);
        System.out.println(result); // Output: Bob
    }
}
