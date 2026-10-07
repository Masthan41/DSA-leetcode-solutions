/*
LeetCode 301 - Remove Invalid Parentheses
Approach: Backtracking with pruning based on the count of parentheses. check if the current string is valid and keep track of the maximum length of valid strings found.
Time Complexity: O(2^n) in the worst case, where n is the length of the input string. This is because each character can either be included or excluded.
Space Complexity: O(n) for the recursion stack and the storage of valid strings in the set.
*/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class LC301_RemoveInvalidParentheses {
    private Set<String> st = new HashSet<>();
    private int n;
    private int maxLen;

    private void solve(String s, int i, StringBuilder curr, int count) {
        if (count < 0) // invalid
            return;

        if (i == n) {
            if (count == 0) {
                if (curr.length() > maxLen) { // found a longer valid string
                    maxLen = curr.length();
                    st.clear();
                }

                if (curr.length() == maxLen) {
                    st.add(curr.toString());
                }
            }
            return;
        }

        char c = s.charAt(i);

        if (c != '(' && c != ')') { // letter: always keep
            curr.append(c);
            solve(s, i + 1, curr, count);
            curr.deleteCharAt(curr.length() - 1);
            return;
        }

        // Do
        curr.append(c);

        // Explore
        solve(s, i + 1, curr, count + (c == '(' ? 1 : -1));

        // Undo and explore
        curr.deleteCharAt(curr.length() - 1);
        solve(s, i + 1, curr, count);
    }

    public List<String> removeInvalidParentheses(String s) {
        n = s.length();
        maxLen = 0;
        st.clear();

        solve(s, 0, new StringBuilder(), 0);

        return new ArrayList<>(st);
    }

    public static void main(String[] args) {
        LC301_RemoveInvalidParentheses solution = new LC301_RemoveInvalidParentheses();
        String input = "()())()";
        List<String> result = solution.removeInvalidParentheses(input);
        System.out.println(result); // Output: ["()()()", "(())()"]
    }
}