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
    public static void main(String[] args) {
        LC1_TwoSum obj = new LC1_TwoSum();
        int[] nums = { 2, 7, 11, 15 };
        int target = 9;
        int[] result = obj.twoSum(nums, target);
        System.out.println("Indices: " + result[0] + ", " + result[1]); // Indices: 0, 1
    }
}
