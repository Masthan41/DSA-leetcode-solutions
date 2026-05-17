/*
LeetCode 594 - Find Longest Harmonious Subsequence
Approach: Use a HashMap to count the frequency of each number. Then, for each number, check if the next number (num + 1) exists in the map and calculate the sum of their frequencies.
Time Complexity: O(n) - we visit each element once.
Space Complexity: O(n) - for the HashMap.
*/

import java.util.*;

class LC594_FindLHS {
    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        int maxLen = 0;

        for (int key : map.keySet()) {
            if (map.containsKey(key + 1)) {
                maxLen = Math.max(maxLen, map.get(key) + map.get(key + 1));
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        LC594_FindLHS obj = new LC594_FindLHS();
        int[] nums = { 1, 3, 2, 2, 5, 2, 3, 7 };
        int result = obj.findLHS(nums);
        System.out.println(result);
    }
}