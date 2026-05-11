/*
Leetcode 2553 - Separate Digits of an Array
Appraoch : Iterate through each number in the array, extract its digits, and add them to the result list.

Time Complexity: O(n * m) where n is the length of the input array nums and m is the average number of digits in each number.
Space Complexity: O(k) where k is the total number of digits in all numbers.
*/


import java.util.*;

class LC2553_SeparateDigits {
    public int[] separateDigits(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> temp = new ArrayList<>();

            while (nums[i] > 0) {
                temp.add(nums[i] % 10);
                nums[i] = nums[i] / 10;
            }
            Collections.reverse(temp);
            ans.addAll(temp);
        }
        int res[] = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            res[i] = ans.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        LC2553_SeparateDigits solution = new LC2553_SeparateDigits();
        int[] nums = { 13, 25, 83, 77 };
        int[] result = solution.separateDigits(nums);
        for (int digit : result) {
            System.out.print(digit + " ");
        }
    }
}