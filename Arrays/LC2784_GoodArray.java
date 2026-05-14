/*
Leetcode 2784 - Good Array
Appraoch : Count frequencies of each element and check the conditions.
Time Complexity: O(n) for iterating through the array and checking frequencies.
Space Complexity: O(n) for storing the frequencies of each element.
*/

class LC2784_GoodArray {
    public boolean isGood(int[] nums) {
        int n = nums.length - 1;
        int freq[] = new int[n + 1];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 1 || nums[i] > n) {
                return false;
            }
            freq[nums[i]]++;
        }
        // check 1 to n-1 appear once
        for (int i = 1; i < n; i++) {
            if (freq[i] != 1) {
                return false;
            }
        }

        // n should appear twice
        return freq[n] == 2;
    }

    public static void main(String[] args) {
        LC2784_GoodArray solution = new LC2784_GoodArray();
        int[] nums1 = { 1, 2, 3, 4, 4 };
        int[] nums2 = { 1, 1, 2, 3 };
        int[] nums3 = { 1, 2, 3, 4 };

        System.out.println(solution.isGood(nums1)); // true
        System.out.println(solution.isGood(nums2)); // false
        System.out.println(solution.isGood(nums3)); // false
    }
}