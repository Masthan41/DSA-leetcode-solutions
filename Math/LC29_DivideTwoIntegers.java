/*
LeetCode 29 - Divide Two Integers
Approach: Bit manipulation using exponential subtraction
Time Complexity: O(log n)
Space Complexity: O(1)
*/

class LC29_DivideTwoIntegers {

    public int divide(int dividend, int divisor) {

        // Handle overflow case
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Convert to long and take absolute values
        long dvd = Math.abs((long) dividend);
        long dvs = Math.abs((long) divisor);

        int quotient = 0;

        while (dvd >= dvs) {

            long temp = dvs;
            int multiple = 1;

            // Find largest shift
            while (dvd >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }

            dvd -= temp;
            quotient += multiple;
        }

        // Apply sign
        if ((dividend < 0) ^ (divisor < 0)) {
            quotient = -quotient;
        }

        return quotient;
    }
}