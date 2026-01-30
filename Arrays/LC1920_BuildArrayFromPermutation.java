/*
LeetCode 1920 - Build Array from Permutation
Approach: In-place encoding using modulo trick
Time complexity: O(n)
Space complexity: O(1)
*/

class LC1920_BuildArrayFromPermutation_InPlace {
    public int[] buildArray(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] + n * (nums[nums[i]] % n);
        }

        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] / n;
        }

        return nums;
    }
}
