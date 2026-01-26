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
}
