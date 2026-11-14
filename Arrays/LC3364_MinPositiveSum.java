/*
LeetCode 3364 - Minimum Positive Sum Subarray
Approach: Use a nested loop to iterate through all possible subarrays of the input list. For each subarray, calculate the sum and check if its length is within the specified bounds (l and r) and if the sum is positive. If both conditions are met, update the minimum sum found so far. Finally, return the minimum positive sum found or -1 if no such subarray exists.

Time Complexity: O(n^2) as we use a nested loop to consider all possible subarrays, where n is the number of elements in the input list.
Space Complexity: O(1) as we use a constant amount of extra space for variables to track the sum and minimum sum.
*/

//optimized solution will be posted soon

import java.util.*;

class LC3364_MinPositiveSum {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();
        int minSum = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums.get(j);
                int len = j - i + 1;

                if (len >= l && len <= r && sum > 0) {
                    minSum = Math.min(minSum, sum);
                }
            }
        }
        return minSum == Integer.MAX_VALUE ? -1 : minSum;
    }

    public static void main(String[] args) {
        LC3364_MinPositiveSum solution = new LC3364_MinPositiveSum();
        List<Integer> nums = List.of(-1, 2, -3, 4, -2);
        int l = 2;
        int r = 3;
        int result = solution.minimumSumSubarray(nums, l, r);
        System.out.println(result); // Output: 1
    }
}
