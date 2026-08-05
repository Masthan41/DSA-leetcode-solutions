/*
LeetCode 974 - Subarray Sums Divisible by K
Approach: Use a hash map to store the frequency of each remainder when the cumulative sum is divided by K. Two subarrays have sums divisible by K if they have the same remainder.
Time Complexity: O(n) where n is the length of the array
Space Complexity: O(min(n, k)) for the hash map
*/

import java.util.*;

class LC974_SubarraySums {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int result = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            int rem = sum % k;
            if (rem < 0) {
                rem += k;
            }
            if (map.containsKey(rem)) {
                result += map.get(rem);
            }
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }
        return result;
    }

    public static void main(String[] a) {
        LC974_SubarraySums solution = new LC974_SubarraySums();
        int[] nums = { 4, 5, 0, -2, -3, 1 };
        int k = 5;
        int result = solution.subarraysDivByK(nums, k);
        System.out.println("Number of subarrays divisible by " + k + ": " + result);
    }
}
