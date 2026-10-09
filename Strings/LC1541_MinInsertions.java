/*
LeetCode 1541 - Minimum Insertions to Balance a Parentheses String
Approach: Use a counter to track the number of open parentheses needed. Iterate through the string and adjust the counter based on the current character. If a closing parenthesis is encountered and there are no open parentheses, increment the answer and reset the counter. Finally, add any remaining open parentheses to the answer.
Time Complexity: O(n) as we traverse the string once
Space Complexity: O(1) as we use a constant amount of space
*/

class LC1541_MinInsertions {
    public int minInsertions(String s) {
        int n = s.length();
        int open = 0;
        int ans = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                if (open % 2 == 1) {
                    open--;
                    ans++;
                }
                open += 2;
            } else {
                open--;
                if (open < 0) {
                    ans++;
                    open = 1;
                }
            }
        }
        return ans + open;
    }

    public static void main(String[] args) {
        LC1541_MinInsertions solution = new LC1541_MinInsertions();
        String s = "(()))";
        int result = solution.minInsertions(s);
        System.out.println("Minimum insertions needed: " + result);
    }
}
