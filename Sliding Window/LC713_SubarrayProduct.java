/*
LeetCode 713 - Subarray Product Less Than K
Approach: Sliding Window with Two Pointers and a variable to keep track of the product of the current window. We expand the right pointer to include new elements and shrink the left pointer when the product exceeds k. For each valid window, we count the number of subarrays that can be formed with the current right pointer.
Time Complexity: O(n) since each element is visited at most twice (once when expanding the right pointer and once when shrinking the left pointer).
Space Complexity: O(1) as we dont use any extra space.
*/

class LC713_SubarrayProduct {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int count = 0;
        int left = 0;
        long product = 1;
        if (k <= 1) {
            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            product *= nums[i];
            while (product >= k) {
                product /= nums[left];
                left++;
            }
            count += i - left + 1;
        }
        return count;
    }

    public static void main(String[] args) {
        LC713_SubarrayProduct solution = new LC713_SubarrayProduct();
        int[] nums = { 10, 5, 2, 6 };
        int k = 100;
        int result = solution.numSubarrayProductLessThanK(nums, k);
        System.out.println(result); // Output: 8
    }
}
