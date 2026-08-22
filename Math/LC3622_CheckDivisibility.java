/*
LeetCode 3622 - Check Divisibility
Approach: Calculate the sum and product of the digits of the integer and check if the integer is divisible by their sum.
Time Complexity: O(log n) where n is the input integer, since we need to iterate through the digits.
Space Complexity: O(1) since we are using a constant amount of space.
*/

class LC3622_CheckDivisibility {
    public boolean checkDivisibility(int n) {
        int sum = 0, product = 1;
        int num = n;
        while (num > 0) {
            int digit = num % 10;
            sum += digit;
            product *= digit;
            num /= 10;
        }
        return n % (sum + product) == 0;
    }

    public static void main(String[] args) {
        LC3622_CheckDivisibility obj = new LC3622_CheckDivisibility();
        int n = 123; // Example input
        boolean result = obj.checkDivisibility(n);
        System.out.println("Is " + n + " divisible by the sum and product of its digits? " + result);
    }
}
