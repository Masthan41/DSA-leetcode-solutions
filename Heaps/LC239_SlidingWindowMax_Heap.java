/*
LeetCode 239 - Sliding Window Maximum
Approach: Use a max-heap to keep track of the maximum element in the current window.
Time Complexity: O(n log k)
Space Complexity: O(n)
*/

//This version is also avaoilable in LC239_SlidingWindowMax_Deque.java using a deque which is more optimal with O(n) time complexity.

import java.util.*;

class LC239_SlidingWindowMax_Heap {
    static class Pair {
        int val;
        int idx;

        Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int res[] = new int[nums.length - k + 1];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> b.val - a.val);

        for (int i = 0; i < nums.length; i++) {
            // insert current element
            pq.offer(new Pair(nums[i], i));

            // remove elements
            while (!pq.isEmpty() && pq.peek().idx <= i - k) {
                pq.poll();
            }

            // store result
            if (i >= k - 1) {
                res[i - k + 1] = pq.peek().val;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LC239_SlidingWindowMax_Heap obj = new LC239_SlidingWindowMax_Heap();
        int nums[] = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;
        int res[] = obj.maxSlidingWindow(nums, k);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }
}
