/*
LeetCode 2089 - Find Target Indices After Sorting Array
Approach: We can solve this problem by first counting the number of elements in the array that are less than the target value. This count will give us the starting index for the target value in the sorted array. Then, we can iterate through the original array and for each occurrence of the target value, we add the current count to a list of indices and increment the count.

Time Complexity: O(n) where n is the length of the input array, since we are iterating through the array twice (once for counting and once for collecting indices).
Space Complexity: O(n) for the output list.
*/

import java.util.*;

class LC2089_FindIndices {
    public List<Integer> targetIndices(int[] nums, int target) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        int count = 0;
        for (int num : nums) {
            if (num < target) {
                count++;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] == target) {
                list.add(count);
                count++;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        LC2089_FindIndices obj = new LC2089_FindIndices();
        int[] nums = { 1, 2, 5, 2, 3 };
        int target = 2;
        System.out.println(obj.targetIndices(nums, target));
    }
}
