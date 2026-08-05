/*
LeetCode 930 - Binary Subarrays with Sum
Approach: Use a sliding window technique to find all subarrays with the given sum.
Time Complexity: O(n) where n is the length of the array
Space Complexity: O(1)
*/

class LC930_BinarySubarrays {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int i = 0, j = 0;
        int window_sum = 0;
        int zero_count = 0;
        int result = 0;

        while (j < nums.length) {
            window_sum += nums[j];

            while (i < j && (nums[i] == 0 || window_sum > goal)) {
                if (nums[i] == 0) {
                    zero_count++;
                } else {
                    zero_count = 0;
                }

                window_sum -= nums[i];
                i++;
            }
            if (window_sum == goal) {
                result += 1 + zero_count;
            }
            j++;
        }
        return result;
    }

    public static void main(String[] args) {
        LC930_BinarySubarrays solution = new LC930_BinarySubarrays();
        int[] nums = { 1, 0, 1, 0, 1 };
        int goal = 2;
        int result = solution.numSubarraysWithSum(nums, goal);
        System.out.println("Number of subarrays with sum " + goal + ": " + result);
    }
}
