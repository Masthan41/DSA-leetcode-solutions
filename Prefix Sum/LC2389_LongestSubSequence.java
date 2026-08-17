/*
LeetCode 2389 - Longest Subsequence With Limited Sum
Approach: Sort the array and use prefix sums. For each query, use binary
search to find the largest prefix with sum <= query.

Time Complexity: O(n log n + m log n) - sorting and binary search for queries.
Space Complexity: O(n) - for the prefix sum array.
*/

import java.util.*;

class LC2389_LongestSubSequence {
    public int binarySearch(int arr[], int tar) {
        int low = 0, high = arr.length - 1;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] <= tar) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    public int[] answerQueries(int[] nums, int[] queries) {
        int n = nums.length;
        int m = queries.length;
        int res[] = new int[m];
        Arrays.sort(nums);

        // cumilative sum
        for (int i = 1; i < n; i++) {
            nums[i] += nums[i - 1];
        }

        // binary search
        for (int q = 0; q < m; q++) {
            int idx = binarySearch(nums, queries[q]);
            res[q] = idx + 1;
        }
        return res;
    }
}
