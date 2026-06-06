/*
Leetcode 2574 - Left and Right Sum Differences
Approach : Calculate the left and right sums for each element and find the absolute difference.

Time Complexity: O(n) where n is the length of the input array nums.
Space Complexity: O(1) as we are using only a constant amount of extra space (res[] is the output array which does not count towards extra space).
*/

class LC2574_LeftRightSum {
    public int[] leftRightDifference(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        int res[] = new int[nums.length];
        int curr = 0;

        for (int i = 0; i < nums.length; i++) {
            int leftSum = curr;

            curr += nums[i];
            int rightSum = sum - curr;

            res[i] = Math.abs(leftSum - rightSum);
        }
        return res;
    }

    public static void main(String[] args) {
        LC2574_LeftRightSum obj = new LC2574_LeftRightSum();
        int[] nums = { 10, 4, 8, 3 };
        int[] res = obj.leftRightDifference(nums);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }
}
