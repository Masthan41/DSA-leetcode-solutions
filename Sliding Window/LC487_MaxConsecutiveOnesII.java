/*
Leetcode 487 - Max Consecutive Ones II
Appraoch : Use sliding window technique to find the maximum length of a contiguous subarray with at most one 0.
Time Complexity: O(n) where n is the length of the input array nums.
Space Complexity: O(1) for the sliding window variables.
*/

class LC487_MaxConsecutiveOnesII {
    public static int findMaxConsecutiveOnes(int[] nums) {
        int left = 0, maxLen = Integer.MIN_VALUE;
        int zero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zero++;
            }
            while (zero > 1) {
                if (nums[left] == 0) {
                    zero--;
                }
                left++;
            }
            maxLen = Math.max(maxLen, i - left + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        int arr1[] = { 1, 0, 1, 1, 0 };
        LC487_MaxConsecutiveOnesII obj1 = new LC487_MaxConsecutiveOnesII();
        int result1 = obj1.findMaxConsecutiveOnes(arr1);
        System.out.println(result1);

        int arr2[] = { 1, 1, 1, 1, 0 };
        LC487_MaxConsecutiveOnesII obj2 = new LC487_MaxConsecutiveOnesII();
        int result2 = obj2.findMaxConsecutiveOnes(arr2);
        System.out.println(result2);
    }
}