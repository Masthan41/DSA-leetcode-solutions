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
        
        //Test 1: Single stone
        System.out.println(obj.lastStoneWeight(new int[]{5}));
        // Expected: 5

        //Test 2: Two stones of equal weight
        System.out.println(obj.lastStoneWeight(new int[]{7, 7}));
        // Expected: 0

        //Test 3: Two stones of different weights
        System.out.println(obj.lastStoneWeight(new int[]{7, 3}));
        // Expected: 4

        //Test 4: Multiple stones
        System.out.println(obj.lastStoneWeight(new int[]{2, 7, 4, 1, 8, 1}));
        // Expected: 1

        //Test 5: All stones of equal weight
        System.out.println(obj.lastStoneWeight(new int[]{3, 3, 3, 3}));
        // Expected: 0

        //Test 6: Stones with zero weight
        System.out.println(obj.lastStoneWeight(new int[]{0, 2, 3}));
        // Expected: 1
    }
}