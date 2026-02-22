/*
LeetCode 278 - First Bad Version
Pattern: Binary Search on Monotonic Condition
Approach: Narrow search space to find first true (bad version)
Time Complexity: O(log n)
Space Complexity: O(1)
*/

/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */
class VersionControl {
    boolean isBadVersion(int version) {
        // Placeholder for the actual implementation
        return false; // This should be overridden in the actual test environment
    }
}

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
    public static void main(String[] args) {
        LC278_FirstBadVersion solution = new LC278_FirstBadVersion();
        int n = 5; // Total versions
        // Assuming version 4 is the first bad version for testing
        System.out.println("First bad version: " + solution.firstBadVersion(n));
    }
}
