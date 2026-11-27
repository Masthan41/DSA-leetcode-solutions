/*
LeetCode 3946 - Maximum number of items from sale I
Approach: Dynamic Programming using recursion with memoization. We can use a 2D dp array to store the maximum number of items that can be bought with a given budget and number of items considered. The recursive function will consider two cases: taking the current item (if it fits in the budget) or skipping it.

Time complexity: O(n * budget) where n is the number of items and budget is the maximum budget. Each state (n, budget) is computed only once due to memoization.

Space complexity: O(n * budget) for the 2D dp array. However, since the values in the dp array are integers, we can consider it as O(n * budget) for practical purposes.
*/

import java.util.*;

class LC3946_MaxItemsFromSaleI {
    public int solve(int n, int budget, int minPrice, int items[][], int copies[], int dp[][]) {
        if (n == 0) {
            return budget / minPrice;
        }

        if (dp[n][budget] != -1) {
            return dp[n][budget];
        }
        int take = 0;
        int skip = 0;
        int price = items[n - 1][1];

        if (price <= budget) {
            take = 1 + copies[n - 1] + solve(n - 1, budget - price, minPrice, items, copies, dp);
        }
        skip = solve(n - 1, budget, minPrice, items, copies, dp);

        return dp[n][budget] = Math.max(take, skip);
    }

    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int copies[] = new int[n];
        int cheapest = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            cheapest = Math.min(cheapest, items[i][1]);
            int copy = 0;
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    continue;
                }
                if (items[j][0] % items[i][0] == 0) {
                    copy++;
                }
            }
            copies[i] = copy;
        }

        int dp[][] = new int[n + 1][budget + 1];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }
        return solve(n, budget, cheapest, items, copies, dp);
    }

    public static void main(String[] args) {
        LC3946_MaxItemsFromSaleI solution = new LC3946_MaxItemsFromSaleI();
        int[][] items = { { 1, 2 }, { 2, 3 }, { 3, 4 } };
        int budget = 10;
        int result = solution.maximumSaleItems(items, budget);
        System.out.println("Maximum items that can be bought: " + result);
    }
}
