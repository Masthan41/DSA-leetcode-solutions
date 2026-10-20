/*
LeetCode 2913 - Distinct Subarrays elements sum of squares I
Approach: Use a nested loop to iterate through all possible subarrays of the input list. For each subarray, use a HashSet to keep track of distinct elements. Calculate the size of the HashSet (which represents the number of distinct elements) and add its square to a running total. Return the total sum after processing all subarrays.
Time Complexity: O(n^2) where n is the length of the input list, since we are using a nested loop to generate all subarrays.
Space Complexity: O(n) for the HashSet used to track distinct elements in each subarray.
*/

import java.util.*;

class LC2913_DistinctSubarraysI {
    public int sumCounts(List<Integer> nums) {
        int n = nums.size();
        int sub = 0;

        for (int i = 0; i < n; i++) {
            HashSet<Integer> set = new HashSet<>();
            for (int j = i; j < n; j++) {
                set.add(nums.get(j));
                sub += set.size() * set.size();
            }

        }
        return sub;
    }

    public static void main(String[] args) {
        LC2913_DistinctSubarraysI obj = new LC2913_DistinctSubarraysI();
        List<Integer> nums = List.of(1, 2, 3);
        System.out.println(obj.sumCounts(nums));
    }
}
