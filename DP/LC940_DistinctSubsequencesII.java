/*
LeetCode 940 - Distinct Subsequences II
Approach: We can use dynamic programming to solve this problem. We will create a 1D array dp where dp[i] represents the number of distinct subsequences of the first i characters of string s. We will also maintain an array prev to keep track of the last occurrence of each character in the string.

Time Complexity: O(n) where n is the length of string s, as we need to fill the dp array of size n+1.
Space Complexity: O(n) for the dp array and O(26) for the lastSeen array.
*/

import java.util.*;

class LC940_DistinctSubsequencesII {
    int M = 1000000007;
    int[] dp = new int[2001];
    int[] prev; // prev[n] = last time when we saw this nth character (1-based indexing)

    public int distinctSubseqII(String s) {
        int n = s.length();
        Arrays.fill(dp, -1);
        prev = new int[n + 1];
        int[] lastSeen = new int[26];
        for (int i = 1; i <= n; i++) {
            int idx = s.charAt(i - 1) - 'a';
            prev[i] = lastSeen[idx];
            lastSeen[idx] = i;
        }

        dp[0] = 1; // if(n == 0) return 1;
        for (int i = 1; i <= n; i++) {
            int total = (int) (2L * dp[i - 1] % M);
            if (prev[i] != 0) {
                int duplicates = dp[prev[i] - 1];
                total = (total - duplicates + M) % M;
            }
            dp[i] = total;
        }
        return (dp[n] - 1 + M) % M;
    }

    public static void main(String[] args) {
        LC940_DistinctSubsequencesII solution = new LC940_DistinctSubsequencesII();
        String s = "abc";
        int result = solution.distinctSubseqII(s);
        System.out.println("Number of distinct subsequences: " + result);
    }
}
