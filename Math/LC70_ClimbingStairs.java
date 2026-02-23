/* 
LeetCode 70 - Climbing Stairs
Approach: Dynamic Programming (Fibonacci Logic)
Time Complexity: O(n)
Space Complexity: O(1)
*/

/*You can use recursion with memoization or an iterative approach. Here, we will use an iterative approach to optimize space complexity.
Recusrion costs you O(n^2) time complexity and O(n) space complexity, while the iterative approach costs you O(n) time complexity and O(1) space complexity.
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
    public static void main(String[] args) {
        LC70_ClimbingStairs solution = new LC70_ClimbingStairs();
        int n = 5;
        System.out.println(solution.climbStairs(n)); // Output: 8
    }
}
