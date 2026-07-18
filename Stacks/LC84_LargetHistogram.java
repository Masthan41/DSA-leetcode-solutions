/*
LeetCode 84 - Largest Rectangle in Histogram
Approach: Using Stack to find left and right smaller elements. Calculate area for each bar and return the maximum area.
Time complexity: O(n) as each element is pushed and popped from the stack at most once.
Space complexity: O(n) as we are using two additional arrays to store the left and right smaller elements for each bar.
*/

import java.util.*;

class LC84_LargetHistogram {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int left[] = new int[n];
        int right[] = new int[n];
        Stack<Integer> s = new Stack<>();

        // Left smaller element
        for (int i = 0; i < n; i++) {
            while (s.size() > 0 && heights[s.peek()] >= heights[i]) {
                s.pop();
            }
            left[i] = s.isEmpty() ? -1 : s.peek();
            s.push(i);
        }

        while (!s.isEmpty()) {
            s.pop();
        }

        // Right smaller element
        for (int i = n - 1; i >= 0; i--) {
            while (s.size() > 0 && heights[s.peek()] >= heights[i]) {
                s.pop();
            }
            right[i] = s.isEmpty() ? n : s.peek();
            s.push(i);
        }

        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int width = right[i] - left[i] - 1;
            int area = width * heights[i];
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }

    public static void main(String[] args) {
        LC84_LargetHistogram obj = new LC84_LargetHistogram();
        int[] heights = { 2, 1, 5, 6, 2, 3 };
        System.out.println(obj.largestRectangleArea(heights)); // Output: 10
    }
}
