/*
LeetCode 1929 - Concatenation of Array
Approach: Simple iteration and filling the new array
Time complexity: O(n) as we iterate through the array once
Space complexity: O(n) for the new array
*/

class LC1929_ArrayConcatenation {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int ans[] = new int[2 * n];

        for (int i = 0; i < n; i++) {
            ans[i] = nums[i];
            ans[i + n] = nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        LC1929_ArrayConcatenation obj = new LC1929_ArrayConcatenation();
        int[] nums = { 1, 2, 1 };
        int[] result = obj.getConcatenation(nums);
        System.out.print("Output: [");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            if (i < result.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}