/*
LeetCode 973 - K Closest Points to Origin
Approach: Use a max-heap to keep track of the k closest points.
Time Complexity: O(n log k)
Space Complexity: O(k)
*/

import java.util.*;

class LC973_KClosestPointsToOrigin {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1]));
        for (int pt[] : points) {
            pq.add(pt);

            if (pq.size() > k) {
                pq.poll();
            }
        }
        int res[][] = new int[k][2];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll();
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
