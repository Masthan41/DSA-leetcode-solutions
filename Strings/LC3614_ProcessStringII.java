/*
LeetCode 3614 - Process String with special operations II
Approach: As the constraints are large, we cannot build the final string. Instead, we can calculate the length of the final string and then iterate backwards to find the character at index k.
Time Complexity: O(n) where n is the length of the input string s.
Space Complexity: O(1) as we are only using a constant amount of space for the variables.
*/

class LC3614_ProcessStringII {
    public char processStr(String s, long k) {
        long length = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '*') {
                if (length > 0) {
                    length--;
                }
            } else if (ch == '#') {
                length *= 2;
            } else if (ch == '%') {
                continue;
            } else {
                length++;
            }
        }

        if (k >= length) {
            return '.';
        }

        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (ch == '*') {
                length++;
            } else if (ch == '#') {
                length /= 2;
                k = (k >= length) ? k - length : k;
            } else if (ch == '%') {
                k = length - k - 1;
            } else {
                length--;
            }

            if (k == length) {
                return ch;
            }
        }
        return '.';
    }

    public static void main(String[] args) {
        LC3614_ProcessStringII solution = new LC3614_ProcessStringII();
        String s = "ab#c*de%f";
        long k = 3;
        char result = solution.processStr(s, k);
        System.out.println("The character at index " + k + " is: " + result);
    }
}
