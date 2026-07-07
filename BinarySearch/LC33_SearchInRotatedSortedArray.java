/*
LeetCode 33 - Search in Rotated Sorted Array
Pattern: Binary Search Variant (Rotated Array)
Approach: Identify sorted half and discard the other half
Time Complexity: O(log n)
Space Complexity: O(1)
*/

public class LC33_SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // left sorted
            if (nums[low] <= nums[mid]) {
                if (nums[low] <= target && target <= nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            // right sorted
            else {
                if (nums[mid] <= target && target <= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LC33_SearchInRotatedSortedArray solution = new LC33_SearchInRotatedSortedArray();
        int[] arr = { 4, 5, 6, 7, 0, 1, 2 };
        int target = 0;
        int result = solution.search(arr, target);
        System.out.println("Target found at index: " + result);
    }
}
