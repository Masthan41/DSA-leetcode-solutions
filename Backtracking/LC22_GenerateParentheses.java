/*
LeetCode 22 - Generate Parentheses
Approach: Backtracking with constraints
Time complexity: O(2^n)
Space complexity: O(n)
*/

import java.util.*;

class LC22_GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(res, new StringBuilder(), 0, 0, n);
        return res;
    }

    private void backtrack(List<String> res, StringBuilder sb, int open, int close, int n) {
        if (sb.length() == 2 * n) {
            res.add(sb.toString());
            return;
        }

        if (open < n) {
            sb.append('(');
            backtrack(res, sb, open + 1, close, n);
            sb.deleteCharAt(sb.length() - 1);
        }

        if (close < open) {
            sb.append(')');
            backtrack(res, sb, open, close + 1, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    public static void main(String[] args) {
        LC22_GenerateParentheses sol = new LC22_GenerateParentheses();
        int n = 3;
        List<String> result = sol.generateParenthesis(n);
        System.out.println(result);
    }
}
