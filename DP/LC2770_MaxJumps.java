/*
Leetcode 2770 - Maximum number of jumps to reach last index
Appraoch : Dynamic Programming (bottom-up).
Time Complexity: O(n^2) where n is the length of the input array nums, due to the nested loops.
Space Complexity: O(n) for the dp array t, which stores the maximum number of jumps from each index to the end of the array.
*/

import java.util.*;

class LC2770_MaxJumps {
    public int maximumJumps(int[] nums, int target) {
        int n = nums.length;
        int t[] = new int[n + 1];

        Arrays.fill(t, Integer.MIN_VALUE);

        t[n - 1] = 0;

        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (Math.abs(nums[i] - nums[j]) <= target && t[j] != Integer.MIN_VALUE) {
                    int temp = 1 + t[j];

                    t[i] = Math.max(t[i], temp);
                }
            }
        }
        return t[0] == Integer.MIN_VALUE ? -1 : t[0];
    }

    public static void main(String[] args) {
        int nums[] = { 1, 3, 6, 4, 1, 2 };
        int target = 2;
        LC2770_MaxJumps solution = new LC2770_MaxJumps();
        System.out.println(solution.maximumJumps(nums, target));
    }
}