/*
LeetCode 3464 - Maximize Distance between points on a Square
Approach: 1. Convert the 2D points to their corresponding positions on the perimeter of the square.
            2. Sort the positions and use binary search to find the maximum distance that can be maintained between k points.


Time Complexity: O(n log n) due to sorting and binary search.
Space Complexity: O(n) for the array storing the positions of the points on the perimeter.
*/

class LC3464_MaximizeDistance {
    public int maxDistance(int side, int[][] points, int k) {
        int n = points.length;
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            long x = points[i][0], y = points[i][1];
            if (x == 0)
                arr[i] = y;
            else if (y == side)
                arr[i] = side + x;
            else if (x == side)
                arr[i] = side * 3L - y;
            else
                arr[i] = side * 4L - x;
        }
        Arrays.sort(arr);

        long low = 1, high = side;
        long ans = 0;
        long perimeter = side * 4L;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (check(arr, mid, k, perimeter)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return (int) ans;
    }

    private boolean check(long[] arr, long limit, int k, long perimeter) {
        for (long start : arr) {
            long end = start + perimeter - limit;
            long cur = start;
            boolean possible = true;
            for (int i = 0; i < k - 1; i++) {
                int idx = binarySearch(arr, cur + limit);
                if (idx == arr.length || arr[idx] > end) {
                    possible = false;
                    break;
                }
                cur = arr[idx];
            }
            if (possible)
                return true;
        }
        return false;
    }

    private int binarySearch(long[] arr, long target) {
        int l = 0, r = arr.length - 1;
        int res = arr.length;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (arr[m] >= target) {
                res = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LC3464_MaximizeDistance sol = new LC3464_MaximizeDistance();
        int side = 10;
        int[][] points = { { 0, 2 }, { 2, 10 }, { 10, 8 }, { 8, 0 } };
        int k = 3;
        int result = sol.maxDistance(side, points, k);
        System.out.println("Maximum distance: " + result);
    }
}