/*
LeetCode 191 - Number of 1 Bits
Approach: Bit manipulation using (n & (n-1))
Time complexity: O(number of set bits)
Space complexity: O(1)
*/

class LC191_NumberOf1Bits {
    public int hammingWeight(int n) {
        int c = 0;
        while (n != 0) {
            n = n & (n - 1);
            c++;
        }
        return c;
    }
    public static void main(String[] args) {
        LC191_NumberOf1Bits solution = new LC191_NumberOf1Bits();
        int n = 11; // Binary: 1011, has three '1' bits
        int result = solution.hammingWeight(n);
        System.out.println("Number of '1' bits: " + result);
    }
}
