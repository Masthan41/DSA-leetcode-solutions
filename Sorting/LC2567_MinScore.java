/*
LeetCode 2567 - Minimum Score by Changing Two Elements
Approach: Sort the array and consider three options for minimizing the score.
Time Complexity: O(n log n) due to sorting.
Space Complexity: O(1) as we only use a constant amount of extra space.
*/

import java.util.Arrays;

class LC2567_MinScore {
    public int minimizeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);

        int option1 = nums[n - 3] - nums[0];
        int option2 = nums[n - 1] - nums[2];
        int option3 = nums[n - 2] - nums[1];

        return Math.min(option1, Math.min(option2, option3));
    }

    public static void main(String[] args) {
        LC2567_MinScore solution = new LC2567_MinScore();
        int[] nums = { 1, 4, 3 };
        int result = solution.minimizeSum(nums);
        System.out.println("The minimized sum is: " + result);
    }
}
