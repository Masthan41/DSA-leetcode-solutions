/*
LeetCode 3020 - Maximum Number of Elements in a Subset
Approach: Frequency Counting and Iteration
Time Complexity: O(n) where n is the length of the array
Space Complexity: O(n) for the HashMap
*/


class LC3020_MaxElementsinSubsets{

    public int maximumLength(int[] nums) {
        Map<Long, Integer> freq = new HashMap<>();

        for (int num : nums) {
            freq.put((long) num, freq.getOrDefault((long) num, 0) + 1);
        }

        int ans = 1;

        // Handle 1 separately
        if (freq.containsKey(1L)) {
            int cnt = freq.get(1L);
            ans = Math.max(ans, cnt % 2 == 0 ? cnt - 1 : cnt);
        }

        for (long x : freq.keySet()) {
            if (x == 1) continue;

            long cur = x;
            int len = 0;

            while (freq.getOrDefault(cur, 0) >= 2) {
                len += 2;
                if (cur > 1000000000L) break; // prevent overflow
                cur *= cur;
            }

            if (freq.getOrDefault(cur, 0) == 1) {
                len += 1;
            } else {
                len -= 1;
            }

            ans = Math.max(ans, len);
        }
        return ans;
    }
    public static void main(String[] args) {
        LC3020_MaxElementsinSubsets solution = new LC3020_MaxElementsinSubsets();
        int[] nums = { 2, 3, 2, 9, 81 };
        int result = solution.maximumLength(nums);
        System.out.println("Maximum length of subset: " + result);
    }
}