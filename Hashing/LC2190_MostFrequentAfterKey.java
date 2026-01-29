/*
LeetCode 2190 - Most Frequent Number Following Key
Approach: HashMap Frequency Counting
Time Complexity: O(n)
Space Complexity: O(n)
*/


import java.util.*;

class LC2190_MostFrequentAfterKey {
    public int mostFrequent(int[] nums, int key) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == key) {
                int next = nums[i + 1];
                map.put(next, map.getOrDefault(next, 0) + 1);
            }
        }

        int maxFreq = 0;
        int ans = -1;

        for (int num : map.keySet()) {
            if (map.get(num) > maxFreq) {
                maxFreq = map.get(num);
                ans = num;
            }
        }
        return ans;
    }
}
