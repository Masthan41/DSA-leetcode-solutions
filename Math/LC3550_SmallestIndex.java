/*
LeetCode 3550 - Smallest index with digit sum equal to index
Approach: Iterate through the array and for each number, calculate the sum of its digits. If the sum equals the index, return that index.
Time Complexity: O(n * d) where n is the length of the array and d is the number of digits in the largest number, since we need to iterate through each number and calculate the sum of its digits.
Space Complexity: O(1) since we are using a constant amount of space.
*/

class LC3550_SmallestIndex {
    public int smallestIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            while (nums[i] != 0) {
                int digit = nums[i] % 10;
                sum += digit;
                nums[i] /= 10;

            }
            if (sum == i) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] a) {
        LC3550_SmallestIndex s = new LC3550_SmallestIndex();
        int[] nums = { 18, 29, 38, 47, 56 };
        System.out.println(s.smallestIndex(nums));
    }
}