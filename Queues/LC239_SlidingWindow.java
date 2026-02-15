/*
Leetcode 239: Sliding Window Maximum
Approach: Deque to store indices of elements in the current window, ensuring the maximum is always at the front

Time Complexity: O(n) - each element is added and removed at most once
Space Complexity: O(k) - the deque can hold at most k indices
*/

import java.util.*;

public class LC239_SlidingWindow {
     public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new LinkedList<>();

        int[] res = new int[nums.length - k + 1];
        int ri = 0;

        for (int i = 0; i < nums.length; i++) {

            //remove indices
            if (!dq.isEmpty() && dq.peekFirst() == i - k) {
                dq.removeFirst();
            }

            //remove small elements
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.removeLast();
            }
            dq.addLast(i);

            //Add to result array
            if (i >= k - 1) {
                res[ri++] = nums[dq.peekFirst()];
            }
        }
        return res;
    }
    public static void main(String[] args) {
        LC239_SlidingWindow s = new LC239_SlidingWindow();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        System.out.println(Arrays.toString(s.maxSlidingWindow(nums, k))); // [3, 3, 5, 5, 6, 7]
    }
}
