/*
LeetCode 1475 - Final prices with a special discount in a shop
Approach: Use a stack to store indices of the elements and pop when condition is met.
Time complexity: O(n) because all elements are being push and poped once.
Space complexity: O(n) due to the stack.
*/

import java.util.Stack;

class LC1475_FinalPrices {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        Stack<Integer> s = new Stack<>();
        int res[] = prices.clone();

        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && prices[s.peek()] >= prices[i]) {
                res[s.peek()] -= prices[i];
                s.pop();
            }
            s.push(i);
        }
        return res;
    }

    public static void main(String[] a) {
        LC1475_FinalPrices obj = new LC1475_FinalPrices();
        int[] prices = { 8, 4, 6, 2, 3 };
        int[] res = obj.finalPrices(prices);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
