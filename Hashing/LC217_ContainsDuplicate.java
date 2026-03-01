/*
LeetCode 217 - Contains Duplicate
Approach: HashSet for Duplicate Detection
Time Complexity: O(n)
Space Complexity: O(n)
*/

import java.util.*;

class LC217_ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for (int i : nums) {
            if (set.contains(i)) {
                return true;
            }
            set.add(i);
        }
        return false;
    }

    public static void main(String[] args) {
        LC217_ContainsDuplicate solution = new LC217_ContainsDuplicate();
        int[] nums = { 1, 2, 3, 1 };
        System.out.println(solution.containsDuplicate(nums)); // Output: true
    }
}