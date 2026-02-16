/*
LeetCode 646 - Maximum Length of Pair Chain
Approach: Greedy + Sorting by end time

Time Complexity: O(n log n)
Space Complexity: O(1)
*/

import java.util.*;

public class LC646_MaxPairChain {
        public int findLongestChain(int[][] pairs) {

        Arrays.sort(pairs, Comparator.comparingInt(o -> o[1]));

        int chainlen = 1;
        int chainEnd = pairs[0][1];

        for (int i = 1; i < pairs.length; i++) {
            if (pairs[i][0] > chainEnd) {
                chainlen++;
                chainEnd = pairs[i][1];
            }
        }
        return chainlen;
    }
    public static void main(String[] args) {
        LC646_MaxPairChain s = new LC646_MaxPairChain();
        int[][] pairs = {{1,2}, {2,3}, {3,4}};
        System.out.println(s.findLongestChain(pairs)); // 2
    }
}
