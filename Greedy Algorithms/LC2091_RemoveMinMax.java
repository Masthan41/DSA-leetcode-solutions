/*
LeetCode 2091 - Removing minimum and maximum from array
Approach: Find the indices of the minimum and maximum elements, then calculate the minimum deletions required by considering different strategies for removing elements from either end of the array.
Time Complexity: O(n) as we iterate through the stones array once.
Space Complexity: O(1) as we use a fixed number of variables to store indices and counts.
*/

class LC2091_RemoveMinMax {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        int minIdx = 0, maxIdx = 0;

        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[minIdx]) {
                minIdx = i;
            }
            if (nums[i] > nums[maxIdx]) {
                maxIdx = i;
            }
        }

        int left = Math.min(minIdx, maxIdx);
        int right = Math.max(minIdx, maxIdx);

        return Math.min(left + 1 + n - right, Math.min(right + 1, n - left));
    }

    public static void main(String[] args) {
        LC2091_RemoveMinMax solution = new LC2091_RemoveMinMax();
        int[] nums = { 2, 10, 7, 5, 4, 1, 8, 6 };
        int result = solution.minimumDeletions(nums);
        System.out.println("Minimum deletions: " + result);
    }
}
