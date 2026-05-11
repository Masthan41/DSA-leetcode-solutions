/*
Leetcode 485 - Max Consecutive Ones I
Appraoch : Iterate through the input array and count the number of consecutive 1's. Whenever a 0 is encountered, reset the count to 0. Keep track of the maximum count of consecutive 1's encountered during the iteration.

Time Complexity: O(n) where n is the length of the input array nums.
Space Complexity: O(1) for the count variables.
*/


class LC485_MaxConsecutiveOnesI {
    public int findMaxConsecutiveOnes(int[] nums) {
        int currentCount = 0, MaxCount = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                currentCount++;
            }
            MaxCount = Math.max(MaxCount, currentCount);
            if (nums[i] == 0) {
                currentCount = 0;
            }
        }
        return MaxCount;
    }

    public static void main(String[] args) {
        LC485_MaxConsecutiveOnesI solution = new LC485_MaxConsecutiveOnesI();
        int[] nums = { 1, 1, 0, 1, 1, 1 };
        int result = solution.findMaxConsecutiveOnes(nums);
        System.out.println("Maximum number of consecutive 1's: " + result);
    }
}
