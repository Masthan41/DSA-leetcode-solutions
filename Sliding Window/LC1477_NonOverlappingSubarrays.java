/*
LeetCode 1477 - Two non overlapping subarrays with target sum
Approach: Sliding Window wiht two pointers and a prefix array to store the minimum length of subarray with target sum till that index.
Time Complexity: O(n) as we are traversing the array once.
Space Complexity: O(n) as we are using a prefix array to store the minimum length of subarray with target sum till that index.
*/

import java.util.*;

class LC1477_NonOverlappingSubarrays {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;

        int i = 0;
        int j = 0;

        int currSum = 0;
        int[] minBestLenTillIdx = new int[n];
        Arrays.fill(minBestLenTillIdx, Integer.MAX_VALUE);

        int bestMinLen = Integer.MAX_VALUE;
        int result = Integer.MAX_VALUE;

        while (j < n) {
            currSum += arr[j];

            while (i < j && currSum > target) {
                currSum -= arr[i++];
            }

            if (currSum == target) {
                int len = j - i + 1;

                if (i > 0 && minBestLenTillIdx[i - 1] != Integer.MAX_VALUE) {
                    result = Math.min(result, len + minBestLenTillIdx[i - 1]);
                }

                bestMinLen = Math.min(bestMinLen, len);
            }

            minBestLenTillIdx[j] = bestMinLen;
            j++;
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    public static void main(String[] a) {
        LC1477_NonOverlappingSubarrays s = new LC1477_NonOverlappingSubarrays();
        int[] arr = { 3, 2, 2, 4, 3 };
        int target = 3;
        System.out.println(s.minSumOfLengths(arr, target));
    }
}