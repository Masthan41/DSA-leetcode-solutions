/*
LeetCode 977 - Squares of a Sorted Array
Approach: Two Pointers using a left and right pointer to find the largest square and fill the result array from the end.
Time Complexity: O(n) where n is the length of the array
Space Complexity: O(1) if we don't consider the output array, otherwise O(n)
*/

import java.util.*;

class LC977_SquaresOfArray {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int left = 0, right = n - 1;
        int idx = n - 1;
        int res[] = new int[n];

        while (left <= right) {
            int leftSq = nums[left] * nums[left];
            int rightSq = nums[right] * nums[right];

            if (leftSq > rightSq) {
                res[idx] = leftSq;
                left++;
            } else {
                res[idx] = rightSq;
                right--;
            }
            idx--;
        }
        return res;
    }

    public static void main(String[] args) {
        LC977_SquaresOfArray obj = new LC977_SquaresOfArray();
        int[] nums = { -4, -1, 0, 3, 10 };
        int[] res = obj.sortedSquares(nums);
        System.out.println(Arrays.toString(res));
    }
}