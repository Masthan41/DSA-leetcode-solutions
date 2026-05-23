/*
LeetCode 3936 - Minimum Swaps to move all zeros to the end of the array
Approach: We first count the total number of zeros in the array. Then, we iterate through the first n - zeros elements of the array (where n is the length of the array) and count how many zeros are present in that portion. The number of swaps needed will be equal to the number of zeros found in that portion, as each zero will need to be swapped with a non-zero element from the end of the array.
Time Complexity: O(n) due to the single pass
Space Complexity: O(1) as we are using only a constant amount of extra space.
*/

class LC3936_MinSwaps {
    public int minimumSwaps(int[] nums) {
        int n = nums.length;

        // count total zeros
        int zeros = 0;

        for (int num : nums) {
            if (num == 0) {
                zeros++;
            }
        }

        int swaps = 0;

        // last 'zeros' positions should contain zeros
        for (int i = 0; i < n - zeros; i++) {

            if (nums[i] == 0) {
                swaps++;
            }
        }
        return swaps;
    }

    public static void main(String[] args) {
        LC3936_MinSwaps obj = new LC3936_MinSwaps();
        int[] nums = { 0, 1, 0, 1, 0 };
        System.out.println(obj.minimumSwaps(nums)); // Output: 2
    }
}