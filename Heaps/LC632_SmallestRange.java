/*
LeetCode 632 - Smallest Range Covering Elements from K Lists
Approach: Use a min-heap (priority queue) to keep track of the smallest elements from each list. We also maintain the maximum element seen so far. At each step, we pop the smallest element from the heap and check if the current range (max - min) is smaller than the previously recorded range. If it is, we update our result. We then push the next element from the same list into the heap and update the maximum if necessary. We continue this process until we exhaust one of the lists.

Time Complexity: O(N log K) where N is the total number of elements across all lists and K is the number of lists. Each element is pushed and popped from the heap once.
Space Complexity: O(K) for the priority queue and additional space for storing the current maximum element.
*/

import java.util.*;

class LC632_SmallestRange {
    public int[] smallestRange(List<List<Integer>> nums) {
        int n = nums.size();

        int res[] = { -1000000, 1000000 };

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int maxEle = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            pq.add(new int[] { nums.get(i).get(0), i, 0 });
            maxEle = Math.max(maxEle, nums.get(i).get(0));
        }

        while (!pq.isEmpty()) {
            int curr[] = pq.remove();
            int minEle = curr[0];
            int listIdx = curr[1];
            int idx = curr[2];

            if (maxEle - minEle < res[1] - res[0]) {
                res[0] = minEle;
                res[1] = maxEle;
            }

            if (idx + 1 < nums.get(listIdx).size()) {
                int next = nums.get(listIdx).get(idx + 1);
                pq.add(new int[] { next, listIdx, idx + 1 });
                maxEle = Math.max(maxEle, next);
            } else {
                break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LC632_SmallestRange solution = new LC632_SmallestRange();
        List<List<Integer>> nums = List.of(
                List.of(4, 10, 15, 24, 26),
                List.of(0, 9, 12, 20),
                List.of(5, 18, 22, 30));
        int[] result = solution.smallestRange(nums);
        System.out.println("Smallest range: [" + result[0] + ", " + result[1] + "]"); // Output: [20, 24]
    }
}
