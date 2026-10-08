/*
LeetCode 496 - Next Greater Element IV
Approach: Use two stacks to find the second greater element for each number in the array. The first stack keeps track of indices of elements for which we are looking for the next greater element, while the second stack keeps track of indices of elements for which we are looking for the second greater element.

Time complexity: O(n) as each element is pushed and popped from the stacks at most once.
Space complexity: O(n) as we are using two stacks to store indices of elements.
*/

import java.util.Arrays;
import java.util.Stack;

class LC2454_NextGreaterElementIV {
    public int[] secondGreaterElement(int[] nums) {
        int n = nums.length;
        int ans[] = new int[n];

        Arrays.fill(ans, -1);

        Stack<Integer> f = new Stack<>();
        Stack<Integer> s = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && nums[s.peek()] < nums[i]) {
                ans[s.pop()] = nums[i];
            }

            Stack<Integer> temp = new Stack<>();
            while (!f.isEmpty() && nums[f.peek()] < nums[i]) {
                temp.push(f.pop());
            }

            while (!temp.isEmpty()) {
                s.push(temp.pop());
            }
            f.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        LC2454_NextGreaterElementIV obj = new LC2454_NextGreaterElementIV();
        int[] nums = { 2, 4, 0, 9, 6 };
        int[] result = obj.secondGreaterElement(nums);
        System.out.println(Arrays.toString(result)); // Output: [9, 6, 6, -1, -1]
    }
}