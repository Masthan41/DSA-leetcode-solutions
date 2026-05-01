/*
LeetCode 396 - Rotate Function
Approach: Prefix and simulation
Calculate the initial value of F(0) and the sum of the array. Then, use the recurrence relation to compute F(k) for k = 1 to n-1.

Time complexity: O(n) where n is the length of the array. We make one pass to calculate F(0) and sum, and then another pass to compute F(k) for k = 1 to n-1.
Space complexity: O(1) extra space, as we only use a few variables to store intermediate results.
*/

class LC396_RotateFunction {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;

        int sum = 0;
        int F = 0;

        // Initial sum and F(0)
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            F += i * nums[i];
        }

        int result = F;

        // Compute next rotations using recurrence
        for (int k = 0; k < n; k++) {
            int newF = F + sum - n * nums[n - 1 - k];
            result = Math.max(result, newF);
            F = newF;
        }

        return result;
    }

    public static void main(String[] args) {
        LC396_RotateFunction obj = new LC396_RotateFunction();
        int[] nums = { 4, 3, 2, 6 };
        int result = obj.maxRotateFunction(nums);
        System.out.println(result);
    }
}