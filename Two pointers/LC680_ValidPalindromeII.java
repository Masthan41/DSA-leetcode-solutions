/*
LeetCode 680 - Valid Palindrome II
Approach: Two Pointers using valid palindrome function check whether what happens if we remove ith character and jth character and subsequently return the true/false
Time Complexity: O(n) where n is the length of the string, since we may need to check each character in the worst case.
Space Complexity: O(1) since we are using a constant amount of space for pointers and variables.
*/

class LC680_ValidPalindromeII {
    public boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean validPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LC680_ValidPalindromeII obj = new LC680_ValidPalindromeII();
        String s = "abca";
        boolean res = obj.validPalindrome(s);
        System.out.println(res);
        
    }
}
