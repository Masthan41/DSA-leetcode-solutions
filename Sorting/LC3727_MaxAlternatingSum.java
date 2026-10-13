/*
LeetCode 3727 - Maximum Alternating sum of squares
Approach: Sort the squares of the numbers and then alternate between adding the largest remaining square and subtracting the smallest remaining square to maximize the alternating sum.
Time complexity: O(n log n) due to the sorting of the squared array.
Space complexity: O(n) for the squared array.
*/

import java.util.Arrays;

class LC3727_MaxAlternatingSum {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long squared[] = new long[n];
        for (int i = 0; i < n; i++) {
            squared[i] = (long) nums[i] * nums[i];
        }
        Arrays.sort(squared);
        long score = 0;
        int i = 0, j = n - 1;

        int turn = 0;
        while (i <= j) {
            if (turn % 2 == 0) {
                score += squared[j];
                j--;
            } else {
                score -= squared[i];
                i++;
            }
            turn++;
        }
        return score;
    }

    public static void main(String[] args) {
        LC3727_MaxAlternatingSum solution = new LC3727_MaxAlternatingSum();
        int[] nums = { 1, 2, 3, 4 };
        long result = solution.maxAlternatingSum(nums);
        System.out.println("Max Alternating Sum: " + result);
    }
}