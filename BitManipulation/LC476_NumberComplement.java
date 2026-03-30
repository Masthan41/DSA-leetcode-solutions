/*
LeetCode 476 - Number Complement
Approach: create a mask that returns the number with set bits at the same positions as n, then XOR the mask with n to get the complement

Time complexity: O(log n) where n is the input number, since we are shifting the mask until it is greater than n
Space complexity: O(1) since we are using a constant amount of space for the mask and the result
*/

/*this problem is same as leetcode 1009 */

class LC476_NumberComplement {
    public int findComplement(int num) {
        int mask = 1;
        while (mask < num) {
            mask = (mask << 1) | 1;
        }
        return mask ^ num;
    }

    public static void main(String[] args) {
        LC476_NumberComplement solution = new LC476_NumberComplement();
        int num = 5;
        int complement = solution.findComplement(num);
        System.out.println("The complement of " + num + " is: " + complement);
    }
}
