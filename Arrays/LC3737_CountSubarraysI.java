/*
Leetcode 3737 - Count subarrays with majority element I
Appraoch : use brute force to find all subarrays and check if the target is majority in that subarray.
Time Complexity: O(n^2) for checking all subarrays.
Space Complexity: O(1) for storing the count of majority subarrays.
*/

class LC3737_CountSubarraysI {
    public int countMajoritySubarrays(int[] nums, int target) {
        int MaxSubarrays = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] == target)
                    count++;
                if ((2 * count) > (j - i + 1)) {
                    MaxSubarrays++;
                }
            }
        }
        return MaxSubarrays;
    }

    public static void main(String[] args) {
        LC3737_CountSubarraysI solution = new LC3737_CountSubarraysI();
        int[] nums = { 1, 2, 3, 2, 2 };
        int target = 2;
        int result = solution.countMajoritySubarrays(nums, target);
        System.out.println("Number of majority subarrays: " + result);
    }
}