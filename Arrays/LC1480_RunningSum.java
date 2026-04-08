/*
LeetCode 1480 - Running Sum of 1d Array
Approach: Iterate through the array and update each element to be the sum of itself and all previous elements
Time complexity: O(n) where n is the length of the array
Space complexity: O(1) for the in-place modification
*/

import java.util.*;

class LC1480_RunningSum {
    public int[] runningSum(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i - 1];
        }
        return nums;
    }

    public static void main(String[] args) {
        LC1480_RunningSum solution = new LC1480_RunningSum();
        int[] nums1 = { 1, 2, 3, 4 };
        System.out.println(Arrays.toString(solution.runningSum(nums1))); // Output: [1, 3, 6, 10]
    }
}
