/*
LeetCode 621 - Task Scheduler
Approach: Use a priority queue to schedule tasks based on their frequency. The most frequent tasks are scheduled first, and we keep track of the cooldown period using a cycle counter. If there are still tasks left after a cycle, we add the cooldown time to the total time.

Time Complexity: O(N log K) where N is the number of tasks and K is the number of unique tasks (at most 26 for uppercase letters).
Space Complexity: O(K) for the priority queue and temporary list.
*/

import java.util.*;

class LC621_TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int freq[] = new int[26];
        for (char ch : tasks) {
            freq[ch - 'A']++;
        }

        int time = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                pq.add(freq[i]);
            }
        }

        while (!pq.isEmpty()) {
            int cycle = n + 1;
            List<Integer> temp = new ArrayList<>();
            int count = 0;

            while (cycle-- > 0 && !pq.isEmpty()) {
                int curr = pq.remove();
                if (curr > 1) {
                    temp.add(curr - 1);
                }
                count++;

            }
            temp.forEach(pq::offer);

            time += pq.isEmpty() ? count : n + 1;
        }
        return time;
    }

    public static void main(String[] args) {
        LC621_TaskScheduler scheduler = new LC621_TaskScheduler();
        char[] tasks = { 'A', 'A', 'A', 'B', 'B', 'B' };
        int n = 2;
        int result = scheduler.leastInterval(tasks, n);
        System.out.println("Least Interval: " + result); // Output: 8
    }
}
