/*
LeetCode 278 - First Bad Version
Pattern: Binary Search on Monotonic Condition
Approach: Narrow search space to find first true (bad version)
Time Complexity: O(log n)
Space Complexity: O(1)
*/

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class LC278_FirstBadVersion extends VersionControl {
    public int firstBadVersion(int n) {
        int low = 1, high = n;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (isBadVersion(mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
}
