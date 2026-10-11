/*
LeetCode 506 - Relative Ranks
Approach: Use a max-heap to keep track of the scores and their indices. store them in a priority queue and then assign ranks based on the order of removal from the heap.
Time Complexity: O(n log n) as we are adding all the scores to the heap and removing them one by one.
Space Complexity: O(n) for the heap and the result array.
*/

import java.util.PriorityQueue;

class LC506_RelativeRanks {
    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));

        for (int i = 0; i < n; i++) {
            pq.add(new int[] { score[i], i });
        }

        String res[] = new String[n];
        int rank = 1;
        while (!pq.isEmpty()) {
            int curr[] = pq.remove();
            int idx = curr[1];

            if (rank == 1) {
                res[idx] = "Gold Medal";
            } else if (rank == 2) {
                res[idx] = "Silver Medal";
            } else if (rank == 3) {
                res[idx] = "Bronze Medal";
            } else {
                res[idx] = Integer.toString(rank);
            }
            rank++;
        }
        return res;
    }

    public static void main(String[] a) {
        LC506_RelativeRanks s = new LC506_RelativeRanks();
        int[] score = { 10, 3, 8, 9, 4 };
        String[] res = s.findRelativeRanks(score);
        for (String str : res) {
            System.out.print(str + " ");
        }
    }
}