/*
LeetCode 239 - Sliding Window Maximum
Approach: Use a deque to maintain indices of potential maximum elements in the current window.
Time Complexity: O(n) where n is the number of elements in the array.
Space Complexity: O(k) for the deque.
*/

import java.util.*;

class LC239_SlidingWindowMax {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int res[] = new int[nums.length - k + 1];
        int idx = 0;
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {
            if (!dq.isEmpty() && dq.peekFirst() == i - k) {
                dq.removeFirst();
            }

            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.removeLast();
            }
            dq.addLast(i);

            if (i >= k - 1) {
                res[idx] = nums[dq.peekFirst()];
                idx++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LC239_SlidingWindowMax solution = new LC239_SlidingWindowMax();
        int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;
        int[] result = solution.maxSlidingWindow(nums, k);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
