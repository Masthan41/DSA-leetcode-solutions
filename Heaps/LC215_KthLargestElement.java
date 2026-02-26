/*
LeetCode 215 - Kth Largest Element in an Array
Approach: Use a min-heap of size k to keep track of the k largest elements.
Time Complexity: O(n log k)
Space Complexity: O(k)
*/

import java.util.*;

class LC215_KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i : nums) {
            pq.add(i);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        LC215_KthLargestElement obj = new LC215_KthLargestElement();
        int[] nums = { 3, 2, 1, 5, 6, 4 };
        int k = 2;
        System.out.println(obj.findKthLargest(nums, k)); // Output: 5
    }
}
