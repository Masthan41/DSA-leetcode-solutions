/*
LeetCode 373 - Find K Pairs with Smallest Sums
Approach: Use a min-heap to keep track of the k smallest sums, and also use a set to avoid duplicates. strore the indices of the pairs in the heap and set to generate new pairs.
Time Complexity: O(k log k) as we are adding and removing elements from the heap k times.
Space Complexity: O(k) for the heap and set to store the pairs.
*/

import java.util.*;

class LC373_FindKPairs {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int m = nums2.length;
        List<List<Integer>> res = new ArrayList<>();

        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> Integer.compare(a[0], b[0]));

        Set<String> set = new HashSet<>();

        pq.add(new int[] { nums1[0] + nums2[0], 0, 0 });
        set.add("0,0");

        while (k > 0 && !pq.isEmpty()) {
            int curr[] = pq.remove();

            int i = curr[1];
            int j = curr[2];

            res.add(Arrays.asList(nums1[i], nums2[j]));
            k--;

            if (j + 1 < m && set.add(i + "," + (j + 1))) {
                pq.add(new int[] { nums1[i] + nums2[j + 1], i, j + 1 });
            }

            if (i + 1 < n && set.add((i + 1) + "," + j)) {
                pq.add(new int[] { nums1[i + 1] + nums2[j], i + 1, j });
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LC373_FindKPairs solution = new LC373_FindKPairs();
        int[] nums1 = { 1, 7, 11 };
        int[] nums2 = { 2, 4, 6 };
        int k = 3;
        List<List<Integer>> result = solution.kSmallestPairs(nums1, nums2, k);
        System.out.println(result); // Output: [[1, 2], [1, 4], [1, 6]]
    }
}
