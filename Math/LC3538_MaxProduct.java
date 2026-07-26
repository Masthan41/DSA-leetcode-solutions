/*
LeetCode 3536 - Maximum Product of Two Digits in an Integer
Approach: Find the two largest digits in the integer.
Time Complexity: O(log n) where n is the input integer, since we need to iterate through the digits.
Space Complexity: O(1) since we are using a constant amount of space.
*/

class LC3538_MaxProduct {
    public int maxProduct(int n) {
        int max1 = -1;
        int max2 = -1;

        while (n > 0) {
            int digit = n % 10;
            if (digit >= max1) {
                max2 = max1;
                max1 = digit;
            } else if (digit > max2) {
                max2 = digit;
            }
            n = n / 10;
        }
        return max1 * max2;
    }

    public static void main(String[] args) {
        LC3538_MaxProduct solution = new LC3538_MaxProduct();
        int n = 29;
        int result = solution.maxProduct(n);
        System.out.println("Maximum product of two digits in " + n + " is: " + result); // Output: Maximum product of
                                                                                        // two digits in 29 is: 18
    }
}
