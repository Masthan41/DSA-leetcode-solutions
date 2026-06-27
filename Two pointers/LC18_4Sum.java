/*
LeetCode 18 - 4Sum
Approach: Two Pointers after sorting the array and skipping duplicates
Time Complexity: O(n^3 + n log n) because of the nested loops and the sorting step
Space Complexity: O(1) if we don't consider the output list, otherwise O(k) where k is the number of quadruplets found
*/

import java.util.*;

class LC18_4Sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            for (int j = i + 1; j < n; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                    
                int p = j + 1, q = n - 1;
                while (p < q) {
                    long sum = (long) nums[i] + nums[j] + nums[p] + nums[q];
                    if (sum < target) {
                        p++;
                    } else if (sum > target) {
                        q--;
                    } else {
                        list.add(Arrays.asList(nums[i], nums[j], nums[p], nums[q]));
                        p++;
                        q--;

                        while (p < q && nums[p] == nums[p - 1]) {
                            p++;
                        }

                        while (p < q && nums[q] == nums[q + 1]) {
                            q--;
                        }
                    }
                }
            }
        }
        return list;
    }
    public static void main(String[] args) {
        LC18_4Sum obj = new LC18_4Sum();
        int[] nums = { 1, 0, -1, 0, -2, 2 };
        int target = 0;
        List<List<Integer>> res = obj.fourSum(nums, target);
        System.out.println(res);
    }
}
