/*
LeetCode 1167 - Connect Sticks
Approach: Use a min-heap to always connect the two shortest sticks.

Time Complexity: O(n log n)
Space Complexity: O(n)
*/

import java.util.*;

class LC1167_ConnectSticks {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : sticks) {
            pq.add(i);
        }
        int cost = 0;
        while (pq.size() > 1) {
            int min1 = pq.remove();
            int min2 = pq.remove();
            cost += min1 + min2;
            pq.add(min1 + min2);
        }
        return cost;
    }

    public static void main(String[] args) {
        LC1167_ConnectSticks stick = new LC1167_ConnectSticks();
        int sticks[] = { 2, 3, 3, 4, 6 };
        int result = stick.connectSticks(sticks);
        System.out.println("Cost of connecting sticks: " + result); // Output: 41
    }
}
