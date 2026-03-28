/*
LeetCode 2573 - String With Longest Common Prefix
Approach: Dynamic Programming, Greedy, Array
Key Idea:
Constructing the lexicographically smallest string by greedily assigning characters based on LCP constraints and validating via DP.

Time Complexity: O(n^2) where n is the length of the string, due to the double loop for filling the LCP matrix and validating the result.
Space Complexity: O(n^2) for storing the LCP matrix.
*/

class LC2573_StringWithLCP {
    public int[][] checkLCP(String word) {
        int n = word.length();
        int[][] lcp = new int[n][n];

        // last column
        for (int i = 0; i < n; i++) {
            lcp[i][n - 1] = (word.charAt(i) == word.charAt(n - 1)) ? 1 : 0;
        }

        // last row
        for (int j = 0; j < n; j++) {
            lcp[n - 1][j] = (word.charAt(n - 1) == word.charAt(j)) ? 1 : 0;
        }

        // fill rest bottom-up
        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                if (word.charAt(i) == word.charAt(j)) {
                    lcp[i][j] = 1 + lcp[i + 1][j + 1];
                } else {
                    lcp[i][j] = 0;
                }
            }
        }

        return lcp;
    }

    public String findTheString(int[][] lcp) {
        int n = lcp.length;
        char word[] = new char[n];

        for (int i = 0; i < n; i++) {
            word[i] = '$';
        }
        for (int i = 0; i < n; i++) {
            // try to match it with previous
            for (int j = 0; j < i; j++) {
                if (lcp[j][i] != 0) {
                    word[i] = word[j];
                    break;
                }
            }
            // assign smallest vlid charecter
            if (word[i] == '$') {
                boolean forbidden[] = new boolean[26];

                for (int j = 0; j < i; j++) {
                    if (lcp[j][i] == 0) {
                        forbidden[word[j] - 'a'] = true;
                    }
                }
                for (int c = 0; c < 26; c++) {
                    if (!forbidden[c]) {
                        word[i] = (char) ('a' + c);
                        break;
                    }
                }
                // no valid character possible
                if (word[i] == '$') {
                    return "";
                }
            }
        }
        String result = new String(word);

        // Final validation
        int computed[][] = checkLCP(result);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (computed[i][j] != lcp[i][j]) {
                    return "";
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LC2573_StringWithLCP onj = new LC2573_StringWithLCP();
        int[][] lcp = { { 3, 2, 1 }, { 2, 2, 1 }, { 1, 1, 1 } };
        System.out.println(onj.findTheString(lcp)); // Output: "aaa"
    }
}