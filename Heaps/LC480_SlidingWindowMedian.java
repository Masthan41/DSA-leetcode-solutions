/*
LeetCode 480 - Sliding Window Median
Approach: Use two heaps (max heap for smaller half, min heap for larger half) to maintain median efficiently.
Time Complexity: O(n log k)
Space Complexity: O(k)
*/

import java.util.*;

class LC480_SlidingWindowMedian {
    PriorityQueue<Integer> small = new PriorityQueue<>(Collections.reverseOrder()); // max heap
    PriorityQueue<Integer> large = new PriorityQueue<>(); // min heap

    Map<Integer, Integer> delayed = new HashMap<>();
    int smallSize = 0, largeSize = 0;
    int k;

    public double[] medianSlidingWindow(int[] nums, int k) {
        this.k = k;
        double res[] = new double[nums.length - k + 1];

        for (int i = 0; i < k; i++) {
            add(nums[i]);
        }
        res[0] = getMedian();

        for (int i = k; i < nums.length; i++) {
            add(nums[i]);
            remove(nums[i - k]);
            res[i - k + 1] = getMedian();
        }
        return res;
    }

    private void add(int num) {
        if (small.isEmpty() || num <= small.peek()) {
            small.offer(num);
            smallSize++;
        } else {
            large.offer(num);
            largeSize++;
        }
        rebalance();
    }

    private void remove(int num) {
        delayed.put(num, delayed.getOrDefault(num, 0) + 1);

        if (num <= small.peek()) {
            smallSize--;
            if (num == small.peek())
                prune(small);
        } else {
            largeSize--;
            if (num == large.peek())
                prune(large);
        }
        rebalance();
    }

    private void rebalance() {
        if (smallSize > largeSize + 1) {
            large.offer(small.poll());
            smallSize--;
            largeSize++;
            prune(small);
        } else if (smallSize < largeSize) {
            small.offer(large.poll());
            largeSize--;
            smallSize++;
            prune(large);
        }
    }

    private void prune(PriorityQueue<Integer> heap) {
        while (!heap.isEmpty()) {
            int num = heap.peek();
            if (delayed.containsKey(num)) {
                delayed.put(num, delayed.get(num) - 1);
                if (delayed.get(num) == 0) {
                    delayed.remove(num);
                }
                heap.poll();
            } else
                break;
        }
    }

    private double getMedian() {
        if (k % 2 == 1) {
            return small.peek();
        } else {
            return ((double) small.peek() + large.peek()) / 2.0;
        }
    }

    public static void main(String[] args) {
        LC480_SlidingWindowMedian obj = new LC480_SlidingWindowMedian();
        int[] nums = { 1, 3, -1, -3, 5, 3, 6, 7 };
        int k = 3;
        double[] res = obj.medianSlidingWindow(nums, k);
        System.out.println(Arrays.toString(res));
    }
}
