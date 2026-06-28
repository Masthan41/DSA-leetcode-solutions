/*
LeetCode 1840 - Maximum Building Height
Approach: Propagating height constraints bidirectionally to determine maximum possible peaks between restricted points.
Time Complexity: O(m log m ) where m is the number of restrictions, due to sorting and two linear passes.
Space Complexity: O(m) where m is the number of restrictions, for storing the list of restrictions.
*/

import java.util.*;

class LC1840_MaxHeight {
    public int maxBuilding(int n, int[][] restrictions) {
        List<int[]> list = new ArrayList<>();

        for (int[] r : restrictions) {
            list.add(new int[] { r[0], r[1] });
        }

        // Building 1 must have height 0
        list.add(new int[] { 1, 0 });

        // Building n can be at most n-1
        list.add(new int[] { n, n - 1 });

        list.sort((a, b) -> Integer.compare(a[0], b[0]));

        int m = list.size();

        // Left -> Right pass
        for (int i = 1; i < m; i++) {
            int dist = list.get(i)[0] - list.get(i - 1)[0];
            list.get(i)[1] = Math.min(
                    list.get(i)[1],
                    list.get(i - 1)[1] + dist);
        }

        // Right -> Left pass
        for (int i = m - 2; i >= 0; i--) {
            int dist = list.get(i + 1)[0] - list.get(i)[0];
            list.get(i)[1] = Math.min(
                    list.get(i)[1],
                    list.get(i + 1)[1] + dist);
        }

        int ans = 0;

        // Find maximum peak between adjacent restrictions
        for (int i = 1; i < m; i++) {

            long pos1 = list.get(i - 1)[0];
            long h1 = list.get(i - 1)[1];

            long pos2 = list.get(i)[0];
            long h2 = list.get(i)[1];

            long dist = pos2 - pos1;

            int peak = (int) ((h1 + h2 + dist) / 2);

            ans = Math.max(ans, peak);
        }
        return ans;
    }

    public static void main(String[] args) {
        LC1840_MaxHeight solution = new LC1840_MaxHeight();
        int n = 5;
        int[][] restrictions = { { 2, 1 }, { 4, 1 } };
        int maxHeight = solution.maxBuilding(n, restrictions);
        System.out.println("Maximum height of any building: " + maxHeight);
    }
}