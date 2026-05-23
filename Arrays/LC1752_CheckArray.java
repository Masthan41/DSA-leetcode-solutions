/*
LeetCode 1752 - Check if Array Is Sorted and Rotated
Approach: Count the number of times the order breaks (i.e., nums[i] > nums[i + 1]).
Time complexity: O(n) as we traverse the array once.
Space complexity: O(1) as we use only a constant amount of space to store the count.
*/

class LC1752_CheckArray {
    public boolean check(int[] nums) {
        int rotationBreak = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[(i + 1) % nums.length]) {
                rotationBreak++;
            }
        }
        return rotationBreak <= 1;
    }

    public static void main(String[] args) {
        LC1752_CheckArray solution = new LC1752_CheckArray();
        int[] nums1 = { 3, 4, 5, 1, 2 };
        int[] nums2 = { 1, 2, 3, 4, 5 };
        int[] nums3 = { 1, 3, 2 };
        System.out.println(solution.check(nums1)); // true
        System.out.println(solution.check(nums2)); // true
        System.out.println(solution.check(nums3)); // false
    }
}