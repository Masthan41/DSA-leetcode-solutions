/*
LeetCode 856 - Score of parentheses
Approach: To calculate the score of a balanced parentheses string, we can use a depth counter to keep track of the current level of nested parentheses. When we encounter an opening parenthesis '(', we increase the depth. When we encounter a closing parenthesis ')', we decrease the depth. If the previous character was an opening parenthesis, it indicates that we have found a complete pair of parentheses, and we can calculate its score as 2 raised to the power of the current depth.

Time Complexity: O(n) where n is the length of the input string, as we iterate through the string once.
Space Complexity: O(1) since we are using a fixed amount of space.
*/

class LC856_ScoreOfParentheses{
    public int scoreOfParentheses(String s) {
        int score = 0;
        int depth = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                depth++;
            } else {
                depth--;
                if (s.charAt(i - 1) == '(') {
                    score += (1 << depth); // i.e. 2^depth
                }
            }
        }
        return score;
    }
    public static void main(String[] a){
        LC856_ScoreOfParentheses sol=new LC856_ScoreOfParentheses();
        System.out.println(sol.scoreOfParentheses("()")); // Output: 1
    }
}