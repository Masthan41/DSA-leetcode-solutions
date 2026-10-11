/*
LeetCode 2778 - Sum of Special Elements
Approach: Iterate through the array and check if the index + 1 is a divisor of the length of the array. If it is, add the square of that element to the sum.
Time Complexity: O(n) as we are iterating through the array once.
Space Complexity: O(1) as we are using a constant amount of space.
*/

class LC2778_SumOfSpecialElements {
    public int sumOfSquares(int[] nums) {
        int n = nums.length;
        int sum = 0;

        for (int i = 0; i < n; i++) {
            if (n % (i + 1) == 0) {
                sum += (nums[i] * nums[i]);
            }
        }
        return sum;
    }

    public static void main(String[] a) {
        LC2778_SumOfSpecialElements s = new LC2778_SumOfSpecialElements();
        int[] nums = { 1, 2, 3, 4 };
        int res = s.sumOfSquares(nums);
        System.out.println(res);
    }
}
