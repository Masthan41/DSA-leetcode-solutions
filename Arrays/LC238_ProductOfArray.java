/*
LeetCode 238 - Product of Array Except Self
Approach: Prefix and Suffix Products
Calculate the product of all elements except the current one using prefix and suffix products.
Time complexity: O(n) where n is the length of the array. We make two passes through the array.
Space complexity: O(1) extra space (not counting the output array).
*/

class LC238_ProductOfArray {
        public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int result[] = new int[n];
        result[0] = 1;

        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }

        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] = result[i] * right;
            right *= nums[i];
        }
        return result;
    }
    public static void main(String[] args) {
        LC238_ProductOfArray obj = new LC238_ProductOfArray();
        int[] nums = {1, 2, 3, 4};
        int[] result = obj.productExceptSelf(nums);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
