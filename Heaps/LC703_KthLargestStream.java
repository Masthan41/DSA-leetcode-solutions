/*
LeetCode 703 - Kth Largest Element in a Stream
Approach: Use a min-heap to keep track of the k largest elements.
Time Complexity: O(n log k) as we may need to add n elements to the heap, and each insertion takes O(log k) time.
Space Complexity: O(k) as we are storing at most k elements in the heap.
*/

import java.util.PriorityQueue;

class LC703_KthLargestStream {
    private PriorityQueue<Integer> minHeap;
    private int k;

    public LC703_KthLargestStream(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>();

        for (int i : nums) {
            minHeap.add(i);
        }
    }

    public int add(int val) {
        minHeap.add(val);

        if (minHeap.size() > k) {
            minHeap.remove();
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
