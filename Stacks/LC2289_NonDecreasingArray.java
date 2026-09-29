/*
LeetCode 2289 - Number of steps to make array non-decreasing
Approach: Use a stack to keep track of the elements and their corresponding counts of steps needed to make the array non-decreasing. We iterate through the array from right to left, and for each element, we pop from the stack while the current element is greater than the top of the stack. We update the count of steps accordingly and push the current element along with its count onto the stack.
Time complexity: O(n) because each element is pushed and popped from the stack at most once.
Space complexity: O(n) because in the worst case, we may need to store all elements in the stack.
*/

import java.util.Stack;

class LC2289_NonDecreasingArray {
    public int totalSteps(int[] nums) {
        int n = nums.length;
        int steps = 0;
        Stack<int[]> s = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            int count = 0;
            while (!s.isEmpty() && nums[i] > s.peek()[0]) {
                count = Math.max(count + 1, s.peek()[1]);
                s.pop();
            }
            steps = Math.max(steps, count);
            s.push(new int[] { nums[i], count });
        }
        return steps;
    }

    public static void main(String[] a) {
        LC2289_NonDecreasingArray s = new LC2289_NonDecreasingArray();
        int[] nums = { 5, 3, 4, 4, 7, 3, 6, 11, 8, 5, 11 };
        System.out.println(s.totalSteps(nums)); // Output: 3

        int[] nums2 = { 4, 5, 7, 7, 13 };
        System.out.println(s.totalSteps(nums2)); // Output: 0
    }
}
