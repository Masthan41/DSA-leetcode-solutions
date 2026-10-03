/*
LeetCode 1944 - Visible People in a Queue
Approach: Using a stack to keep track of the heights of people in the queue. iterate from the end of the array to the beginning, for each person, pop all shorter people from the stack and count them as visible. If there is still a taller person in the stack, count them as visible too. Finally, push the current person's height onto the stack.

Time complexity: O(n) as we are iterating through the array once and each person is pushed and popped from the stack at most once.
Space complexity: O(n) as we are using a stack to keep track of the heights of people in the queue.
*/

import java.util.Stack;

class LC1944_VisiblePeople {
    public int[] canSeePersonsCount(int[] heights) {
        int n = heights.length;
        int ans[] = new int[n];

        Stack<Integer> s = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            int visible = 0;
            while (!s.isEmpty() && s.peek() < heights[i]) {
                visible++;
                s.pop();
            }
            if (!s.isEmpty()) {
                visible++;
            }
            ans[i] = visible;
            s.push(heights[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        LC1944_VisiblePeople sol = new LC1944_VisiblePeople();
        int[] heights = { 10, 6, 8, 5, 11, 9 };
        int[] result = sol.canSeePersonsCount(heights);
        for (int count : result) {
            System.out.print(count + " ");
        }
    }
}
