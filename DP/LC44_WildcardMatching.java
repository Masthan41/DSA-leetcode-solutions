/*
LeetCode 44 - Wildcard Matching
Approach: Use dynamic programming to match the string s with the pattern p, considering '*' as a wildcard that can match any sequence of characters.

Time Complexity: O(n * m) where n is the length of the string s and m is the length of the pattern p, as we need to fill a dp table of size (n+1) x (m+1).

Space Complexity: O(n * m) for the dp table. However, we can optimize it to O(m) by using a rolling array since we only need the previous row to compute the current row.
*/

class LC44_WildcardMatching {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean dp[][] = new boolean[n + 1][m + 1];

        dp[0][0] = true;

        for (int j = 1; j < m + 1; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }

        // bottom up
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
                } else {
                    dp[i][j] = false;
                }
            }
        }
        return dp[n][m];
    }

    public static void main(String[] args) {
        LC44_WildcardMatching obj = new LC44_WildcardMatching();
        String s = "aa";
        String p = "**";
        System.out.println(obj.isMatch(s, p));
    }
}
