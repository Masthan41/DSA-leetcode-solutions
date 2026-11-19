/*
LeetCode 128 - Longest Consecutive Sequence
Approach: Use HashMap to store the numbers and their visited status. For each number, check in both forward and backward directions to find the length of the consecutive sequence. Update the maximum length found.
Time Complexity: O(n) as we traverse the array and for each number, we may visit its consecutive numbers at most once.
Space Complexity: O(n) as we store the numbers in a HashMap.
*/

import java.util.*;

class LC128_LongestSequence {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n == 0)
            return 0;

        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, false);
        }

        int len = 0;
        for (int num : nums) {
            int curr = 1;

            // check in forward direction
            int next = num + 1;
            while (map.containsKey(next) && !map.get(next)) {
                curr++;
                map.put(next, true);

                next++;
            }

            // check in reverse direction
            int prev = num - 1;
            while (map.containsKey(prev) && !map.get(prev)) {
                curr++;
                map.put(prev, true);

                prev--;
            }
            len = Math.max(len, curr);
        }
        return len;
    }

    public static void main(String[] args) {
        LC128_LongestSequence obj = new LC128_LongestSequence();
        int[] nums = { 100, 4, 200, 1, 3, 2 };
        System.out.println(obj.longestConsecutive(nums)); // Output: 4
    }
}