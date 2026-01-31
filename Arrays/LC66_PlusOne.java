/*
LeetCode 66 - Plus One
Approach: Traverse from right and handle carry
Time Complexity: O(n)
Space Complexity: 
*/

class LC66_PlusOne{
     public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        int res[] = new int[digits.length + 1];
        res[0] = 1;
        return res;
    }
}