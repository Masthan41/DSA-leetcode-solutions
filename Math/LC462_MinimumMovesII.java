/*
LeetCode 462 - Minimum Moves to Equal Array Elements II
Approach: The minimum number of moves to make all array elements equal can be calculated by finding the median of the array. The median minimizes the sum of absolute deviations from the center point. Each move consists of incrementing or decrementing an element by 1. Therefore, the total number of moves required is the sum of the absolute differences between each element and the median.

Time Complexity: O(N log N) where N is the number of elements in the array, as we need to sort the array to find the median.
Space Complexity: O(1) as we are using a constant amount of extra space for variables.
*/

import java.util.*;

class LC462_MinimumMovesII {
    public int minMoves2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int mid = nums[n / 2];

        int minMoves = 0;
        for (int i = 0; i < n / 2; i++) {
            minMoves += Math.abs(nums[i] - mid);
            minMoves += Math.abs(nums[n - i - 1] - mid);
        }
        return minMoves;
    }

    public static void main(String[] args) {
        LC462_MinimumMovesII solution = new LC462_MinimumMovesII();
        // Test case 1
        int[] nums = { 1, 2, 3 };
        System.out.println("Minimum moves to equal array elements: " + solution.minMoves2(nums)); // Output: 2

        // Test case 2
        int[] nums2 = { 5, 6, 8 };
        System.out.println("Minimum moves to equal array elements: " + solution.minMoves2(nums2)); // Output: 3

        // Test case 3
        int[] nums3 = { 1, 1, 1 };
        System.out.println("Minimum moves to equal array elements: " + solution.minMoves2(nums3)); // Output: 0

        // Test case 4
        int[] nums4 = { 1, 2, 3, 4 };
        System.out.println("Minimum moves to equal array elements: " + solution.minMoves2(nums4)); // Output: 4

        // Test case 5
        int[] nums5 = { 1, 2, 3, 4, 5 };
        System.out.println("Minimum moves to equal array elements: " + solution.minMoves2(nums5)); // Output: 6
    }
}
