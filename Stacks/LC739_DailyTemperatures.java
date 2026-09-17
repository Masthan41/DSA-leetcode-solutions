/*
LeetCode 739 - Daily Temperatures
Approach: Use a Stack to find the next greater element and subtract it from current index
Time complexity: O(n) as each element is pushed and popped from the stack at most once.
Space complexity: O(n) as we are using a stack.
*/

import java.util.*;

public class LC739_DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Stack<Integer> s = new Stack<>();

        for (int i = temperatures.length - 1; i >= 0; i--) {

            while (!s.isEmpty() && temperatures[s.peek()] <= temperatures[i]) {
                s.pop();
            }

            if (s.isEmpty()) {
                ans[i] = 0;
            } else {
                ans[i] = s.peek() - i;
            }

            s.push(i);
        }
        return ans;
    }
    public static void main(String[] args) {
        LC739_DailyTemperatures solution = new LC739_DailyTemperatures();
        int[] temperatures = { 73, 74, 75, 71, 69, 72, 76, 73 };
        int[] result = solution.dailyTemperatures(temperatures);
        System.out.print("Days until warmer temperature: ");
        for (int days : result) {
            System.out.print(days + " ");
        }
        // Days until warmer temperature: 1 1 4 2 1 1 0 0
    }
}
