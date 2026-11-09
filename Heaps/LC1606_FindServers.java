/*
LeetCode 1606 - Find Servers That Handled Most Number of Requests
Approach: We use a TreeSet to keep track of available servers and a priority queue to keep track of busy servers. For each request, we first check if any busy servers have become available by comparing the current time with the end time of the requests in the priority queue. If a server is available, we assign the request to it and update its end time in the priority queue. We also keep track of the number of requests handled by each server and return the servers that handled the maximum number of requests.

Time Complexity: O(n log k) for processing the requests, where n is the number of requests and k is the number of servers. The log k factor comes from the operations on the TreeSet and priority queue.
Space Complexity: O(k) for the TreeSet and priority queue that store the available and busy servers, respectively.
*/

import java.util.*;

class LC1606_FindServers {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        TreeSet<Integer> availableServers = new TreeSet<>();
        for (int i = 0; i < k; i++) {
            availableServers.add(i); // k * log(k)
        }

        PriorityQueue<int[]> busyServers = new PriorityQueue<>(
                (a, b) -> a[0] != b[0] ? Integer.compare(a[0], b[0])
                        : Integer.compare(a[1], b[1]));

        int[] countRequests = new int[k];

        for (int i = 0; i < arrival.length; i++) {
            int time = arrival[i];

            while (!busyServers.isEmpty() && busyServers.peek()[0] <= time) {
                int server = busyServers.poll()[1];
                availableServers.add(server);
            }

            if (availableServers.isEmpty()) {
                continue;
            }

            int target = i % k;

            Integer targetServer = availableServers.ceiling(target);

            if (targetServer == null) {
                targetServer = availableServers.first();
            }

            availableServers.remove(targetServer);

            busyServers.offer(new int[] { time + load[i], targetServer });

            countRequests[targetServer]++;
        }

        int maxNumberOfRequests = 0;
        for (int c : countRequests) {
            maxNumberOfRequests = Math.max(maxNumberOfRequests, c);
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (countRequests[i] == maxNumberOfRequests) {
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LC1606_FindServers solution = new LC1606_FindServers();
        int k = 3;
        int[] arrival = { 1, 2, 3, 4, 5 };
        int[] load = { 5, 2, 3, 3, 3 };
        List<Integer> busiestServers = solution.busiestServers(k, arrival, load);
        System.out.println(busiestServers); // Output: [1]
    }
}
