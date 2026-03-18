/*
LeetCode 796 - Rotate String

Approach: To determine if one string is a rotation of another, we can concatenate the first string with itself. If the second string is a substring of this concatenated string, then it is a rotation of the first string. Additionally, we need to check if both strings have the same length, as rotations must be of equal length.

Time Complexity: O(m*n) for the diagonal prefix sums.
Space Complexity: O(1) since we are using a fixed amount of space.
*/

class LC796_RotateString {
    public boolean rotateString(String s, String goal) {
        int m = s.length();
        int n = goal.length();

        if (m == n && (s + s).contains(goal)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        LC796_RotateString s = new LC796_RotateString();
        String str1 = "abcde";
        String str2 = "cdeab";
        System.out.println(s.rotateString(str1, str2)); // Output: true

        String str3 = "abcde";
        String str4 = "abced";
        System.out.println(s.rotateString(str3, str4)); // Output: false
    }
}
