/*
LeetCode 3904 - Smallest stable index II
Approach: We can optimize the brute-force approach by precomputing the maximum values to the left and minimum values to the right for each index. We can use two arrays, prefix and suffix, to store these values. The prefix array will store the maximum value from the start of the array to the current index, and the suffix array will store the minimum value from the current index to the end of the array. Then, we can iterate through the array and check if the difference between the prefix and suffix values at each index is less than or equal to k. If it is, we return that index.

Time Complexity: O(n) where n is the length of the array nums. We traverse the array three times: once to fill the prefix array, once to fill the suffix array, and once to check for the stable index.
Space Complexity: O(n) as we are using two additional arrays of size n to store the prefix and suffix values.
*/

class LC3904_StableIndexII {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;

        int prefix[] = new int[n];
        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = Math.max(prefix[i - 1], nums[i]);
        }

        int suffix[] = new int[n];
        suffix[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffix[i] = Math.min(suffix[i + 1], nums[i]);
        }

        for (int i = 0; i < n; i++) {
            if (prefix[i] - suffix[i] <= k) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] a) {
        LC3904_StableIndexII solution = new LC3904_StableIndexII();
        int[] nums = { 1, 3, 2, 4, 5 };
        int k = 2;
        int result = solution.firstStableIndex(nums, k);
        System.out.println("First stable index: " + result);
    }
}