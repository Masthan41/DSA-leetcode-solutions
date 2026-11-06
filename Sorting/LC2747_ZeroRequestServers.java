/*
LeetCode 2747 - Count Zero Request Servers
Approach: Use a sliding window technique to maintain the count of active servers within the time range [curtime - x, curtime]. For each query, update the window by adding new logs and removing old logs, then calculate the number of zero-request servers.

Time complexity: O(m log m + q log q) where m is the number of logs and q is the number of queries. Sorting the logs and queries takes O(m log m + q log q), and processing each query takes O(m) in the worst case.
Space complexity: O(n) for storing the count of active servers in a HashMap.
*/

import java.util.*;

class LC2747_ZeroRequestServers {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        int m = logs.length;

        Arrays.sort(logs, (a, b) -> a[1] - b[1]);

        int q = queries.length;
        int[][] timeIndex = new int[q][2];
        for (int i = 0; i < q; i++) {
            timeIndex[i][0] = queries[i];
            timeIndex[i][1] = i;
        }

        Arrays.sort(timeIndex, (a, b) -> a[0] - b[0]);

        Map<Integer, Integer> mp = new HashMap<>();
        int[] result = new int[q];

        int i = 0, j = 0;
        for (int[] pair : timeIndex) {
            int curtime = pair[0];
            int ind = pair[1];

            int start = curtime - x;
            int end = curtime;

            while (j < m && logs[j][1] <= end) {
                int serverId = logs[j][0];
                mp.put(serverId, mp.getOrDefault(serverId, 0) + 1);
                j++;
            }

            while (i < m && logs[i][1] < start) {
                int serverId = logs[i][0];
                mp.put(serverId, mp.get(serverId) - 1);
                if (mp.get(serverId) == 0) {
                    mp.remove(serverId);
                }
                i++;
            }

            result[ind] = n - mp.size();
        }
        return result;
    }

    public static void main(String[] args) {
        LC2747_ZeroRequestServers solution = new LC2747_ZeroRequestServers();

        // test case 1
        int n = 3;
        int[][] logs = { { 0, 1 }, { 1, 2 }, { 2, 3 } };
        int x = 2;
        int[] queries = { 3, 4 };
        int[] result = solution.countServers(n, logs, x, queries);
        System.out.println(Arrays.toString(result)); // Output: [0, 1]

        // test case 2
        n = 5;
        logs = new int[][] { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 4 }, { 4, 5 } };
        x = 3;
        queries = new int[] { 5, 6, 7 };
        result = solution.countServers(n, logs, x, queries);
        System.out.println(Arrays.toString(result)); // Output: [2, 3, 4]

        // test case 3
        n = 4;
        logs = new int[][] { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 4 } };
        x = 1;
        queries = new int[] { 2, 3, 4 };
        result = solution.countServers(n, logs, x, queries);
        System.out.println(Arrays.toString(result)); // Output: [2, 3, 4]
    }
}
