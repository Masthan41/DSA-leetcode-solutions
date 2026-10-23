/*
LeetCode 3644 - Maximum K to Sort Permutation
Approach: Calculate the bitwise AND of all elements that are not in their sorted position. The result will be the maximum K that can be used to sort the permutation.
Time Complexity: O(n) as we are iterating through the array once.
Space Complexity: O(1) as we are using a constant amount of space.
*/

class LC3644_SortPermutation {
    public int sortPermutation(int[] nums) {
        int ans = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                ans &= nums[i];
            }
        }
        return Math.max(ans, 0);
    }

    public static void main(String[] args) {
        LC3644_SortPermutation solution = new LC3644_SortPermutation();
        int[] nums = { 1, 0, 3, 2 };
        int result = solution.sortPermutation(nums);
        System.out.println(result); // Output: 0
    }
}
