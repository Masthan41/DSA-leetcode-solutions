/*
LeetCode 1009 - Complement of Base 10 Integer
Approach: create a mask that returns the number with set bits at the same positions as n, then XOR the mask with n to get the complement
Time complexity: O(log n) where n is the input number, since we are shifting the mask until it is greater than n
Space complexity: O(1) since we are using a constant amount of space for the mask and the result
*/

class LC1009_TwosComplement {

    public int bitwiseComplement(int n) {
        int mask = 1;
        while (mask < n) {
            mask = (mask << 1) | 1;
        }
        return mask ^ n;
    }

    public static void main(String[] args) {
        LC1009_TwosComplement solution = new LC1009_TwosComplement();

        int result = solution.bitwiseComplement(5);
        System.out.println(result); // Output: 2
    }
}
