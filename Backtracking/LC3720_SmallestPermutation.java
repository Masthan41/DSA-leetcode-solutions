/*
LeetCode 3720 - Lexicographically Smallest Permutation greater than target
Approach: Use backtracking to generate the smallest permutation that is greater than the target string.
Time Complexity: O(n!) where n is the length of the input string s.
Space Complexity: O(n) for the recursion stack and auxiliary data structures.
*/

class LC3720_SmallestPermutation {
    String result = "";

    boolean solve(StringBuilder curr, int[] count, String target, int i, boolean greater) {
        if (i == target.length()) {
            if (greater) {
                result = curr.toString();
                return true;
            }
            return false;
        }

        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (count[ch - 'a'] == 0)
                continue;

            if (greater == false && ch < target.charAt(i))
                continue;

            curr.append(ch);
            count[ch - 'a']--;

            boolean isGreater = greater || ch > target.charAt(i);

            if (solve(curr, count, target, i + 1, isGreater)) {
                return true;
            }

            curr.deleteCharAt(curr.length() - 1);
            count[ch - 'a']++;
        }

        return false;
    }

    public String lexGreaterPermutation(String s, String target) {
        int[] count = new int[26];

        for (char ch : s.toCharArray())
            count[ch - 'a']++;

        StringBuilder curr = new StringBuilder();

        solve(curr, count, target, 0, false);

        return result;
    }

    public static void main(String[] args) {
        LC3720_SmallestPermutation solution = new LC3720_SmallestPermutation();
        String s = "abc";
        String target = "acb";
        String result = solution.lexGreaterPermutation(s, target);
        System.out.println(result); // Output: "bac"
    }
}
