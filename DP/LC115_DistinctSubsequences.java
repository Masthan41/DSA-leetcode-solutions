LeetCode 115 - Distinct Subsequences
Approach: We can use dynamic programming to solve this problem. We will create a 2D array dp where dp[i][j] represents the number of distinct subsequences of the first i characters of string s that equals the first j characters of string t.
Time Complexity: O(m * n) where m is the length of string s and n is the length of string t, as we need to fill the dp array of size (m+1) x (n+1).
Space Complexity: O(m * n) for the dp array.
*/


class LC115_DistinctSubsequences {
    long dp[][] = new long[1001][1001];

    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();

        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= n; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return (int) dp[m][n];
    }

    public static void main(String[] args) {
        LC115_DistinctSubsequences solution = new LC115_DistinctSubsequences();
        String s = "rabbbit";
        String t = "rabbit";
        int result = solution.numDistinct(s, t);
        System.out.println("Number of distinct subsequences: " + result);
    }
}
