/*
LeetCode 3345 - Smallest Divisible Digit product I
Approach: Iterate through all numbers starting from n, calculate the product of its digits, and check if it is divisible by t. Return the first number that satisfies this condition.
Time Complexity: O(infinity) in the worst case, but practically it will find a solution quickly for reasonable values of n and t.
Space Complexity: O(1) since we are using a constant amount of space.
*/

class LC3345_SmallestDivisibleI {
    public int smallestNumber(int n, int t) {
        for (int i = n;; i++) {
            int num = i;
            int pro = 1;
            while (num > 0) {
                pro *= num % 10;
                num /= 10;
            }
            if (pro % t == 0) {
                return i;
            }
        }
    }

    public static void main(String[] args) {
        LC3345_SmallestDivisibleI sol = new LC3345_SmallestDivisibleI();
        int n = 3;
        int t = 6;
        System.out.println(sol.smallestNumber(n, t)); // Expected: 114
    }
}
