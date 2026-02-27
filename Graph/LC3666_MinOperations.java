/*
LeetCode 3666 - Minimum Operations to equalize Binary String
Approach: Use a breadth-first search (BFS) approach to explore the number of zeros in the string after performing operations. We maintain a distance array to track the minimum operations needed to reach each state (number of zeros). We also use two TreeSets to efficiently manage states based on parity (even or odd number of zeros) and find valid next states within the computed range. The BFS continues until we reach the state with zero zeros or exhaust all possibilities.

Time Complexity: O(n^2) in the worst case due to the BFS and TreeSet operations, but typically much less due to pruning of states.

Space Complexity: O(n) for the distance array and TreeSets.
*/

import java.util.*;

class LC3666_MinOperations {
    public int minOperations(String s, int k) {
        int n = s.length();

        // Count initial zeros
        int zeros = 0;
        for (char c : s.toCharArray()) {
            if (c == '0')
                zeros++;
        }

        // Distance array (state = number of zeros)
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);

        // Separate states by parity (even / odd zero count)
        TreeSet<Integer>[] sets = new TreeSet[2];
        sets[0] = new TreeSet<>();
        sets[1] = new TreeSet<>();

        for (int i = 0; i <= n; i++) {
            sets[i % 2].add(i);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(zeros);
        dist[zeros] = 0;
        sets[zeros % 2].remove(zeros);

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            if (curr == 0)
                return dist[0];

            // Compute valid t range
            int minT = Math.max(0, k - (n - curr));
            int maxT = Math.min(curr, k);

            // Compute reachable zero count range
            int left = curr + k - 2 * maxT;
            int right = curr + k - 2 * minT;

            int parity = left % 2;

            // Iterate safely using iterator
            Iterator<Integer> it = sets[parity]
                    .subSet(left, true, right, true)
                    .iterator();

            while (it.hasNext()) {
                int next = it.next();
                it.remove(); // remove safely while iterating
                dist[next] = dist[curr] + 1;
                queue.offer(next);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LC3666_MinOperations solution = new LC3666_MinOperations();
        String s = "1100";
        int k = 2;
        System.out.println(solution.minOperations(s, k)); // Output: 1
    }
}
