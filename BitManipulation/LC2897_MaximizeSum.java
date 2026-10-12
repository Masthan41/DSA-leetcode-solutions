/*
LeetCode 2897 - Apply operations on array to Maximize sum of Squares
Approach: We want to maximize the sum of squares of the array elements. To do this, we should always choose the element with the highest absolute value to square it. We can use a max-heap to efficiently find and update the largest element.

Time Complexity: O(n+k) as we need to process each element in the array and perform k operations.
Space Complexity: O(n) for the count array to store the number of 1s in each bit position.
*/

import java.util.List;

class LC2897_MaximizeSum {
    public int maxSum(List<Integer> nums, int k) {
        final int MOD = 1_000_000_007;
        final int BITS = 30; // nums[i] <= 10^9 < 2^30

        // count[b] = number of 1s in bit column b
        int[] count = new int[BITS];

        for (int num : nums) {
            for (int b = 0; b < BITS; b++) {
                if ((num & (1 << b)) != 0) {
                    count[b]++; // found a '1' in bit position b
                }
            }
        }

        long result = 0;

        while (k-- > 0) {
            long curr = 0;

            for (int b = 0; b < BITS; b++) {
                if (count[b] > 0) {
                    count[b]--;
                    curr |= (1L << b); // 1L so it is a long, not an int
                }
            }

            result = (result + curr * curr) % MOD;
        }
        return (int) result;
    }

    public static void main(String[] args) {
        LC2897_MaximizeSum sol = new LC2897_MaximizeSum();

        List<Integer> nums1 = List.of(1, 2, 3);
        int k1 = 3;
        System.out.println("Test Case 1: " + sol.maxSum(nums1, k1)); // Expected: 14

        List<Integer> nums2 = List.of(5, 5, 5);
        int k2 = 2;
        System.out.println("Test Case 2: " + sol.maxSum(nums2, k2)); // Expected: 50

        List<Integer> nums3 = List.of(0, 0, 0);
        int k3 = 5;
        System.out.println("Test Case 3: " + sol.maxSum(nums3, k3)); // Expected: 0
    }
}
