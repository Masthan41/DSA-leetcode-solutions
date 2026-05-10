/*
Leetcode 209 - Minimum Size Subarray Sum
Appraoch : Use sliding window technique to find the minimum length of a contiguous subarray with sum greater than or equal to the target.
Time Complexity: O(n) where n is the length of the input array nums.
Space Complexity: O(1) for the sliding window variables.
*/
*/

class LC209_MinSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0, minLen = Integer.MAX_VALUE, sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            while (sum >= target) {
                minLen = Math.min(minLen, i - left + 1);
                sum -= nums[left];
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    public static void main(String[] args) {
        LC209_MinSubarraySum solution = new LC209_MinSubarraySum();
        int target = 7;
        int[] nums = { 2, 3, 1, 2, 4, 3 };
        int result = solution.minSubArrayLen(target, nums);
        System.out.println("Minimum length of a subarray: " + result);
    }
}
