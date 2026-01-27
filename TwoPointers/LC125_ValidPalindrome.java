/*
LeetCode 125 - Valid Palindrome
Pattern: Two Pointers
Approach: Skip non-alphanumeric chars and compare from both ends
Time Complexity: O(n)
Space Complexity: O(1)
*/

class LC125_ValidPalindrome {
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {

            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            if (Character.toLowerCase(s.charAt(left)) !=
                Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
