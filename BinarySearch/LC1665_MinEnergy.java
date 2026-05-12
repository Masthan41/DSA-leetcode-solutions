/*
LeetCode 1665 - Minimum Initial Energy to Finish Tasks
Approach: Binary Search + Greedy approach
Time Complexity: O(n log n) due to sorting and binary search
Space Complexity: O(n) for sorting the tasks array
*/

import java.util.*;

class LC1665_MinEnergy {
    public boolean isPossible(int[][] tasks, int mid) {

        for (int task[] : tasks) {
            int actual = task[0];
            int minimum = task[1];

            if (minimum > mid) {
                return false;
            }

            mid -= actual;
        }

        return true;
    }

    public int minimumEffort(int[][] tasks) {
        int l = 0;
        int r = (int) 1e9;

        int result = Integer.MAX_VALUE;

        Arrays.sort(tasks, (task1, task2) -> {
            int diff1 = task1[1] - task1[0];
            int diff2 = task2[1] - task2[0];

            return diff2 - diff1;
        });

        // binary search
        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (isPossible(tasks, mid)) {
                result = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LC1665_MinEnergy obj = new LC1665_MinEnergy();
        int[][] tasks = { { 1, 2 }, { 2, 4 }, { 4, 8 } };
        System.out.println(obj.minimumEffort(tasks));
    }
}