/*
LeetCode 347 - Top K Frequent Elements
Approach: Use a min-heap to keep track of the top k frequent elements.
Time Complexity: O(n log k)
Space Complexity: O(n)
*/

import java.util.*;

class LC347_TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        // count frequency
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        // Min heap based on frequency
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                (a, b) -> map.get(a) - map.get(b));
        for (int key : map.keySet()) {
            pq.add(key);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        // take out the result
        int res[] = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        LC347_TopKFrequentElements obj = new LC347_TopKFrequentElements();
        int nums[] = { 1, 1, 1, 2, 2, 3 };
        int k = 2;
        System.out.println(Arrays.toString(obj.topKFrequent(nums, k)));
    }
}
