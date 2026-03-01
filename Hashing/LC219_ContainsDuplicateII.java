/*
LeetCode 219 - Contains Duplicate II
Approach: HashSet for Duplicate Detection with Window Size k
Time Complexity: O(n)
Space Complexity: O(min(n, k))
*/

import java.util.*;

class LC219_ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);

            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LC219_ContainsDuplicateII solution = new LC219_ContainsDuplicateII();
        int[] nums = { 1, 2, 3, 1 };
        int k = 3;
        System.out.println(solution.containsNearbyDuplicate(nums, k)); // Output: true
    }
}
