/*
LeetCode 3300 - Minimum element after replacemnt with digit sum
Approach: Iterate through each number in the array, calculate the sum of its digits, and keep track of the minimum sum encountered.
Time Complexity: O(n * m) where n is the number of elements in the array and m is the number of digits in the largest number, as we need to calculate the sum of digits for each number.
Space Complexity: O(1) as we are using a constant amount of space to store variables and the result.
*/

class LC3300_MinElement {
    public int minElement(int[] nums) {
        int minimum = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int temp = 0;
            while (nums[i] > 0) {
                temp += nums[i] % 10;
                nums[i] = nums[i] / 10;
            }

            if (temp < minimum) {
                minimum = temp;
            }
        }
        return minimum;
    }

    public static void main(String[] args) {
        LC3300_MinElement obj = new LC3300_MinElement();
        int[] nums = { 123, 456, 789 };
        int res = obj.minElement(nums);
        System.out.println(res);
    }
}
