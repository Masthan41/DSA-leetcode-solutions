/*
Leetcode 1385 - Find the Distance Value Between Two Arrays
Approach - Use binary search to find the closest element in arr2 for each element in arr1. If the distance is greater than d, increment the result.
Time Complexity - O(n * m * log(m)) where n is the number of elements in arr1 and m is the number of elements in arr2.
Space Complexity - O(1) as no extra space is used.
*/

import java.util.*;

class LC1385_FindDistance {
    private int findMid(int arr[], int tar) {
        int low = 0, high = arr.length - 1;
        int ans = arr.length;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] >= tar) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int n = arr1.length;
        int m = arr2.length;

        Arrays.sort(arr2);

        int res = 0;

        for (int i = 0; i < n; i++) {
            int mid = findMid(arr2, arr1[i]);

            if (mid == 0) {
                if (arr2[0] - arr1[i] > d) {
                    res++;
                }
            } else if (mid >= m) {
                if (arr1[i] - arr2[m - 1] > d) {
                    res++;
                }
            } else {
                if (arr2[mid] - arr1[i] > d &&
                        arr1[i] - arr2[mid - 1] > d) {
                    res++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LC1385_FindDistance solution = new LC1385_FindDistance();
        // test case 1
        int[] arr1_1 = { 4, 5, 8 };
        int[] arr2_1 = { 10, 9, 1, 8 };
        int d1 = 2;
        System.out.println(solution.findTheDistanceValue(arr1_1, arr2_1, d1)); // Output: 2

        // test case 2
        int[] arr1_2 = { 1, 4, 2, 3 };
        int[] arr2_2 = { -4, -3, 6, 10, 20, 30 };
        int d2 = 3;
        System.out.println(solution.findTheDistanceValue(arr1_2, arr2_2, d2)); // Output: 2

        // test case 3
        int[] arr1_3 = { 2, 1, 100, 3 };
        int[] arr2_3 = { -5, -2, 10, -3, 7 };
        int d3 = 6;
        System.out.println(solution.findTheDistanceValue(arr1_3, arr2_3, d3)); // Output: 1
    }
}
