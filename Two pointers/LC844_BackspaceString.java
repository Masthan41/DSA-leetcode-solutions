/*
LeetCode 844 - Backspace String Compare
Approach: Two Pointers, one for each string & compare characters of each string in nested while loops
Time Complexity: O(n + m) where n is the length of the first string and m is the length of the second string, since we may need to check each character in the worst case.
Space Complexity: O(1) since we are using a constant amount of space for pointers and variables.
*/

class LC844_BackspaceString {
    public boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1, j = t.length() - 1;
        int skip_s = 0, skip_t = 0;
        while (i >= 0 || j >= 0) {
            while (i >= 0) {
                if (s.charAt(i) == '#') {
                    skip_s++;
                    i--;
                } else if (skip_s > 0) {
                    skip_s--;
                    i--;
                } else {
                    break;
                }
            }
            while (j >= 0) {
                if (t.charAt(j) == '#') {
                    skip_t++;
                    j--;
                } else if (skip_t > 0) {
                    skip_t--;
                    j--;
                } else {
                    break;
                }
            }
            char first = i < 0 ? '$' : s.charAt(i);
            char second = j < 0 ? '$' : t.charAt(j);

            if (first != second)
                return false;

            i--;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        LC844_BackspaceString obj = new LC844_BackspaceString();
        String s = "ab#c";
        String t = "ad#c";
        boolean res = obj.backspaceCompare(s, t);
        System.out.println(res);
    }
}
