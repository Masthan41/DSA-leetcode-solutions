/*
LeetCode 1137 - nth Tribonacci Number
Approach: Use an iterative approach to calculate the Tribonacci number, keeping track of the last three numbers in the sequence

Time complexity: O(n) where n is the input number
Space complexity: O(1) for the in-place modification
*/

class LC1137_Tribonacci {
    public int tribonacci(int n) {
        if (n == 0)
            return 0;
        if (n == 1 || n == 2)
            return 1;
        int a = 0, b = 1, c = 1, d;
        if (n >= 3) {
            for (int i = 3; i <= n; i++) {
                d = a + b + c;
                a = b;
                b = c;
                c = d;
            }
        }
        return c;
    }

    public static void main(String[] args) {
        LC1137_Tribonacci solution = new LC1137_Tribonacci();
        int n = 25;
        int result = solution.tribonacci(n);
        System.out.println(result); // Output: 1389537
    }
}
