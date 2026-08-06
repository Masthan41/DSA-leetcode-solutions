/*
LeetCode 325 - Max Subarray size with sum k
Approach: Use a hash map to store the first occurrence of each cumulative sum. For each element, check if (current cumulative sum - k) exists in the map. If it does, update the maximum length of the subarray. This works because if two cumulative sums differ by k, the subarray between them has a sum of k.
Time Complexity: O(n) where n is the length of the array
Space Complexity: O(n) for the hash map
*/

import java.util.*;

class LC325_MaxSubarraySize {
    public int maxSubArrayLen(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int ans = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (map.containsKey(sum - k)) {
                ans = Math.max(ans, i - map.get(sum - k));
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LC325_MaxSubarraySize sol = new LC325_MaxSubarraySize();

        int[] nums = { 1, -1, 5, -2, 3 };
        int k = 3;

        System.out.println(sol.maxSubArrayLen(nums, k)); // Expected: 4
    }

}
