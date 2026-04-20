/*
LeetCode 2016 - Maximum Difference
Approach: To find the maximum difference between two elements in an array, we can iterate through the array and keep track of the minimum element seen so far and the maximum difference found so far.

Time Complexity: O(n) where n is the length of the nums array.
Space Complexity: O(1) as we only use a constant amount of extra space.
*/

class LC2016_MaxDiffrence {
    public int maximumDifference(int[] nums) {
        int minElement = nums[0]; // nums[i]
        int result = -1;

        for (int j = 1; j < nums.length; j++) {
            if (nums[j] > minElement) {
                result = Math.max(result, nums[j] - minElement);
            } else {
                minElement = nums[j];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LC2016_MaxDiffrence obj = new LC2016_MaxDiffrence();
        int[] nums = { 7, 1, 5, 4 };
        System.out.println("Maximum Difference: " + obj.maximumDifference(nums));
    }
}
