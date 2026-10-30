/*
LeetCode 1353 - Maximum Number of Events That Can Be Attended
Approach: Sort the events by start day and use a min-heap to keep track of the end days of events that can be attended. if the current day is less than the end day of the event, we can attend it and remove it from the heap. If the current day is greater than the end day of the event, we remove it from the heap as we cannot attend it anymore.

Time Complexity: O(n log n) for sorting the events and O(n log n) for processing the events, where n is the number of events.
Space Complexity: O(n) for the priority queue that stores the end days of events.
*/

import java.util.*;

class LC1353_MaxEvents {
    public int maxEvents(int[][] events) {
        int n = events.length;
        Arrays.sort(events, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int days = events[0][0];
        int count = 0;
        int i = 0;

        while (!pq.isEmpty() || i < n) {
            while (i < n && events[i][0] == days) {
                pq.add(events[i][1]);
                i++;
            }

            if (!pq.isEmpty()) {
                pq.remove();
                count++;
            }
            days++;

            while (!pq.isEmpty() && pq.peek() < days) {
                pq.remove();
            }
        }
        return count;
    }

    public static void main(String[] args) {
        LC1353_MaxEvents solution = new LC1353_MaxEvents();
        int[][] events = { { 1, 2 }, { 2, 3 }, { 3, 4 } };
        int result = solution.maxEvents(events);
        System.out.println("Maximum number of events that can be attended: " + result);
    }
}