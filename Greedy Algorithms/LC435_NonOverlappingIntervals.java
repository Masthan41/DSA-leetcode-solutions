/*
LeetCode 435 - Non-overlapping Intervals
Approach: Greedy + Sorting by end time

Time Complexity: O(n log n)
Space Complexity: O(1)
*/

import java.util.Arrays;
import java.util.Comparator;

public class LC435_NonOverlappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));

        int c = 1;
        int end = intervals[0][1];

        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] >= end) {
                c++;
                end = intervals[i][1];
            }
        }
        return intervals.length - c;
    }
    public static void main(String[] args) {
        LC435_NonOverlappingIntervals s = new LC435_NonOverlappingIntervals();
        int[][] intervals = {{1,2}, {2,3}, {3,4}, {1,3}};
        System.out.println(s.eraseOverlapIntervals(intervals)); // 1
    }
}
