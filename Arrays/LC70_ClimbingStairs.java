/*
LeetCode 70 - Climbing Stairs
Approach: Fibonacci Dynamic Programming
Time complexity: O(n)
Space complexity: O(1)
*/

class LC70_ClimbingStairs {
    public int climbStairs(int n) {
        if (n == 1)
            return 1;
        if (n == 2)
            return 2;

        int a = 1, b = 2;
        for (int i = 3; i <= n; i++) {
            int c = a + b;
            a = b;
            b = c;
        }
        return b;
    }
}
