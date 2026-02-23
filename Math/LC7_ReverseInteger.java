/* LeetCode 7 - Reverse Integer
Approach: Pop and Push Digits & Check Overflow
Time Complexity: O(log(n))
Space Complexity: O(1)
*/

public class LC7_ReverseInteger {
    public int reverse(int n) {
        int rev = 0;
        while (n != 0) {
            int re = n % 10;
            n = n / 10;

            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && re > 7))
                return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && re < -8))
                return 0;

            rev = rev * 10 + re;
        }
        return rev;
    }
    public static void main(String[] args) {
        LC7_ReverseInteger solution = new LC7_ReverseInteger();
        int n = 123;
        System.out.println(solution.reverse(n)); // Output: 321
    }
}
