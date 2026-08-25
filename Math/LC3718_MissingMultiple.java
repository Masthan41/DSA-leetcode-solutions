/*
LeetCode 3718 - Missing Multiple of K
Approach: We can use a HashSet to store the elements of the input array `nums`. Then, we start checking multiples of `k` starting from `k` itself. We keep incrementing by `k` until we find a multiple that is not present in the HashSet. This will be the smallest missing multiple of `k`.
Time Complexity: O(n) where n is the length of the input array `nums`, as we need to iterate through the array to populate the HashSet and then check for multiples of `k`.
Space Complexity: O(n) where n is the length of the input array `nums`, as we need to store all elements in the HashSet.
*/

import java.util.*;

class LC3718_MissingMultiple {
    public int missingMultiple(int[] nums, int k) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int i = k;
        while (set.contains(i)) {
            i += k;
        }
        return i;
    }

    public static void main(String[] args) {
        LC3718_MissingMultiple solution = new LC3718_MissingMultiple();
        int[] nums = { 1, 2, 3, 4, 5 };
        int k = 2;
        int result = solution.missingMultiple(nums, k);
        System.out.println("The smallest missing multiple of " + k + " is: " + result);
    }
}