/*
LeetCode 3789 - Minimum Cost to Buy Candies
Approach: To calculate the minimum cost to buy items with given costs, we first check if buying items separately is cheaper than buying them together. If so, we calculate the total cost based on the individual needs. Otherwise, we calculate the cost of buying items together as much as possible and then handle any remaining needs by comparing the costs of buying them separately or together.

Time Complexity: O(1) as we only perform a constant number of operations.
Space Complexity: O(1) as we only use a constant amount of extra space.
*/


class LC3789_MinCost {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        if (cost1 + cost2 <= costBoth) {
            return (long) need1 * cost1 + (long) need2 * cost2;
        }
        long total = 0;
        long both = Math.min(need1, need2);

        total = both * costBoth;
        need1 -= both;
        need2 -= both;

        if (need1 > 0) {
            total += (long) need1 * Math.min(cost1, costBoth);
        } else if (need2 > 0) {
            total += (long) need2 * Math.min(cost2, costBoth);
        }
        return total;
    }

    public static void main(String[] args) {
        LC3789_MinCost solution = new LC3789_MinCost();
        int cost1 = 2;
        int cost2 = 3;
        int costBoth = 4;
        int need1 = 5;
        int need2 = 6;

        System.out.println(solution.minimumCost(cost1, cost2, costBoth, need1, need2)); // Output: 32

        int cost1_2 = 5;
        int cost2_2 = 4;
        int costBoth_2 = 3;
        int need1_2 = 2;
        int need2_2 = 1;
        
        System.out.println(solution.minimumCost(cost1_2, cost2_2, costBoth_2, need1_2, need2_2)); // Output: 9
    }
}