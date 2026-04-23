/*
LeetCode 2615 - Sum of Distances
Approach: To find the sum of distances for each element, we can iterate through the array twice - once from left to right and once from right to left - keeping track of the cumulative sum and count of each element.

Time Complexity: O(n) where n is the length of the nums array.
Space Complexity: O(n) for the HashMaps.
*/

import java.util.*;

class LC2615_SumofDistances {
    public long[] distance(int[] nums) {
        int n = nums.length;
        long[] arr = new long[n];

        Map<Integer, Long> indexSum = new HashMap<>();
        Map<Integer, Long> indexCount = new HashMap<>();

        // Left to Right
        for (int i = 0; i < n; i++) {
            long freq = indexCount.getOrDefault(nums[i], 0L);
            long sum = indexSum.getOrDefault(nums[i], 0L);

            arr[i] += freq * i - sum;

            indexCount.put(nums[i], freq + 1);
            indexSum.put(nums[i], sum + i);
        }

        indexSum.clear();
        indexCount.clear();

        // Right to Left
        for (int i = n - 1; i >= 0; i--) {
            long freq = indexCount.getOrDefault(nums[i], 0L);
            long sum = indexSum.getOrDefault(nums[i], 0L);

            arr[i] += sum - freq * i;

            indexCount.put(nums[i], freq + 1);
            indexSum.put(nums[i], sum + i);
        }

        return arr;
    }

    public static void main(String[] args) {
        LC2615_SumofDistances obj = new LC2615_SumofDistances();
        int[] nums = { 1, 3, 1, 1, 2 };
        long[] result = obj.distance(nums);
        for (long res : result) {
            System.out.print(res + " ");
        }
    }
}
