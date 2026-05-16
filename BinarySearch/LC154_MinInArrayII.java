/*
LeetCode 154 - Find Minimum in Rotated Sorted Array II
Approach: Binary Search to find the minimum element in a rotated sorted array. We compare the middle element with the rightmost element to determine which half of the array is unsorted and contains the minimum element while shrinking left and right.

Time Complexity: O(n) in worst case, O(log n) in best case
Space Complexity: O(1) for iterating the array
*/

class LC154_MinInArrayII{
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {

            while (left < right && nums[left] == nums[left + 1])
                left++;
            while (right > left && nums[right] == nums[right - 1])
                right--;
            
            int mid = left + (right - left) / 2;
            
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[right];
    }
    public static void main(String[] args){
        LC154_MinInArrayII obj=new LC154_MinInArrayII();
        int[] nums = { 3, 3,3,4, 5,5,5, 1, 2 };
        int min = obj.findMin(nums);
        System.out.println(min);
    }
}