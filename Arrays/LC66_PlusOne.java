/*
LeetCode 66 - Plus One
Approach: Traverse from right and handle carry
Time Complexity: O(n)
Space Complexity: O(n) (if new array is needed)
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
    public static void main(String[] args) {
        LC66_PlusOne obj = new LC66_PlusOne();
        int[] digits = { 1, 2, 3 };
        int[] result = obj.plusOne(digits);
        System.out.print("Result: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
        System.out.println(); // Result: 1 2 4

        digits = new int[] { 4, 3, 2, 1 };
        result = obj.plusOne(digits);
        System.out.print("Result: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
        System.out.println(); // Result: 4 3 2 2

        digits = new int[] { 9 };
        result = obj.plusOne(digits);
        System.out.print("Result: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
        System.out.println(); // Result: 1 0
    }
}