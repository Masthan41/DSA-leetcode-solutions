/*
Leetcode 2124 - Check if all A's appear before all B's
Approach - Iterate through the string and check if there is a 'b' followed by an 'a'. If so, return false. Otherwise, return true.

Time Complexity - O(n) where n is the length of the string.
Space Complexity - O(1) as we are using constant space.
*/

class LC2124_CheckString {
    public boolean checkString(String s) {
        int n = s.length();
        for (int i = 0; i < n - 1; i++) {

            if (s.charAt(i) == 'b' && s.charAt(i + 1) == 'a') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LC2124_CheckString solution = new LC2124_CheckString();
        String s = "aaabbb";
        boolean result = solution.checkString(s);
        System.out.println("Is the string valid? " + result);
    }
}