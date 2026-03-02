/*
LeetCode 717 - 1-bit and 2-bit Characters
Approach: Iterate and update count
Time Complexity: O(n)
Space Complexity: O(1)
*/

class LC717_1and2BinaryBits {
    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;

        while (i < bits.length - 1) {
            if (bits[i] == 1) {
                i += 2;
            } else {
                i += 1;
            }
        }
        return i == bits.length - 1;
    }

    public static void main(String[] args) {
        LC717_1and2BinaryBits solution = new LC717_1and2BinaryBits();
        int[] bits1 = { 1, 0, 0 };
        int[] bits2 = { 1, 1, 1, 0 };
        System.out.println(solution.isOneBitCharacter(bits1)); // Output: true
        System.out.println(solution.isOneBitCharacter(bits2)); // Output: false
    }
}