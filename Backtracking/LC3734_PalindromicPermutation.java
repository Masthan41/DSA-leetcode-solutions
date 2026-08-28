/*
LeetCode 3734 - Lexicographically Smallest palindromic Permutation greater than target
Approach: Use backtracking to generate the smallest palindromic permutation that is greater than the target string. The algorithm first checks if a palindromic permutation is possible by counting the frequency of each character. If more than one character has an odd frequency, it returns an empty string. Then, it constructs the left half of the palindrome and uses backtracking to find the lexicographically smallest permutation that is greater than the target.
Time Complexity: O(n!) where n is the length of the input string s.
Space Complexity: O(n) for the recursion stack and auxiliary data structures.
*/

class LC3734_PalindromicPermutation {
    String result = "";
    char midChar = '$';
    int half = 0;

    boolean solve(StringBuilder curr, int[] count, String target, int i, boolean greater) {
        if (i == half) {

            String leftHalf = curr.toString(); // left half
            String rightHalf = new StringBuilder(leftHalf)
                    .reverse().toString(); // right half

            String candidate = leftHalf;
            if (midChar != '$')
                candidate += midChar; // mid character
            candidate += rightHalf;

            if (candidate.compareTo(target) > 0) { // strictly greater
                result = candidate;
                return true;
            }

            return false;
        }

        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (count[ch - 'a'] == 0)
                continue;

            if (!greater && ch < target.charAt(i))
                continue;

            curr.append(ch);
            count[ch - 'a']--;

            boolean isGreater = greater || ch > target.charAt(i);

            if (solve(curr, count, target, i + 1, isGreater))
                return true;

            curr.deleteCharAt(curr.length() - 1);
            count[ch - 'a']++;
        }

        return false;
    }

    public String lexPalindromicPermutation(String s, String target) {
        int n = s.length();
        int[] count = new int[26];

        for (char ch : s.toCharArray())
            count[ch - 'a']++;

        int oddCount = 0;
        for (int c = 0; c < 26; c++) {
            if (count[c] % 2 == 1) {
                oddCount++;
                midChar = (char) (c + 'a');
            }
        }
        if (oddCount > 1)
            return "";

        // Left-half counts + middle char (only when n is odd).
        int[] halfCount = new int[26];
        for (int c = 0; c < 26; c++) {
            halfCount[c] = count[c] / 2;
        }

        half = n / 2;

        StringBuilder curr = new StringBuilder();
        solve(curr, halfCount, target, 0, false);
        return result;
    }

    public static void main(String[] args) {
        LC3734_PalindromicPermutation solution = new LC3734_PalindromicPermutation();
        String s = "aabb";
        String target = "abba";
        String result = solution.lexPalindromicPermutation(s, target);
        System.out.println(result); // Output: "baab"
    }
}
