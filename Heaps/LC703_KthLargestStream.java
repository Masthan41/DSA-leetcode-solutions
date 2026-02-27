/*
LeetCode 703 - Kth Largest Element in a Stream
Approach: Use a min-heap to keep track of the k largest elements.
Time Complexity: O(n log k)
Space Complexity: O(k)
*/

import java.util.PriorityQueue;

class LC703_KthLargestStream {
    private PriorityQueue<Integer> minHeap;
    private int k;

    public LC703_KthLargestStream(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>();

        for (int i : nums) {
            add(i);
        }
    }

    public int add(int val) {
        minHeap.offer(val);

        if (minHeap.size() > k) {
            minHeap.poll();
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        LC703_KthLargestStream obj = new LC703_KthLargestStream(3, new int[] { 4, 5, 8, 2 });
        System.out.println(obj.add(3)); // returns 4
        System.out.println(obj.add(5)); // returns 5
        System.out.println(obj.add(10)); // returns 5
        System.out.println(obj.add(9)); // returns 8
        System.out.println(obj.add(4)); // returns 8
    }
}
