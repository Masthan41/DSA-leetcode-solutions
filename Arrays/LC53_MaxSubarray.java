/*
LeetCode 53 - Maximum Subarray
Approach: Kadane's Algorithm
Time Complexity: O(n) as we traverse the array once
Space Complexity: O(1) as we use only a constant amount of extra space
*/

class LC53_MaxSubarray {
    public int maxSubArray(int[] nums) {
        int curr = nums[0], maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curr = Math.max(nums[i], curr + nums[i]);
            maxSum = Math.max(maxSum, curr);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        LC53_MaxSubarray sol = new LC53_MaxSubarray();
        int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println(sol.maxSubArray(nums)); // Output: 6
    }
}
