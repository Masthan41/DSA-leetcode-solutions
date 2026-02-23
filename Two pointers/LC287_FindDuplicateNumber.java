/*
LeetCode 287 - Find the Duplicate Number
Approach: Floyd’s Cycle Detection (Tortoise and Hare)
Time complexity: O(n)
Space complexity: O(1)
*/

class LC287_FindDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int left = nums[0];
        int right = nums[0];

        // find intersection
        do {
            left = nums[left];
            right = nums[nums[right]];
        } while (left != right);

        // find entrance to cycle
        left = nums[0];

        while (left != right) {
            left = nums[left];
            right = nums[right];
        }
        return left;
    }
    public static void main(String[] args) {
        LC287_FindDuplicateNumber solution = new LC287_FindDuplicateNumber();
        int[] nums = {1, 3, 4, 2, 2};
        int duplicate = solution.findDuplicate(nums);
        System.out.println("Duplicate number: " + duplicate);
    }
}
