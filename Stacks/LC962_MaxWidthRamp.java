/*
LeetCode 962 - Maximum Width Ramp
Approach: Using a stack to store indices of elements in decreasing order
Time complexity: O(n) as we traverse the array twice, once to fill the stack and once to find the maximum width ramp
Space complexity: O(n) for the stack to store indices
*/

import java.util.Stack;

class LC962_MaxWidthRamp {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        int maxWidth = 0;
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < n; i++) {
            if (s.isEmpty() || nums[s.peek()] >= nums[i]) {
                s.push(i);
            }
        }

        for (int j = n - 1; j >= 0; j--) {
            while (!s.isEmpty() && nums[s.peek()] <= nums[j]) {
                maxWidth = Math.max(maxWidth, j - s.pop());
            }
        }
        return maxWidth;
    }

    public static void main(String[] args) {
        LC962_MaxWidthRamp solution = new LC962_MaxWidthRamp();
        int[] nums1 = { 6, 0, 8, 2, 1, 5 };
        System.out.println(solution.maxWidthRamp(nums1)); // Output: 4

        int[] nums2 = { 9, 8, 1, 0, 1, 9, 4, 0, 4, 1 };
        System.out.println(solution.maxWidthRamp(nums2)); // Output: 7
    }
}
