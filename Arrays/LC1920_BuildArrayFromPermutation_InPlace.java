/*
LeetCode 1920 - Build Array from Permutation
Approach: In-place encoding using modulo trick
Time complexity: O(n)
Space complexity: O(1)
*/

public class LC1920_BuildArrayFromPermutation_InPlace {
    public int[] buildArray(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] + n * (nums[nums[i]] % n);
        }

        for (int i = 0; i < n; i++) {
            nums[i] = nums[i]/n;
        }

        return nums;
    }
    public static void main(String[] args) {
        LC1920_BuildArrayFromPermutation_InPlace obj = new LC1920_BuildArrayFromPermutation_InPlace();
        int[] nums = { 0, 2, 1, 5, 3, 4 };
        int[] result = obj.buildArray(nums);
        System.out.print("Result: ");
        for (int num : result) {
            System.out.print(num + " ");
        }
        // Result: 0 1 2 4 5 3
}
