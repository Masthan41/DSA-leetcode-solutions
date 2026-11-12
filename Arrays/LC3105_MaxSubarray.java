/*
LeetCode 3105 - Longest Strictly Increasing or Decreasing Subarray
Approach: Use a single pass through the array to keep track of the lengths of the current increasing and decreasing subarrays. We maintain two counters, one for the length of the current increasing subarray and another for the length of the current decreasing subarray. As we iterate through the array, we update these counters based on the relationship between the current element and the previous element. We also keep track of the maximum length encountered during this process.

Time Complexity: O(n) as we visit each element of the array exactly once, where n is the number of elements in the input array.
Space Complexity: O(1) as we use a constant amount of extra space for the counters and the maximum length variable.
*/

class LC3105_MaxSubarray {
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;

        int inc = 1, dec = 1;
        int len = 1;

        for (int i = 1; i < n; i++) {
            if (nums[i] > nums[i - 1]) {
                inc++;
                dec = 1;
            } else if (nums[i] < nums[i - 1]) {
                dec++;
                inc = 1;
            } else {
                inc = 1;
                dec = 1;
            }
            len = Math.max(len, Math.max(inc, dec));
        }
        return len;
    }

    public static void main(String[] args) {
        LC3105_MaxSubarray solution = new LC3105_MaxSubarray();

        int[] nums1 = { 1, 2, 2, 3, 4, 1 };
        System.out.println(solution.longestMonotonicSubarray(nums1)); // Output: 4

        int[] nums2 = { 5, 4, 3, 2, 1 };
        System.out.println(solution.longestMonotonicSubarray(nums2)); // Output: 5

        int[] nums3 = { 1, 3, 5, 4, 2 };
        System.out.println(solution.longestMonotonicSubarray(nums3)); // Output: 3
    }
}
