/*
Leetcode 1674 - Minimum Moves to Make Array Complementary
Appraoch : Use a difference array to track the minimum moves needed for each possible sum.
Time Complexity: O(n + limit) for preprocessing and answering each query, where n is the length of the nums array and limit is the maximum value in the array.
Space Complexity: O(limit) for storing the difference array.
*/


class LC1674_MinMoves {
    public int minMoves(int[] nums, int limit) {

        int n = nums.length;

        int[] diff = new int[2 * limit + 2];

        for (int i = 0; i < n / 2; i++) {

            int a = nums[i];
            int b = nums[n - 1 - i];

            int minVal = Math.min(a, b) + 1;
            int maxVal = Math.max(a, b) + limit;

            diff[2] += 2;
            diff[2 * limit + 1] -= 2;

            // for moves = 1
            diff[minVal] += (-1);
            diff[maxVal + 1] -= (-1);

            // for moves = 0 [a+b, a+b]
            diff[a + b] += (-1);
            diff[a + b + 1] -= (-1);
        }

        int result = Integer.MAX_VALUE;

        for (int sum = 2; sum <= 2 * limit; sum++) {
            diff[sum] += diff[sum - 1];

            result = Math.min(result, diff[sum]);
        }

        return result;
    }

    public static void main(String[] args) {
        LC1674_MinMoves solution = new LC1674_MinMoves();

        int[] nums1 = { 1, 2, 4, 3 };
        int limit1 = 4;
        System.out.println(solution.minMoves(nums1, limit1)); // Output: 1

        int[] nums2 = { 1, 2, 2, 1 };
        int limit2 = 2;
        System.out.println(solution.minMoves(nums2, limit2)); // Output: 2

        int[] nums3 = { 1, 2, 1, 2 };
        int limit3 = 2;
        System.out.println(solution.minMoves(nums3, limit3)); // Output: 0
    }
}
