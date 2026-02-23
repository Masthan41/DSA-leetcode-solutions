/*
LeetCode 29 - Divide Two Integers
Approach: Bit manipulation using exponential subtraction
Time Complexity: O(log n)
Space Complexity: O(1)
*/

class LC29_DivideTwoIntegers {

    public int divide(int dividend, int divisor) {
        // overflow check
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);
        long quo = 0;

        while (dvd >= dvs) {
            long temp = dvs;
            long mul = 1;

            // laregst shift
            while (dvd >= (temp << 1)) {
                temp <<= 1;
                mul <<= 1;
            }
            dvd = dvd - temp;
            quo = quo + mul;
        }
        // Apply sign
        if ((dividend < 0) ^ (divisor < 0)) {
            quo = -quo;
        }

        return (int) quo;
    }
    public static void main(String[] args) {
        LC29_DivideTwoIntegers solution = new LC29_DivideTwoIntegers();
        int dividend = 10;
        int divisor = 3;
        System.out.println(solution.divide(dividend, divisor)); // Output: 3
    }
}