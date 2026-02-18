/*
LeetCode 693 - Binary Number with Alternating Bits
Approach: Bit Manipulation
Time Complexity: O(log n)
Space Complexity: O(1)
*/

class LC693_BinaryNumberWithAlternatingBits {
    public boolean hasAlternatingBits(int n) {
        int prev = n & 1;
        n = n >> 1;

        while (n > 0) {
            int curr = n & 1;
            if (curr == prev) {
                return false;
            }
            prev = curr;
            n = n >> 1;
        }
        return true;
    }
    public static void main(String[] args) {
        LC693_BinaryNumberWithAlternatingBits solution = new LC693_BinaryNumberWithAlternatingBits();

        int n = 5; // Binary: 101
        boolean result = solution.hasAlternatingBits(n);
        System.out.println(result); // Output: true

        n = 7; // Binary: 111
        result = solution.hasAlternatingBits(n);
        System.out.println(result); // Output: false

        n = 11; // Binary: 1011
        result = solution.hasAlternatingBits(n);
        System.out.println(result); // Output: false

        n = 10; // Binary: 1010
        result = solution.hasAlternatingBits(n);
        System.out.println(result); // Output: true
    }
}
