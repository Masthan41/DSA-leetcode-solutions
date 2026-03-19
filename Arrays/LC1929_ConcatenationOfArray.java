/*
LeetCode 1929 - Concatenation of Array
Approach: Simple Iteration + Direct Assignment to the output array

Time Complexity: O(n) where n is the length of the input array.
Space Complexity: O(n) for the output array which is twice the size of the input array.
*/

class LC1929_ConcatenationOfArray {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2 * n];

        for (int i = 0; i < n; i++) {
            ans[i] = nums[i];
            ans[i + n] = nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        LC1929_ConcatenationOfArray obj = new LC1929_ConcatenationOfArray();
        int[] nums = { 1, 2, 1 };
        int[] result = obj.getConcatenation(nums);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
