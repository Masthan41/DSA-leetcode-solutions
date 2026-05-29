/*
LeetCode 2461 - Maximum Subarray Sum with Exactly K Distinct Elements
Approach: Use a sliding window technique to maintain a window of size k with all distinct elements, and keep track of the maximum sum encountered.
Time Complexity: O(n) where n is the length of the nums array.
Space Complexity: O(k) for the HashMap storing at most k elements.
*/

import java.util.*;

class LC2461_MaxSumWithK {
    public long maximumSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        long sum = 0, ans = 0;
        int left = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

            if (i - left + 1 > k) {
                sum -= nums[left];

                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }

            if (i - left + 1 == k && map.size() == k) {
                ans = Math.max(ans, sum);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LC2461_MaxSumWithK obj = new LC2461_MaxSumWithK();
        int[] nums = { 1, 2, 3, 4, 5 };
        int k = 3;
        long res = obj.maximumSubarraySum(nums, k);
        System.out.println(res);
    }
}
