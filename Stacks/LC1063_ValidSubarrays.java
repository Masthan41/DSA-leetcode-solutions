/*
LeetCode 1063 - Valid Subarrays
Approach: Using a stack to store indices of elements in increasing order
Time complexity: O(n) as we traverse the array twice, once to fill the stack and once to count valid subarrays
Space complexity: O(n) for the stack to store indices
*/

import java.util.*;

class LC1063_ValidSubarrays {
    public int validSubarrays(int[] nums) {
        int n = nums.length;
        int sub = 0;
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && nums[s.peek()] > nums[i]) {
                sub += i - s.pop();
            }
            s.push(i);
        }
        while (!s.isEmpty()) {
            sub += n - s.pop();
        }
        return sub;
    }

    public static void main(String[] args) {
        LC1063_ValidSubarrays sol = new LC1063_ValidSubarrays();

        int[][] testCases = {
                { 1, 4, 2, 5, 3 },
                { 3, 2, 1 },
                { 2, 2, 2 },
                { 1 },
                { 1, 2, 3 },
                { 3, 2, 1, 4 }
        };

        int[] expected = { 11, 3, 6, 1, 6, 5 };

        for (int i = 0; i < testCases.length; i++) {
            int[] nums = testCases[i];

            int result = sol.validSubarrays(nums);

            System.out.println("Test Case " + (i + 1));
            System.out.println("Input: " + java.util.Arrays.toString(nums));
            System.out.println("Expected: " + expected[i]);
            System.out.println("Output: " + result);
            System.out.println("--------------------");
        }
    }
}