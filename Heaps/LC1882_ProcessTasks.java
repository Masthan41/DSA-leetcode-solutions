/*
LeetCode 1882 - Process Tasks Using Servers
Approach: Use two priority queues to manage free and busy servers. The free servers are stored in a priority queue sorted by weight and index, while the busy servers are stored in a priority queue sorted by the time they will become free, weight, and index. For each task, we check if any busy servers have become free and move them to the free servers queue. If there are free servers available, we assign the task to the server with the smallest weight (and index in case of ties). If no free servers are available, we wait for the next busy server to become free and assign the task to it.

Time Complexity: O(n log n) for processing the tasks using the priority queues, where n is the number of tasks.
Space Complexity: O(n) for storing the servers and the priority queues.
*/

import java.util.PriorityQueue;

class LC1882_ProcessTasks {
    public int[] assignTasks(int[] servers, int[] tasks) {
        int n = servers.length;
        int m = tasks.length;

        // free servers: {wt, idx}, smallest (wt, idx) first
        PriorityQueue<int[]> freeServers = new PriorityQueue<>(
                (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));

        PriorityQueue<long[]> busyServers = new PriorityQueue<>(
                (a, b) -> {
                    if (a[0] != b[0])
                        return Long.compare(a[0], b[0]);
                    if (a[1] != b[1])
                        return Long.compare(a[1], b[1]);
                    return Long.compare(a[2], b[2]);
                });

        for (int i = 0; i < n; i++) {
            freeServers.add(new int[] { servers[i], i });
        }

        int[] result = new int[m];

        for (int i = 0; i < m; i++) {
            while (!busyServers.isEmpty() && busyServers.peek()[0] <= i) {
                long[] cur = busyServers.poll();
                freeServers.add(new int[] { (int) cur[1], (int) cur[2] });
            }

            if (freeServers.isEmpty()) {
                long[] cur = busyServers.poll();
                result[i] = (int) cur[2];
                busyServers.add(new long[] { cur[0] + tasks[i], cur[1], cur[2] });
            } else {
                int[] cur = freeServers.poll();
                result[i] = cur[1];
                busyServers.add(new long[] { (long) i + tasks[i], cur[0], cur[1] });
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LC1882_ProcessTasks solution = new LC1882_ProcessTasks();
        int[] servers = { 3, 3, 2 };
        int[] tasks = { 1, 2, 3, 2, 1, 2 };
        int[] result = solution.assignTasks(servers, tasks);
        for (int server : result) {
            System.out.print(server + " ");
        }
    }
}
