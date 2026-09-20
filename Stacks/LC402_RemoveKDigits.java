/*
LeetCode 402 - Remove K Digits
Approach: Use a stack to keep track of the digits in the number. We iterate through the digits of the number and for each digit, we pop elements from the stack until we find a smaller digit or the stack is empty. If we still have k digits to remove, we pop from the stack. Finally, we build the result string from the stack and remove leading zeros.

Time Complexity: O(n) as each element is pushed and popped from the stack at most once.
Space Complexity: O(n) for the stack and string builder used to build the result.
*/

import java.util.*;

class LC402_RemoveKDigits {
    public String removeKdigits(String num, int k) {
        Stack<Character> s = new Stack<>();

        for (int i = 0; i < num.length(); i++) {
            while (!s.isEmpty() && s.peek() > num.charAt(i) && k > 0) {
                s.pop();
                k--;
            }
            s.push(num.charAt(i));
        }

        while (k > 0 && !s.isEmpty()) {
            s.pop();
            k--;
        }

        StringBuilder sb = new StringBuilder();
        for (char c : s) {
            if (sb.length() == 0 && c == '0') {
                continue;
            }
            sb.append(c);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] a) {
        LC402_RemoveKDigits solution = new LC402_RemoveKDigits();
        String num = "1432219";
        int k = 3;
        String result = solution.removeKdigits(num, k);
        System.out.println(result); // Output: "1219"
    }
}