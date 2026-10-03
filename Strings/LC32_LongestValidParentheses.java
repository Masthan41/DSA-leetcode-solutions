/*
LeetCode 32 - Longest Valid Parentheses
Approach: Two pass scan with two counters. keep track of open and close parentheses. First pass from left to right, second pass from right to left.
Time complexity: O(2n) = O(n) as we are scanning the string twice
Space complexity: O(1) as we are using only two counters
*/


class LC32_LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int open = 0, close = 0;
        int res = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                open++;
            } else {
                close++;
            }

            if (close > open) {
                open = 0;
                close = 0;
            }

            if (open == close) {
                res = Math.max(res, open + close);
            }
        }

        open = 0;
        close = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                open++;
            } else {
                close++;
            }

            if (open > close) {
                open = 0;
                close = 0;
            }

            if (open == close) {
                res = Math.max(res, open + close);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LC32_LongestValidParentheses sol = new LC32_LongestValidParentheses();
        String s = "(()";
        int result = sol.longestValidParentheses(s);
        System.out.println(result);
    }
}
