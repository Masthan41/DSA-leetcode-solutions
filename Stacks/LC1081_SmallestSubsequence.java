/*
LeetCode 1081 - Smallest Subsequence of Distinct Characters
Approach: Monotonic stack with greedy strategy
Time complexity: O(n) as we traverse the string once and each character is pushed and popped at most once
Space complexity: O(1) since the stack and visited array can hold at most 26 characters (the number of lowercase English letters)
*/

class LC1081_SmallestSubsequence {
    public String smallestSubsequence(String s) {
        int[] last = new int[26];

        // Store the last occurrence of each character
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        boolean[] visited = new boolean[26];
        StringBuilder stack = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // Skip if already included
            if (visited[c - 'a']) {
                continue;
            }

            // Maintain lexicographical order
            while (stack.length() > 0 &&
                    c < stack.charAt(stack.length() - 1) &&
                    last[stack.charAt(stack.length() - 1) - 'a'] > i) {

                visited[stack.charAt(stack.length() - 1) - 'a'] = false;
                stack.deleteCharAt(stack.length() - 1);
            }
            stack.append(c);
            visited[c - 'a'] = true;
        }
        return stack.toString();
    }

    public static void main(String[] args) {
        LC1081_SmallestSubsequence solution = new LC1081_SmallestSubsequence();
        String s = "cbacdcbc";
        String result = solution.smallestSubsequence(s);
        System.out.println(result); // Output: "acdb"
    }
}