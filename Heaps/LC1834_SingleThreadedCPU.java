/*
LeetCode 1834 - Single Threaded CPU
Approach: Use a priority queue to simulate the CPU processing tasks based on their enqueue time and processing time. The tasks are sorted by enqueue time, and we maintain a current time to track when the CPU is available to process the next task. If the CPU is idle, we jump to the next task's enqueue time. We add all tasks that can be processed at the current time to the priority queue, which sorts them by processing time and index. The CPU processes the task with the shortest processing time first.

Time Complexity: O(n log n) for sorting the tasks and O(n log k) for processing the tasks using the priority queue, where n is the number of tasks and k is the number of tasks in the priority queue at any time.
Space Complexity: O(n) for storing the tasks and the priority queue.
*/

import java.util.*;

class LC1834_SingleThreadedCPU {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;

        int list[][] = new int[n][3];
        for (int i = 0; i < n; i++) {
            list[i] = (new int[] { tasks[i][0], tasks[i][1], i });
        }
        Arrays.sort(list, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[2], b[2]);
        });

        int res[] = new int[n];
        int resIdx = 0;

        long curr = 0;
        int idx = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        while (idx < n || !pq.isEmpty()) {

            if (pq.isEmpty() && curr < list[idx][0]) {
                curr = list[idx][0];
            }

            while (idx < n && list[idx][0] <= curr) {
                pq.add(new int[] { list[idx][1], list[idx][2] });
                idx++;
            }

            int arr[] = pq.remove();

            curr += arr[0];
            res[resIdx++] = arr[1];
        }
        return res;
    }

    public static void main(String[] args) {
        LC1834_SingleThreadedCPU sol = new LC1834_SingleThreadedCPU();

        // Test 1: Single task
        System.out.println(Arrays.toString(sol.getOrder(new int[][] { { 1, 2 } })));
        // Expected: [0]

        // Test 2: Two tasks with different enqueue times
        System.out.println(Arrays.toString(sol.getOrder(new int[][] { { 1, 2 }, { 2, 4 } })));
        // Expected: [0, 1]

        // Test 3: Two tasks with same enqueue time but different processing times
        System.out.println(Arrays.toString(sol.getOrder(new int[][] { { 1, 2 }, { 1, 1 } })));
        // Expected: [1, 0]

        // Test 4: Multiple tasks with varying enqueue and processing times
        System.out.println(Arrays.toString(sol.getOrder(new int[][] { { 1, 2 }, { 2, 4 }, { 3, 2 }, { 4, 1 } })));
        // Expected: [0, 2, 3, 1]
    }
}
