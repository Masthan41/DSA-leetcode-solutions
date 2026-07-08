/*
LeetCode 81 - Search in Rotated Sorted Array II
Pattern: Binary Search Variant (Rotated Array with Duplicates)
Approach: Shrink boundaries when duplicates block sorted-half detection
Time Complexity: O(log n) average, O(n) worst
Space Complexity: O(1)
*/

public class LC81_SearchInRotatedSortedArrayII {
    public boolean search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return true;
            }

            // skip duplicates
            if (nums[low] == nums[mid] && nums[mid] == nums[high]) {
                low++;
                high--;
            }

            // left sorted
            else if (nums[low] <= nums[mid]) {
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
        return false;
    }

    public static void main(String[] args) {
        LC81_SearchInRotatedSortedArrayII solution = new LC81_SearchInRotatedSortedArrayII();
        int[] arr = { 2, 5, 6, 0, 0, 1, 2 };
        int target = 0;
        boolean result = solution.search(arr, target);
        System.out.println("Target found: " + result);
    }
}
