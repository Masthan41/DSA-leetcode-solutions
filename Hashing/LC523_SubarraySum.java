/*
LeetCode 523 - Continuous Subarray Sum
Approach: Use a hash map to store the first occurrence of each cumulative sum modulo k. For each element, calculate the cumulative sum and its remainder when divided by k. If the same remainder has been seen before, check if the subarray length is at least 2.
Time Complexity: O(n) where n is the length of the input array, since we are iterating through the array once.
Space Complexity: O(min(n, k)) for storing the remainders in the hash map, where n is the length of the input array and k is the divisor.
*/

import java.util.*;

class LC523_SubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int rem = sum % k;
            if (map.containsKey(rem)) {
                if (i - map.get(rem) >= 2) {
                    return true;
                }
            } else {
                map.put(rem, i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LC523_SubarraySum solution = new LC523_SubarraySum();
        int[] nums = { 23, 2, 4, 6, 7 };
        int k = 6;
        boolean result = solution.checkSubarraySum(nums, k);
        System.out.println(result); // Output: true
    }
}
