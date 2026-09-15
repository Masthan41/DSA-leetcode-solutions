/*
Leetcode 2463 - Max non overlapping palindrome substrings
Appraoch : We can use dynamic programming to solve this problem. We will create a 2D boolean array isPalindrome where isPalindrome[i][j] will be true if the substring s[i..j] is a palindrome. We will fill this array using a nested loop. Then, we will create a 1D array t where t[len] represents the maximum number of non-overlapping palindromic substrings of length len. We will iterate through the string and for each length len, we will check all possible starting indices i and ending index j such that j - i + 1 >= k. If the substring s[i..j] is a palindrome, we will update t[len] to be the maximum of its current value and 1 + t[i]. Finally, we will return t[n] where n is the length of the string.

Time Complexity: O(n^2) where n is the length of the string. We need to fill the isPalindrome array which takes O(n^2) time and then we need to iterate through the string again to fill the t array which also takes O(n^2) time.

Space Complexity: O(n^2) for the isPalindrome array and O(n) for the t array. Overall, the space complexity is O(n^2).
*/

class LC2472_MaxSubstrings {
    boolean[][] isPalindrome;
    int[] t;

    public int maxPalindromes(String s, int k) {
        int n = s.length();
        isPalindrome = new boolean[n][n];

        for (int L = 1; L <= n; L++) {
            for (int i = 0; i + L <= n; i++) {
                int j = i + L - 1;

                if (i == j) {
                    isPalindrome[i][i] = true;
                } else if (i + 1 == j) {
                    isPalindrome[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    isPalindrome[i][j] = (s.charAt(i) == s.charAt(j)) && isPalindrome[i + 1][j - 1];
                }
            }
        }

        t = new int[n + 1];
        // base case
        for (int len = 0; len < k; len++) {
            t[len] = 0; // if (n < k) return 0;
        }

        for (int len = k; len <= n; len++) {

            int result = t[len - 1]; // int result = solve(n - 1, k);

            int j = len - 1;
            for (int i = 0; j - i + 1 >= k; i++) {
                if (isPalindrome[i][j]) {
                    result = Math.max(result, 1 + t[i]); // result = max(result, 1 + solve(i, k));
                }
            }

            t[len] = result; // return t[n] = result;
        }

        return t[n]; // return solve(n, k);
    }

    public static void main(String[] args) {
        LC2472_MaxSubstrings solution = new LC2472_MaxSubstrings();
        String s = "ababa";
        int k = 3;
        int result = solution.maxPalindromes(s, k);
        System.out.println("Maximum number of non-overlapping palindromic substrings: " + result);
    }
}
