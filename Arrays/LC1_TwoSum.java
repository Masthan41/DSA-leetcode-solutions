/*
LeetCode 1 - Two Sum
Approach:
Use HashMap to store visited numbers and their indices.
For each element, check if (target - current) exists.
Time Complexity: O(n)
Space Complexity: O(n)
*/

class LC1_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[] {};
    }
}
