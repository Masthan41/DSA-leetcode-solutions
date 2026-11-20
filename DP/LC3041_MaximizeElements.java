/*
LeetCode 3041 - Maximumize Consecutive Elements in a array after modification
Approach: We use dynamic programming to solve this problem. We first sort the array and then use a recursive function with memoization to find the maximum number of elements that can be selected. The recursive function checks for each element if it can be included in the selection by either keeping it as is or incrementing it by 1, and then recursively checking the next elements.

Time Complexity: O(n^2) in the worst case, as we may need to check each element against all subsequent elements in the sorted array.
Space Complexity: O(n) for the memoization table used in the dynamic programming approach.
*/

import java.util.Arrays;

class LC3041_MaximizeElements {
    int n;
    int dp[][];

    public int findNum(int nums[], int st, int target) {
        int low = st, high = n;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }

        }
        if (low < n && nums[low] == target) {
            return low;
        }
        return -1;
    }

    public int solve(int i, int inc, int nums[]) {

        if (dp[i][inc] != -1) {
            return dp[i][inc];
        }
        int currVal = nums[i] + inc;
        int len = 1;

        int j = findNum(nums, i + 1, currVal + 1);
        if (j != -1) {
            len = Math.max(len, 1 + solve(j, 0, nums));
        }

        j = findNum(nums, i + 1, currVal);
        if (j != -1) {
            len = Math.max(len, 1 + solve(j, 1, nums));
        }

        return dp[i][inc] = len;
    }

    public int maxSelectedElements(int[] nums) {
        n = nums.length;
        Arrays.sort(nums);

        dp = new int[n + 1][2];
        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }

        int res = -1;
        for (int i = 0; i < n; i++) {
            res = Math.max(res, Math.max(solve(i, 0, nums), solve(i, 1, nums)));
        }
        return res;
    }

    public static void main(String[] args) {
        LC3041_MaximizeElements obj = new LC3041_MaximizeElements();
        int nums[] = { 1, 2, 3, 4, 5 };
        int result = obj.maxSelectedElements(nums);
        System.out.println("Maximum number of selected elements: " + result); // Output: 5
    }
}
