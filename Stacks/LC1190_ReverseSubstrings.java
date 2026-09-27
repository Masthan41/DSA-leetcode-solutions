/*
LeetCode 1190 - Reverse substrings between each pair of parentheses 
Approach: Two-pass algorithm with a stack to keep track of the indices of the open parentheses. after that, we can use the door array to jump between matching parentheses and build the result string in the correct order.
Time complexity: O(n) where n is the length of the input string
Space complexity: O(n) for the stack and the door array
*/

import java.util.*;

class LC1190_ReverseSubstrings {
    public String reverseParentheses(String s) {
        int n = s.length();
        Stack<Integer> openBracket = new Stack<>();
        int[] door = new int[n];

        // First pass: Pair up parentheses
        for (int i = 0; i < n; ++i) {
            if (s.charAt(i) == '(') {
                openBracket.push(i);
            } else if (s.charAt(i) == ')') {
                int j = openBracket.pop();
                door[i] = j;
                door[j] = i;
            }
        }

        // Second pass: Build the result string
        StringBuilder result = new StringBuilder();
        int direction = 1; // Left to Right
        for (int i = 0; i < n; i += direction) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                i = door[i];
                direction = -direction;
            } else {
                result.append(s.charAt(i));
            }
        }
        return result.toString();
    }

    public static void main(String[] a) {
        LC1190_ReverseSubstrings solution = new LC1190_ReverseSubstrings();
        String s = "(u(love)i)";
        String result = solution.reverseParentheses(s);
        System.out.println(result); // Output: "iloveu"
    }
}
