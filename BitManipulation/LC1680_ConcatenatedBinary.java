/*
LeetCode 1680 - Concatenation of Consecutive Binary Numbers

Approach: For each number, we determine how many bits are needed to represent it in binary. This can be done by checking if the number is a power of 2, which indicates that we need to increase the bit length. We then shift the current answer to the left by the number of bits needed and add the current number. We also take the result modulo 10^9 + 7 to prevent overflow.

Time Complexity: O(n) since we iterate through all numbers from 1 to n once.

Space Complexity: O(1) since we are using a constant amount of space to store the answer and the bit count.
*/

class LC1680_ConcatenatedBinary {
    public int concatenatedBinary(int n) {
        final int MOD = 1_000_000_007;
        long ans = 0;
        int bits = 0;
        
        for (int i = 1; i <= n; i++) {
            // if i is a power of 2, we increase bit length
            if ((i & (i - 1)) == 0) {
                bits++;
            }
            ans = ((ans << bits) % MOD + i) % MOD;
        }
        
        return (int) ans;
    }
    public static void main(String[] args) {
        LC1680_ConcatenatedBinary s = new LC1680_ConcatenatedBinary();
        int n1 = 1;
        System.out.println(s.concatenatedBinary(n1)); // Output: 1

        int n2 = 3;
        System.out.println(s.concatenatedBinary(n2)); // Output: 27

        int n3 = 12;
        System.out.println(s.concatenatedBinary(n3)); // Output: 505379714
    }
}
