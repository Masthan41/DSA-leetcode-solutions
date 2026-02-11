/*
LeetCode 13 - Roman to Integer
Approach: Traverse from right to left.
If current value < previous value, subtract; else add.
Time Complexity: O(n)
Space Complexity: O(1)
*/

class LC13_RomanToInteger {
    public int romanToInt(String s) {
        int sum = 0;
        int prev = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            int curr = value(s.charAt(i));

            if (curr < prev) {
                sum -= curr;
            } else {
                sum += curr;
            }

            prev = curr;
        }

        return sum;
    }

    private int value(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}
