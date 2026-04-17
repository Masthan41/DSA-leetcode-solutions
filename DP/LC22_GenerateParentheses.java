/*
LeetCode 22 - Generate Parentheses
Approach: Backtracking + Recursion
Time Complexity: O(4^n / sqrt(n)) - This is the nth Catalan number
Space Complexity: O(4^n / sqrt(n)) - For storing all valid combinations
*/

import java.util.*;

class LC22_GenerateParentheses {
    public void print(char str[], int pos, int n, int open, int close, List<String> result) {
        if (close == n) {
            result.add(new String(str));
        } else {
            if (open > close) {
                str[pos] = ')';
                print(str, pos + 1, n, open, close + 1, result);
            }
            if (open < n) {
                str[pos] = '(';
                print(str, pos + 1, n, open + 1, close, result);
            }
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        char str[] = new char[2 * n];
        print(str, 0, n, 0, 0, result);
        return result;
    }

    public static void main(String[] args) {
        LC22_GenerateParentheses obj = new LC22_GenerateParentheses();
        List<String> result = obj.generateParenthesis(3);
        System.out.println(result);
    }
}
