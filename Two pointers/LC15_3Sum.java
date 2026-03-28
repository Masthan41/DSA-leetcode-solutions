/*
LeetCode 15 - 3Sum
Approach: Two Pointers after sorting the array and skipping duplicates
Time Complexity: O(n^2) because of the nested loops and the sorting step
Space Complexity: O(1) if we don't consider the output list, otherwise O(k) where k is the number of triplets found
*/

import java.util.*;

class LC15_3Sum {
    public List<List<Integer>> threeSum(int[] nums) {

        if (nums.length < 3)
            return new ArrayList<>();

        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            int j = i + 1;
            int k = n - 1;

            // duplicates for i
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    // found the triplet
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;

                    // duplicates for j
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }

                    // duplicates for k
                    while (j < k && nums[k] == nums[k + 1]) {
                        k--;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LC15_3Sum obj = new LC15_3Sum();
        int[] nums = { -1, 0, 1, 2, -1, -4 };
        List<List<Integer>> res = obj.threeSum(nums);
        System.out.println(res);
    }
}
