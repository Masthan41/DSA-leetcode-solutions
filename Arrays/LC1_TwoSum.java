/*
LeetCode 1 - Two Sum
Approach:Use HashMap to store visited numbers and their indices.
For each element, check if (target - current) exists.

Time Complexity: O(n)
Space Complexity: O(n)
*/

import java.util.*;

class LC1_TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int c = target - nums[i];

            if (map.containsKey(c)) {
                return new int[] { map.get(c), i };
            }
            map.put(nums[i], i);
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
