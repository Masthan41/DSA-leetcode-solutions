/*
LeetCode 3693 - Climbing Stairs II
Approach: Use dynamic programming (Bottom-Up) to calculate the minimum cost to reach the top of the stairs. We maintain a dp array where dp[i] represents the minimum cost to reach step i. For each step, we consider the costs of jumping 1, 2, or 3 steps from the current position and update the dp array accordingly.

Time complexity: O(n) where n is the number of steps. We iterate through each step and calculate the minimum cost based on the previous steps.
Space complexity: O(n) for the dp array that stores the minimum cost to reach each step.
*/

class LC3693_ClimbingStairsII {
    public int climbStairs(int n, int[] costs) {
        int dp[] = new int[n + 1];

        int cost = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            int j = i + 1;
            if (j <= n) {
                cost = costs[j - 1] + ((j - i) * (j - i)) + dp[j];
            }

            j = i + 2;
            if (j <= n) {
                cost = Math.min(costs[j - 1] + ((j - i) * (j - i)) + dp[j], cost);
            }

            j = i + 3;
            if (j <= n) {
                cost = Math.min(costs[j - 1] + ((j - i) * (j - i)) + dp[j], cost);
            }
            dp[i] = cost;
        }
        return dp[0];
    }

    public static void main(String[] args) {
        LC3693_ClimbingStairsII solution = new LC3693_ClimbingStairsII();

        // test case 1
        int n = 5;
        int[] costs = { 1, 2, 3, 4, 5 };
        int result = solution.climbStairs(n, costs);
        System.out.println("Minimum cost to climb stairs: " + result);

        // test case 2
        n = 4;
        costs = new int[] { 10, 15, 20, 25 };
        result = solution.climbStairs(n, costs);
        System.out.println("Minimum cost to climb stairs: " + result);

        // test case 3
        n = 6;
        costs = new int[] { 5, 10, 15, 20, 25, 30 };
        result = solution.climbStairs(n, costs);
        System.out.println("Minimum cost to climb stairs: " + result);
    }
}
