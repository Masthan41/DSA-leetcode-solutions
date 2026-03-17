/*
LeetCode 1021 - Remove Outermost Parentheses
Approach: Use a counter to track the depth of the parentheses. When we encounter '(', we increment the counter, and when we encounter ')', we decrement it. We only append characters to the result if the counter is greater than 1, which means we are inside a valid parentheses string.

Time Complexity: O(n) where n is the length of the input string.
Space Complexity: O(n) for the StringBuilder that holds the result.
*/

class LC1021_RemoveParentheses {
    public String removeOuterParentheses(String s) {
        int c = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                c--;
            }
            if (c != 0) {
                sb.append(s.charAt(i));
            }
            if (s.charAt(i) == '(') {
                c++;
            }
        }
        return sb.toString();
    }
    public static void main(String[] args){
        LC1021_RemoveParentheses solution = new LC1021_RemoveParentheses();
        String s = "(()())(())";
        System.out.println(solution.removeOuterParentheses(s)); // Output: "()()()"
    }
}
