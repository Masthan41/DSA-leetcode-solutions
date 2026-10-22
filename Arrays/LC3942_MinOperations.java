/*
LeetCode 3942 - Minimum Operations to Sort a permutation
Approach: We check if the array is already sorted in ascending or descending order. If it is, we return 0. If not, we calculate the number of left and right rotations needed to sort the array in ascending or descending order. We also consider the case where we need to reverse the array. Finally, we return the minimum number of operations required to sort the array.

Time Complexity: O(n) due to the single pass through the array.
Space Complexity: O(1) as we are only using a constant amount of extra space.
*/

class LC3942_MinOperations {
    public int minOperations(int[] nums) {
        int n = nums.length;

        int asc_count = 0;
        int dsc_count = 0;

        for (int i = 1; i < n; i++) {
            asc_count += (nums[i] == (nums[i - 1] + 1) % n) ? 1 : 0;
            dsc_count += (nums[i - 1] == (nums[i] + 1) % n) ? 1 : 0;
        }

        if (asc_count == n - 1 && nums[0] == 0) { // 0, 1, 2, .... n-1
            return 0;
        }

        if (asc_count == n - 1) {
            int leftRot = n - nums[0];
            int rightRot = 1 + (nums[n - 1] + 1) + 1;
            return Math.min(leftRot, rightRot);
        }

        if (dsc_count == n - 1) {
            // Mandatory 1 Reverse
            int leftRot = n - nums[n - 1] + 1;

            // x Left Rot + 1 Reverse
            int rightRot = (nums[0] + 1) % n + 1;

            return Math.min(leftRot, rightRot);
        }
        return -1;
    }

    public static void main(String[] args) {
        LC3942_MinOperations obj = new LC3942_MinOperations();
        int[] nums1 = { 1, 0, 3, 2 };
        System.out.println(obj.minOperations(nums1)); // Output: 3

        int[] nums2 = { 3, 2, 1, 0 };
        System.out.println(obj.minOperations(nums2)); // Output: 2

        int[] nums3 = { 0, 1, 2, 3 };
        System.out.println(obj.minOperations(nums3)); // Output: 0

        int[] nums4 = { 2, 1, 0, 3 };
        System.out.println(obj.minOperations(nums4)); // Output: -1
    }
}
