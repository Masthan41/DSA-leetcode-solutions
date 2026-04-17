/*
LeetCode 714 - Best Time to Buy and Sell Stock with Transaction Fee
Approach: Greedy + Dynamic Programming
Time Complexity: O(n)
Space Complexity: O(1)
*/

class LC714_BuySellStock {
    public int maxProfit(int[] prices, int fee) {
        int hold = 0 - prices[0];
        int cash = 0;

        for (int i = 1; i < prices.length; i++) {
            // sell
            cash = Math.max(cash, hold + prices[i] - fee);
            // Try to buy
            hold = Math.max(hold, cash - prices[i]);
        }
        return cash;
    }

    public static void main(String[] args) {
        LC714_BuySellStock obj = new LC714_BuySellStock();
        int[] prices = { 1, 3, 2, 8, 4, 9 };
        int fee = 2;
        int result = obj.maxProfit(prices, fee);
        System.out.println(result);
    }

}
