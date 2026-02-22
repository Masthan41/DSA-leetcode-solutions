/*
LeetCode 33 - Search in Rotated Sorted Array
Pattern: Binary Search Variant (Rotated Array)
Approach: Identify sorted half and discard the other half
Time Complexity: O(log n)
Space Complexity: O(1)
*/


public class LC33_SearchInRotatedSortedArray {
    public int search(int[] arr, int tar) {
        int si = 0, ei = arr.length - 1;

        while (si <= ei) {
            int mid = si + (ei - si) / 2;

            if (arr[mid] == tar)
                return mid;

            // left half
            if (arr[si] <= arr[mid]) {
                if (arr[si] <= tar && tar < arr[mid]) {
                    ei = mid - 1;
                } else {
                    si = mid + 1;
                }
            }
            // right half
            else {
                if (arr[mid] < tar && tar <= arr[ei]) {
                    si = mid + 1;
                } else {
                    ei = mid - 1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        LC33_SearchInRotatedSortedArray solution = new LC33_SearchInRotatedSortedArray();
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        int result = solution.search(arr, target);
        System.out.println("Target found at index: " + result);
    }
}
