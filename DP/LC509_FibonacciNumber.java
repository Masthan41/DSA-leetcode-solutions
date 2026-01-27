/*
LeetCode 509 - Fibonacci Number
Pattern: Iterative DP (Bottom-Up)
Approach: Use two variables to build sequence iteratively
Time Complexity: O(n)
Space Complexity: O(1)
*/

class LC509_FibonacciNumber {
    public int fib(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;

        int a = 0, b = 1, c;

        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }

        return b;
    }
}
