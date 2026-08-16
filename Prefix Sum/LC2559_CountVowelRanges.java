/*
LeetCode 2559 - Count Vowel Strings in Ranges
Approach: Use a prefix sum to efficiently calculate the number of vowel strings in each query range.
Time Complexity: O(n + q) where n is the length of the words array and q is the number of queries.
Space Complexity: O(n) for storing the prefix sums.
*/

class LC2559_CountVowelRanges {
    public boolean isVowel(char s) {
        return s == 'a' || s == 'e' || s == 'i' || s == 'o' || s == 'u';
    }

    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = queries.length;
        int m = words.length;
        int res[] = new int[n];
        int prefix[] = new int[m];

        int sum = 0;
        for (int i = 0; i < m; i++) {
            String word = words[i];
            if (isVowel(word.charAt(0)) && isVowel(word.charAt(word.length() - 1))) {
                sum++;
            }
            prefix[i] = sum;
        }

        for (int i = 0; i < n; i++) {
            int left = queries[i][0];
            int right = queries[i][1];

            if (left == 0) {
                res[i] = prefix[right];
            } else {
                res[i] = prefix[right] - prefix[left - 1];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LC2559_CountVowelRanges obj = new LC2559_CountVowelRanges();
        String[] words = { "aba", "bcb", "ece", "aa", "e" };
        int[][] queries = { { 0, 2 }, { 1, 4 }, { 1, 1 } };
        int[] result = obj.vowelStrings(words, queries);
        for (int count : result) {
            System.out.print(count + " ");
        }
    }
}
