import java.util.*;

class LC678_ValidParenthesisString {
    public boolean solve(int idx, int open, String s, int n, int dp[][]) {
        if (idx == n) {
            return open == 0;
        }

        if (dp[idx][open] != -1) {
            return dp[idx][open] == 1;
        }
        boolean isValid = false;

        if (s.charAt(idx) == '*') {
            isValid |= solve(idx + 1, open + 1, s, n, dp);

            isValid |= solve(idx + 1, open, s, n, dp);

            if (open > 0) {
                isValid |= solve(idx + 1, open - 1, s, n, dp);
            }
        } else if (s.charAt(idx) == '(') {
            isValid |= solve(idx + 1, open + 1, s, n, dp);
        } else if (open > 0) {
            isValid |= solve(idx + 1, open - 1, s, n, dp);

        }
        dp[idx][open] = isValid ? 1 : 0;
        return isValid;
    }

    public boolean checkValidString(String s) {
        int n = s.length();

        int dp[][] = new int[n + 1][n + 1];

        for (int t[] : dp) {
            Arrays.fill(t, -1);
        }
        return solve(0, 0, s, n, dp);
    }

    public static void main(String[] a) {
        LC678_ValidParenthesisString sol = new LC678_ValidParenthesisString();
        String s = "(*))";
        System.out.println(sol.checkValidString(s));
    }
}