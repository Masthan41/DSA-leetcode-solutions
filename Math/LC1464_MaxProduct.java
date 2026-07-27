/*
LeetCode 1464 - Maximum Product of Two Elements in an Array
Approach: Find the two largest elements in the array and calculate their product.
Time complexity: O(n) as we iterate through the array once
Space complexity: O(1) as we are using a constant amount of space for the variables
*/

class LC1464_MaxProduct {
    public int maxProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;

        for (int num : nums) {
            if (num > max1) {
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max2 = num;
            }
        }

        return ((max1 - 1) * (max2 - 1));
    }

    public static void main(String[] args) {
        LC1464_MaxProduct solution = new LC1464_MaxProduct();
        int[] nums = { 3, 4, 5, 2 };
        int result = solution.maxProduct(nums);
        System.out.println("Max product: " + result); // Output: Max product: 12
    }
}
