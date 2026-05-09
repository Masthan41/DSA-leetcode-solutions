/*
LeetCode 643 - Maximum Average Subarray I
Approach: Sliding Window with two pointers
Time Complexity: O(n) for iterating through the array once
Space Complexity: O(1) for variables (excluding input array)
*/

class LC643_MaxAverageI {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        // first window
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int maxSum = sum;

        // slide the window
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, sum);
        }

        return (double) maxSum / k;
    }

    public static void main(String[] args) {
        LC643_MaxAverageI solution = new LC643_MaxAverageI();
        int[] nums = { 1, 12, -5, -6, 50, 3 };
        int k = 4;
        double result = solution.findMaxAverage(nums, k);
        System.out.println(result); // Output: 12.75
    }
}
