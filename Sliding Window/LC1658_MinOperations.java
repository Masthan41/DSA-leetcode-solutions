/*
LeetCode 1658 - Minimum Operations to Reduce X to Zero
Approach: Calculate the total sum of the array and determine the target sum as total - x. Use a sliding window approach to find the longest subarray that sums up to the target. If such a subarray is found, the minimum operations required will be the length of the array minus the length of this subarray. If no such subarray exists, return -1.

Time complexity: O(n) since we iterate through the array once to calculate the total and once to find the longest subarray.
Space complexity: O(1) since we are using only a constant amount of extra space for variables.
*/

class LC1658_MinOperations {
    public int minOperations(int[] nums, int x) {
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            total += nums[i];
        }
        int target = total - x;

        int sum = 0, left = 0, maxLen = -1;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (target < 0)
                return -1;
            if (target == 0)
                return nums.length;

            while (sum > target) {
                sum -= nums[left];
                left++;
            }
            if (sum == target) {
                maxLen = Math.max(maxLen, i - left + 1);
            }
        }
        return maxLen == -1 ? -1 : nums.length - maxLen;
    }

    public static void main(String[] args) {
        LC1658_MinOperations solution = new LC1658_MinOperations();
        int[] nums = { 1, 1, 4, 2, 3 };
        int x = 5;
        int result = solution.minOperations(nums, x);
    }
}