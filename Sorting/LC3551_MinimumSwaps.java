/*
LeetCode 3551 - Minimum Swaps to sort by digit sum
Approach: we calculate the digit sum for each number and store it in an array. Then we sort the array based on the digit sum and the original number. After that, we use a visited array to keep track of the elements that have been placed in their correct position. We then count the number of swaps needed to place all elements in their correct position by finding cycles in the permutation.

Time Complexity: O(n log n) for processing all elements, where n is the length of the input array
Space Complexity: O(n) for the visited array and auxiliary arrays
*/

import java.util.Arrays;

class LC3551_MinimumSwaps {
    public int minSwaps(int[] nums) {
        int n = nums.length;
        int arr[] = new int[n];
        int values[][] = new int[n][3];

        for (int i = 0; i < n; i++) {
            int sum = 0;
            int digit = nums[i];
            while (digit > 0) {
                sum += digit % 10;
                digit /= 10;
            }
            arr[i] = sum;
            values[i][0] = nums[i];
            values[i][1] = sum;
            values[i][2] = i;
        }

        Arrays.sort(values, (a, b) -> {
            if (a[1] != b[1]) {
                return Integer.compare(a[1], b[1]);
            }
            return Integer.compare(a[0], b[0]);
        });

        boolean vis[] = new boolean[n];
        int swaps = 0;

        for (int i = 0; i < n; i++) {
            if (vis[i] || values[i][2] == i) {
                continue;
            }
            int size = 0;
            int j = i;

            while (vis[j] == false) {
                vis[j] = true;
                size++;
                j = values[j][2];
            }
            swaps += size - 1;
        }
        return swaps;
    }

    public static void main(String[] args) {
        LC3551_MinimumSwaps obj = new LC3551_MinimumSwaps();
        int[] nums = { 10, 20, 30, 40, 50 };
        System.out.println(obj.minSwaps(nums));
    }
}
