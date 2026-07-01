/*
LeetCode 268 - Missing Number
Approach: Calculate the expected sum of numbers from 0 to n and subtract the actual sum of the array elements.
Time Complexity: O(n) where n is the length of the array, since we need to iterate through the array to calculate the sum.
Space Complexity: O(1) since we are using a constant amount of space.
*/

class LC268_MissingNumber {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = n * (n + 1) / 2;
        for (int i = 0; i < n; i++) {
            sum -= nums[i];
        }
        return sum;
    }
    public static void main(String[] args){
        LC268_MissingNumber solution = new LC268_MissingNumber();
        int[] nums = {3, 0, 1};
        int missing = solution.missingNumber(nums);
        System.out.println("Missing number: " + missing); // Output: Missing number: 2
    }
}
