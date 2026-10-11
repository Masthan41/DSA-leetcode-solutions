/*
LeetCode 1046 - Last Stone Weight
Approach: Use a max-heap to keep track of the heaviest stones.
Time Complexity: O(n log n) as we are adding all the stones to the heap and removing them one by one.
Space Complexity: O(n) for the heap.
*/

import java.util.*;

class LC1046_LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        int n = stones.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            pq.add(stones[i]);
        }

        while (pq.size() > 1) {
            int first = pq.remove();
            int second = pq.remove();

            if (first != second) {
                pq.add(first - second);
            }
        }
        return pq.size() == 1 ? pq.peek() : 0;
    }

    public static void main(String[] a) {
        LC1046_LastStoneWeight obj = new LC1046_LastStoneWeight();
        int[] stones = { 2, 7, 4, 1, 8, 1 };
        System.out.println(obj.lastStoneWeight(stones));
    }
}