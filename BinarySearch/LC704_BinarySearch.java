/*
LeetCode 704 - Binary Search
Pattern: Binary Search (Classic)
Approach: Iterative binary search on sorted array
Time Complexity: O(log n)
Space Complexity: O(1)
*/

public class LC704_BinarySearch {
    public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = high + low / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1 ;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        LC704_BinarySearch solution = new LC704_BinarySearch();
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 9;
        int result = solution.search(nums, target);
        System.out.println("Target found at index: " + result);
    }
}
