/*
LeetCode 347 - Top K Frequent Elements
Approach: Use a min-heap to keep track of the top k frequent elements.
Time Complexity: O(n log k)
Space Complexity: O(n)
*/

import java.util.*;

class LC347_TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.add(new int[] { entry.getKey(), entry.getValue() });

            if (pq.size() > k) {
                pq.remove();
            }
        }

        int ans[] = new int[k];
        for (int i = 0; i < k; i++) {
            int curr[] = pq.remove();
            ans[i] = curr[0];
        }
        return ans;
    }

    public static void main(String[] args) {
        LC347_TopKFrequentElements obj = new LC347_TopKFrequentElements();
        int nums[] = { 1, 1, 1, 2, 2, 3 };
        int k = 2;
        System.out.println(Arrays.toString(obj.topKFrequent(nums, k)));
    }
}
