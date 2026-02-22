/*
LeetCode 27 - Remove Element
Approach: Two pointers (overwrite valid elements)
Time complexity: O(n)
Space complexity: O(1)
*/

class LC27_RemoveElement {
    public int removeElement(int[] nums, int val) {
        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
    public static void main(String[] args) {
        LC27_RemoveElement obj = new LC27_RemoveElement();
        int[] nums = { 3, 2, 2, 3 };
        int val = 3;
        int k = obj.removeElement(nums, val);
        System.out.println("New length: " + k); // New length: 2
    }
}
