/*
LeetCode 3411 - Maximum Subarray with equal products
Approach: Use a nested loop to iterate through all possible subarrays. For each subarray, calculate the product, LCM, and GCD. If the product equals the product of LCM and GCD, update the maximum length.
Time Complexity: O(n^2) as we are using a nested loop to check all subarrays.
Space Complexity: O(1) as we are using a constant amount of space.
*/

//optimized approach will be posted soon

class LC3411_MaximumSubarray {
    public int getGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public int getLCM(int a, int b) {
        return (a / getGCD(a, b)) * b;
    }

    public int maxLength(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int prod = 1;
            int LCM = nums[i];
            int GCD = nums[i];
            for (int j = i; j < n; j++) {
                prod *= nums[j];
                if (j > i) {
                    LCM = getLCM(LCM, nums[j]);
                    GCD = getGCD(GCD, nums[j]);
                }
                if (prod == LCM * GCD) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LC3411_MaximumSubarray solution = new LC3411_MaximumSubarray();
        int[] nums = { 2, 3, 4, 6 };
        int result = solution.maxLength(nums);
        System.out.println("Maximum length of subarray: " + result);
    }
}
