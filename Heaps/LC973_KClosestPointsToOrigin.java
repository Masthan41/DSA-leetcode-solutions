/*
LeetCode 973 - K Closest Points to Origin
Approach: Use a max-heap to keep track of the k closest points.
Time Complexity: O(n log k)
Space Complexity: O(k)
*/

import java.util.*;

class LC973_KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;
        int m = points[0].length;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));

        for (int i = 0; i < n; i++) {
            int x = points[i][0];
            int y = points[i][1];
            int distance = x * x + y * y;

            pq.add(new int[] { distance, i });

            if (pq.size() > k) {
                pq.remove();
            }
        }

        int res[][] = new int[k][2];
        for (int i = 0; i < k; i++) {
            int curr[] = pq.peek();
            int idx = curr[1];
            pq.remove();

            res[i] = points[idx];
        }
        return res;
    }

    public static void main(String[] args) {
        LC973_KClosestPointsToOrigin obj = new LC973_KClosestPointsToOrigin();
        int points[][] = { { 1, 3 }, { -2, 2 } };
        int k = 1;
        int res[][] = obj.kClosest(points, k);
        for (int[] re : res) {
            System.out.println(re[0] + " " + re[1]);
        }
    }
}
