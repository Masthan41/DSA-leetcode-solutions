/*
LeetCode 295 - Find Median from Data Stream
Approach: Use two heaps to maintain the median of a data stream. One heap stores the smaller half of the numbers, and the other stores the larger half. The median is either the top of the larger heap or the average of the tops of both heaps.

Time Complexity: O(log n) for each add operation.
Space Complexity: O(n) for storing all elements.
*/

import java.util.*;

class LC295_FindMedian {
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;

    public LC295_FindMedian() {
        left = new PriorityQueue<>(Collections.reverseOrder());
        right = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (left.isEmpty() || num < left.peek()) {
            left.add(num);
        } else {
            right.add(num);
        }

        // maintain sizes of heaps
        // either both equal or left has only one element extra
        if (left.size() - right.size() > 1) {
            right.add(left.remove());
        } else if (left.size() < right.size()) {
            left.add(right.remove());
        }
    }

    public double findMedian() {
        return (double) (left.size() == right.size() ? ((left.peek() + right.peek()) / 2.0) : left.peek());
    }

    public static void main(String[] args) {
        LC295_FindMedian medianFinder = new LC295_FindMedian();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println("Median: " + medianFinder.findMedian()); // Output: 1.5
        medianFinder.addNum(3);
        System.out.println("Median: " + medianFinder.findMedian()); // Output: 2.0
    }
}
