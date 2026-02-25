/*
LeetCode 121 - Best Time to Buy and Sell Stock
Approach: Single pass with tracking minimum buy price
Time complexity: O(n)
Space complexity: O(1)
*/

class LC121_BestTimeToBuy {
    public int maxProfit(int[] prices) {
        int bp = Integer.MAX_VALUE;
        int maxProfit = 0;

        //calcualte profit
        for (int i = 0; i < prices.length; i++) {
            if (bp < prices[i]) {
                int pr = prices[i] - bp;
                maxProfit = Math.max(maxProfit, pr);
            } else {
                bp = prices[i];
            }
        }
        return maxProfit;
    }
    public static void main(String[] args) {
        LC121_BestTimeToBuy sol = new LC121_BestTimeToBuy();
        int[] prices = {7,1,5,3,6,4};
        System.out.println(sol.maxProfit(prices)); // Output: 5
    }
}
