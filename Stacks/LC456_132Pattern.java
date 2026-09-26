/*
LeetCode 456 - 132 Pattern
Approach: Use a stack to keep track of potential candidates for the '3' in the 132 pattern. Iterate through the array from right to left, maintaining a variable 'num3' that represents the current candidate for the '3' in the pattern. If we find a number that is less than 'num3', we have found a valid 132 pattern. Otherwise, we update 'num3' by popping elements from the stack that are less than the current number, and then push the current number onto the stack as a potential candidate for '2'.
Time Complexity: O(n) where n is the length of the input array
Space Complexity: O(n) for the stack
*/

import java.util.Stack;

class LC456_132Pattern {
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        int num3 = Integer.MIN_VALUE;
        Stack<Integer> s = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] < num3) {
                return true;
            }

            while (!s.isEmpty() && s.peek() < nums[i]) {
                num3 = s.pop();
            }
            s.push(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        LC456_132Pattern solution = new LC456_132Pattern();
        int[] nums = { 3, 1, 4, 2 };
        boolean result = solution.find132pattern(nums);
        System.out.println(result); // Output: true
    }
}
