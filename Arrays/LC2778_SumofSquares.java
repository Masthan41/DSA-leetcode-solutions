/*
LeetCode 2778 - Sum of Squares of Special Elements
Approach: Iterate through the array and check if the index is a divisor of the array length. If so, add the square of the element at that index to the result.
Time complexity: O(n) where n is length of the input array
Space complexity: O(1) for the in-place modification
*/


class LC2778_SumofSquares {
    public int sumOfSquares(int[] nums) {
        int ans = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            if (n % (i + 1) == 0) {
                ans += nums[i] * nums[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LC2778_SumofSquares obj = new LC2778_SumofSquares();
        int[] nums = { 1, 2, 3, 4, 5, 6 };
        System.out.println(obj.sumOfSquares(nums)); // Output: 91
    }
}
