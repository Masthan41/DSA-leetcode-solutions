/*
LeetCode 3754 - Concatenate Non-zero Digits and multiply by sum I
Approach: We can solve this problem by iterating through each digit of the number n. We will calculate the sum of all digits and also construct a new number by concatenating only the non-zero digits. Finally, we will return the product of the sum and the concatenated number.

Time Complexity: O(d) where d is the number of digits in n. We iterate through each digit once to calculate the sum and construct the concatenated number.
Space Complexity: O(1) as we only use a constant amount of extra space.
*/

class LC3754_ConcatinateDigitsI {
    public long sumAndMultiply(int n) {
        long sum = 0;
        long multiplier = 1;
        long result = 0;

        while (n > 0) {
            long digit = n % 10;
            sum += digit;
            if (digit != 0) {
                result += digit * multiplier;
                multiplier *= 10;
            }
            n = n / 10;
        }
        return sum * result;
    }

    public static void main(String[] args) {
        LC3754_ConcatinateDigitsI obj = new LC3754_ConcatinateDigitsI();
        int n = 123;
        long result = obj.sumAndMultiply(n);
        System.out.println("The result for n = " + n + " is: " + result);
    }
}