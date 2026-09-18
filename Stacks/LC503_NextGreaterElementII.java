/*
LeetCode 503 - Next Greater Element II
Approach: Use a stack to keep track of the indices of the elements in the array. We iterate through the array twice (to simulate a circular array) and for each element, we pop elements from the stack until we find a greater element or the stack is empty. If the stack is not empty, we set the answer for the current index to be the element at the index on top of the stack. Finally, we push the current index onto the stack.

Time Complexity: O(n) as each element is pushed and popped from the stack at most once.
Space Complexity: O(n) for the stack used to keep track of the indices.
*/

import java.util.*;

class LC503_NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];

        if (n == 1) {
            ans[0] = -1;
        }

        Stack<Integer> s = new Stack<>();
        for (int i = 2 * n - 1; i >= 0; i--) {
            while (!s.isEmpty() && nums[s.peek()] <= nums[i % n]) {
                s.pop();
            }

            ans[i % n] = s.isEmpty() ? -1 : nums[s.peek()];
            s.push(i % n);
        }
        return ans;
    }

    public static void main(String[] args) {
        LC503_NextGreaterElementII solution = new LC503_NextGreaterElementII();
        int[] nums = { 1, 2, 1 };
        int[] result = solution.nextGreaterElements(nums);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
