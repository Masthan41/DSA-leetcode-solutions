/*
LeetCode 3761 - Minimum absolute distance between mirror pairs
Approach: Using a hash map to store reversed values and their latest indices to find minimum distance in one pass.

Time Complexity: O(n*d) where d is the number of digits in the largest number (for reversing), but since d is typically small, it can be considered O(n).
Space Complexity: O(n) for the hash map storing reversed values and their indices.
*/

import java.util.*;

class LC3761_MirrorDistance {
    public int getReverse(int n) {
        int rev = 0;
        while (n > 0) {
            int rem = n % 10;
            rev = rev * 10 + rem;
            n = n / 10;
        }
        return rev;
    }

    public int minMirrorPairDistance(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                result = Math.min(result, Math.abs(i - map.get(nums[i])));
            }
            map.put(getReverse(nums[i]), i);
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public static void main(String[] args) {
        LC3761_MirrorDistance solution = new LC3761_MirrorDistance();
        int[] nums = { 123, 321, 456, 654 };
        System.out.println(solution.minMirrorPairDistance(nums)); // Output: 1 (123 and 321 are mirror pairs)
    }
}