/*
LeetCode 9 - Palindrome Number
Approach: Reverse half of the number
Time Complexity: O(log n)
Space Complexity: O(1)
*/

class LC9_PalindromeNumber {

    public boolean isPalindrome(int x) {

        // Negative numbers and numbers ending with 0 (except 0) are not palindrome
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int rev = 0;

        // Reverse only half of the number
        while (x > rev) {
            int lastDigit = x % 10;
            rev = rev * 10 + lastDigit;
            x = x / 10;
        }

        // For even digits: x == rev
        // For odd digits: x == rev / 10 (middle digit ignored)
        return (x == rev) || (x == rev / 10);
    }
    public static void main(String[] args) {
        LC9_PalindromeNumber solution = new LC9_PalindromeNumber();
        int x = 121;
        System.out.println(solution.isPalindrome(x)); // Output: true
    }
}
