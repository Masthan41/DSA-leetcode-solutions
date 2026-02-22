/*
LeetCode 78 - Subsets
Approach: Backtracking (include / exclude)
Time Complexity: O(n * 2^n)
Space Complexity: O(n)
*/

import java.util.*;

class LC78_Subsets {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, int i, List<Integer> curr, List<List<Integer>> result) {
        if (i == nums.length) {
            result.add(new ArrayList<>(curr));
            return;
        }

        // Include in nums
        curr.add(nums[i]);
        backtrack(nums, i + 1, curr, result);

        // Backtrack
        curr.remove(curr.size() - 1);

        // Exclude from nums
        backtrack(nums, i + 1, curr, result);
    }
    public static void main(String[] args) {
        LC78_Subsets sol = new LC78_Subsets();
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = sol.subsets(nums);
        System.out.println(result);
    }
}
