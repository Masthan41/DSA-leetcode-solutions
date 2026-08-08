/*
LeetCode 3302 - Lexicographically Smallest valid Sequence
Approach: Use greedy algorithm to find the smallest valid sequence of indices from word1 that can form word2 with at most one mismatch.
Time Complexity: O(n + m) as we traverse both strings once and compute the suffix array in linear time.
Space Complexity: O(n) for the suffix array and O(m) for the answer array.
*/

class LC3302_SmallestSequence {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        // suffix[i] = number of characters from the end of word2
        // that can be matched exactly using word1[i...n-1]
        int[] suffix = new int[n + 1];

        int j = m - 1;

        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1];

            if (j >= 0 && word1.charAt(i) == word2.charAt(j)) {
                suffix[i]++;
                j--;
            }
        }

        int[] ans = new int[m];

        int p = 0;
        boolean mismatchUsed = false;

        for (j = 0; j < m; j++) {
            boolean found = false;

            while (p < n) {

                // Case 1: exact match
                if (word1.charAt(p) == word2.charAt(j)) {
                    ans[j] = p;
                    p++;
                    found = true;
                    break;
                }

                // Case 2: use the one allowed mismatch
                // and make sure the rest can be matched exactly.
                if (!mismatchUsed &&
                        suffix[p + 1] >= m - j - 1) {

                    ans[j] = p;
                    p++;
                    mismatchUsed = true;
                    found = true;
                    break;
                }

                p++;
            }

            if (!found) {
                return new int[0];
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        LC3302_SmallestSequence solution = new LC3302_SmallestSequence();
        String word1 = "abcde";
        String word2 = "ace";
        int[] result = solution.validSequence(word1, word2);
        if (result.length == 0) {
            System.out.println("No valid sequence found.");
        } else {
            System.out.print("Valid sequence indices: ");
            for (int index : result) {
                System.out.print(index + " ");
            }
            System.out.println();
        }
    }
}
