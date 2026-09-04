/*
LeetCode 3903 - Smallest stable index I
Approach: Use a brute-force approach to find the first stable index. For each index, we check the maximum value to the left and the minimum value to the right. If the difference between them is less than or equal to k, we return that index.
Time Complexity: O(n^2) where n is the length of the array nums. We check each index and for each index, we may traverse the entire array to find the left maximum and right minimum.
Space Complexity: O(1) as we are using a constant amount of extra space.

optimized approach is there in second variation of this problem
*/

class LC3903_StableIndexI {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int j = i;
            int leftmax = Integer.MIN_VALUE;
            while (j >= 0) {
                leftmax = Math.max(leftmax, nums[j]);
                j--;
            }
            j = i;
            int rightmin = Integer.MAX_VALUE;
            while (j < n) {
                rightmin = Math.min(rightmin, nums[j]);
                j++;
            }
            if (leftmax - rightmin <= k) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LC3903_StableIndexI solution = new LC3903_StableIndexI();
        int[] nums = { 1, 3, 2, 4, 5 };
        int k = 2;
        int result = solution.firstStableIndex(nums, k);
        System.out.println("First stable index: " + result);
    }
}
