/*
LeetCode 1288 - Remove Covered Intervals
Approach: Sort intervals and iterate through them to count non-covered intervals.
Time Complexity: O(n log n) due to sorting
Space Complexity: O(1) excluding the space used by the sorting algorithm                        
*/

import java.util.*;

class LC1288_RemoveIntervals {
    public int removeCoveredIntervals(int[][] intervals) {
        int n = intervals.length;

        Arrays.sort(intervals, (a, b) -> {
            if (a[0] != b[0]) {
                return a[0] - b[0];
            }
            return b[1] - a[1];
        });

        int count = 1;
        int lastIntervalsEnd = intervals[0][1];

        for (int i = 1; i < n; i++) {
            if (intervals[i][1] <= lastIntervalsEnd) {
                continue;
            }
            lastIntervalsEnd = intervals[i][1];
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        LC1288_RemoveIntervals obj = new LC1288_RemoveIntervals();
        int[][] intervals = { { 1, 4 }, { 3, 6 }, { 2, 8 } };
        int res = obj.removeCoveredIntervals(intervals);
        System.out.println(res); // Output: 2
    }
}
