/*
LeetCode 35 - Search Insert Position
Approach: Binary Search
Time complexity: O(log n)
Space complexity: O(1)
*/

class LC35_SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }
    public static void main(String[] args) {
        LC35_SearchInsertPosition obj = new LC35_SearchInsertPosition();
        int[] nums = { 1, 3, 5, 6 };
        int target = 5;
        System.out.println(obj.searchInsert(nums, target)); // 2

        target = 2;
        System.out.println(obj.searchInsert(nums, target)); // 1

        target = 7;
        System.out.println(obj.searchInsert(nums, target)); // 4

        target = 0;
        System.out.println(obj.searchInsert(nums, target)); // 0
}
