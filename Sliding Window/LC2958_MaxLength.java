/*
LeetCode 2958 - Maximum Subarray length with at most K Distinct Elements
Approach: Use a sliding window technique to maintain a window of size k with all distinct elements, and keep track of the maximum length encountered.
Time Complexity: O(n) where n is the length of the nums array.
Space Complexity: O(n) for the HashMap storing at most n elements.
*/

import java.util.*;

class LC2958_MaxLength {
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int len = 0;
        int i = 0, j = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        while (j < n) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

            while (map.get(nums[j]) > k) {
                map.put(nums[i], map.get(nums[i]) - 1);
                i++;
            }
            len = Math.max(len, j - i + 1);
            j++;
        }
        return len;
    }

    public static void main(String[] a) {
        LC2958_MaxLength s = new LC2958_MaxLength();
        int[] nums = { 1, 2, 1, 2, 3 };
        int k = 2;
        System.out.println(s.maxSubarrayLength(nums, k));
    }
}
