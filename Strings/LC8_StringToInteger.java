/*
LeetCode 8 - String to Integer (atoi)
Approach: Simulation

Time Complexity: O(n) where n is the length of the input string s, as we may need to traverse the string once to parse the integer.

Space Complexity: O(1) since we are using a constant amount of space to store variables for the sign, result, and index.
*/

class LC8_StringToInteger {
    public int myAtoi(String s) {
        int n = s.length();
        int i = 0;

        // Skip leading spaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }

        // 2. Handle + -
        int sign = 1;
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            if (s.charAt(i) == '-') {
                sign = -1;
            }
            i++;
        }

        // Conversion
        int res = 0;
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';

            // Overflow check
            if (res > (Integer.MAX_VALUE - digit) / 10) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }

            res = res * 10 + digit;
            i++;
        }

        return res * sign;
    }

    public static void main(String[] args) {
        LC8_StringToInteger solution = new LC8_StringToInteger();
        String input = "   -42fdg";
        int result = solution.myAtoi(input);
        System.out.println(result); // Output: -42
    }
}
