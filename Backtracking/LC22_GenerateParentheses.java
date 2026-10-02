/*
LeetCode 22 - Generate Parentheses
Approach: Backtracking with constraints
Time complexity: O(2^n) as we are expolring every possibility
Space complexity: O(n) as we are using a new arraylist
*/

import java.util.*;

class LC22_GenerateParentheses {

    private List<String> result = new ArrayList<>();

    private void solve(int n, String curr, int open, int close) {
        if (curr.length() == 2 * n) {
            result.add(curr);
            return;
        }

        if (open < n) {
            curr += '(';
            solve(n, curr, open + 1, close);
            curr = curr.substring(0, curr.length() - 1);
        }
        if (close < open) {
            curr += ')';
            solve(n, curr, open, close + 1);
            curr = curr.substring(0, curr.length() - 1);
        }
    }

    public List<String> generateParenthesis(int n) {
        solve(n, "", 0, 0);
        return result;
    }
    public static void main(String[] args) {
        LC22_GenerateParentheses sol = new LC22_GenerateParentheses();
        int n = 3;
        List<String> result = sol.generateParenthesis(n);
        System.out.println(result);
    }
}
