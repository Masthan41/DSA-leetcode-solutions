/*
LeetCode 1673 - Find the Most Competitive Subsequence
Approach: Use a stack to maintain the most competitive subsequence. For each number, we pop from the stack if the current number is smaller than the top of the stack and if we can still form a subsequence of length k with the remaining numbers.
Time complexity: O(n) because each element is pushed and popped from the stack at most once.
Space complexity: O(k) because the stack will hold at most k elements.
*/

import java.util.*;

class LC1673_FindSubsequence {
    public int[] mostCompetitive(int[] nums, int k) {
        int n = nums.length;
        if (k == n) {
            return nums;
        }

        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && s.peek() > nums[i] && n - i - 1 >= k - s.size()) {
                s.pop();
            }
            if (s.size() < k) {
                s.push(nums[i]);
            }
        }

        int ans[] = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            ans[i] = s.pop();
        }

        return ans;
    }

    public static void main(String[] args) {
        LC1673_FindSubsequence obj = new LC1673_FindSubsequence();
        int nums[] = { 3, 5, 2, 6 };
        int k = 2;
        int result[] = obj.mostCompetitive(nums, k);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
