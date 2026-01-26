/*
LeetCode 81 - Search in Rotated Sorted Array II
Pattern: Binary Search Variant (Rotated Array with Duplicates)
Approach: Shrink boundaries when duplicates block sorted-half detection
Time Complexity: O(log n) average, O(n) worst
Space Complexity: O(1)
*/


public class LC81_SearchInRotatedSortedArrayII {
    public boolean search(int[] arr, int tar) {
        int si = 0, ei = arr.length - 1;

        while (si <= ei) {
            int mid = si + (ei - si) / 2;

            if (arr[mid] == tar)
                return true;

            // dulicates case
            if (arr[si]==arr[mid] && arr[mid] == arr[ei]) {
                si++;
                ei--;
                continue;
            }

            // left half sorted
            if (arr[si] <= arr[mid]) {
                if (arr[si] <= tar && tar < arr[mid]) {
                    ei = mid - 1;
                } else {
                    si = mid + 1;
                }
            }
            // right half sorted
            else {
                if (arr[mid] < tar && tar <= arr[ei]) {
                    si = mid + 1;
                } else {
                    ei = mid - 1;
                }
            }
        }
        return false;
    }
}
