/*
LeetCode 560 - Subarray Sum Equals K
Approach: Use HashMap to store prefix sums and their frequencies
Time Complexity: O(n) where n is the length of the array
Space Complexity: O(n) for the HashMap
*/

import java.util.*;

class LC560_SubarraySum {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, len = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                len += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return len;
    }

    public static void main(String[] args) {
        LC560_SubarraySum solution = new LC560_SubarraySum();
        int[] nums = { 1, 1, 1 };
        int k = 2;
        int result = solution.subarraySum(nums, k);
        System.out.println(result); // Output: 2
    }
}
