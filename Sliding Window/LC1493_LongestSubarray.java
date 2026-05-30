/*
LeetCode 1493 - Longest Subarray of 1's After Deleting One Element
Approach: Sliding Window with two pointers, keep track of zero and return the size of longest with with atmost one zero in the window, if we have more than one zero then we will move the left pointer until we have atmost one zero in the window and keep track of the max size of the window with atmost one zero.
Time Complexity: O(n) for iterating through the array once
Space Complexity: O(1) as we dont use any extra space
*/

class LC1493_LongestSubarray {
    public int longestSubarray(int[] nums) {
        int zero = 0, maxzeros = Integer.MIN_VALUE;
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zero++;
            }
            while (zero > 1) {
                if (nums[left] == 0) {
                    zero--;
                }
                left++;
            }
            maxzeros = Math.max(maxzeros, i - left);
        }
        return maxzeros;
    }

    public static void main(String[] args) {
        LC1493_LongestSubarray obj = new LC1493_LongestSubarray();
        int[] nums = { 1, 1, 0, 1 };
        System.out.println(obj.longestSubarray(nums));
    }
}
