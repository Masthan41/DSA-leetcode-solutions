/*
Leetcode 198 - House Robber
Appraoch : Dynamic Programming (Bottom-Up)
Time Complexity: O(n) for the dynamic programming approach, where n is the length of the nums array.
Space Complexity: O(n) for the dp array.
*/

class LC198_HouseRobber {
    public int rob(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n + 1];
        dp[0] = 0;
        dp[1] = nums[0];

        for (int i = 2; i <= n; i++) {
            dp[i] = Math.max(nums[i - 1] + dp[i - 2], dp[i - 1]);
        }
        return dp[n];
    }

    public static void main(String[] args) {
        LC198_HouseRobber solution = new LC198_HouseRobber();
        int[] nums = { 1, 2, 3, 1 };
        int result = solution.rob(nums);
        System.out.println("Maximum amount that can be robbed: " + result);
    }
}
