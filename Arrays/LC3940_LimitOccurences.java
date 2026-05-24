/*
LeetCode 3940 - Limit Occurrences
Approach: We use a two-pointer technique to remove elements that occur more than k times. We maintain a write pointer to place valid elements.
Time Complexity: O(n) due to the single pass through the array.
Space Complexity: O(1) additional space for the operations calculation.
*/


import java.util.*;

class LC3940_LimitOccurences {
    public int[] limitOccurrences(int[] nums, int k) {
        int write = 0;
        for (int i = 0; i < nums.length; i++) {
            if (write < k || nums[i] != nums[write - k]) {
                nums[write] = nums[i];
                write++;
            }
        }
        int res[] = new int[write];
        for (int i = 0; i < write; i++) {
            res[i] = nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        LC3940_LimitOccurences solution = new LC3940_LimitOccurences();
        int[] nums = { 1, 1, 1, 2, 2, 3 };
        int k = 2;
        int[] result = solution.limitOccurrences(nums, k);
        System.out.println(Arrays.toString(result)); // Output: [1, 1, 2, 2, 3]
    }
}
