/*
Leetcode 1004 - Max Consecutive Ones III
Appraoch : Use sliding window technique to find the maximum length of a contiguous subarray with at most k 0's.
Time Complexity: O(n) where n is the length of the input array nums.
Space Complexity: O(1) for the sliding window variables.
*/

class LC1004_MaxConsecutiveOnesIII {
    public int longestOnes(int[] nums, int k) {
        int left = 0, maxCount = Integer.MIN_VALUE;
        int zeroCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCount++;
            }
            while (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }
            maxCount = Math.max(maxCount, i - left + 1);
        }
        return maxCount;
    }

    public static void main(String[] args) {
        LC1004_MaxConsecutiveOnesIII solution = new LC1004_MaxConsecutiveOnesIII();
        int[] nums = { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 };
        int k = 2;
        int result = solution.longestOnes(nums, k);
        System.out.println("Maximum number of consecutive 1's: " + result);
    }
}