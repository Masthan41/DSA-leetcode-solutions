/*
LeetCode 1846 - Maximum Element After Decreasing and Rearranging
Approach: Sort the array and then adjust elements to ensure the difference between adjacent elements is at most 1.
Time Complexity: O(n log n) where n is the length of the array, due to sorting.
Space Complexity: O(1) if we ignore the space used by the sorting algorithm.
*/


import java.util.*;

class LC1846_MaxElement {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);

        int n = arr.length;
        int maxEl = 1;

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                arr[i] = 1;
            } else if (arr[i] - arr[i - 1] > 1) {
                arr[i] = arr[i - 1] + 1;
            }

            maxEl = Math.max(maxEl, arr[i]);
        }
        return maxEl;
    }

    public static void main(String[] args) {
        LC1846_MaxElement solution = new LC1846_MaxElement();
        int[] arr = { 2, 2, 1, 2, 1 };
        int result = solution.maximumElementAfterDecrementingAndRearranging(arr);
        System.out.println("Maximum Element After Decrementing and Rearranging: " + result);
    }
}
