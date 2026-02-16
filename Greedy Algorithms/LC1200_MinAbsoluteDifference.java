/*
LeetCode 1200 - Minimum Absolute Difference
Approach: Sorting + Adjacent comparison

Time Complexity: O(n log n)
Space Complexity: O(1)
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC1200_MinAbsoluteDifference {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> res = new ArrayList<>();

        int abs_diff = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            int diff = arr[i] - arr[i - 1];
            abs_diff = Math.min(abs_diff, diff);
        }

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] == abs_diff) {
                res.add(Arrays.asList(arr[i - 1], arr[i]));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LC1200_MinAbsoluteDifference s = new LC1200_MinAbsoluteDifference();
        int[] arr = { 4, 2, 1, 3 };
        System.out.println(s.minimumAbsDifference(arr)); // [[1,2],[2,3],[3,4]]
    }
}
