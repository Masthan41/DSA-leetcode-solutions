/*
LeetCode 2144 - Minimum Cost of Candies
Approach 1: Greedy approach to minimize the cost of buying candies
Approach 2:frequency counting to optimize the time complexity to O(n)
Time Complexity: O(n log n) due to sorting
Space Complexity: O(1)
*/

import java.util.*;

class LC2144_MinCostOfCandies {
    // gredy approach O(nlog n)
    public int minimumCost_greedy(int[] cost) {
        Arrays.sort(cost);
        int min_cost = 0;
        for (int i = cost.length - 1; i >= 0; i -= 3) {
            if (i - 1 >= 0) {
                min_cost += cost[i] + cost[i - 1];
            } else {
                min_cost += cost[i];
            }
        }
        return min_cost;
    }

    // frequency counting O(n)
    public int minimumCost(int[] cost) {
        int freq[] = new int[101];

        for (int c : cost) {
            freq[c]++;
        }

        int ans = 0, cnt = 0;

        for (int i = 100; i >= 0; i--) {
            while (freq[i]-- > 0) {
                cnt++;
                if (cnt % 3 != 0) {
                    ans += i;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LC2144_MinCostOfCandies solution = new LC2144_MinCostOfCandies();
        int[] cost = { 1, 2, 3 };
        int result = solution.minimumCost(cost);
        System.out.println(result); // Output: 5
    }
}
