/*
LeetCode 153 - Find Minimum in Rotated Sorted Array
Approach: Binary Search to find the minimum element in a rotated sorted array. We compare the middle element with the rightmost element to determine which half of the array is unsorted and contains the minimum element.

Time Complexity: O(log n)
Space Complexity: O(1)
*/

class LC153_MinInArrayI {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[right];
    }

    public static void main(String[] args) {
        LC153_MinInArrayI obj = new LC153_MinInArrayI();
        int[] nums = { 3, 4, 5, 1, 2 };
        int min = obj.findMin(nums);
        System.out.println(min);
    }
}