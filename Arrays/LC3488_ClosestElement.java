/*
Leetcode 3488 - Closest Equal Elements Queries
Appraoch : Preprocessing indices with hash maps and using binary search to find nearest neighbors in a circular array.

Time Complexity: O(n log n + q log n) for preprocessing the indices and answering each query, where n is the length of the nums array and q is the number of queries.
Space Complexity: O(n) for storing the indices of each element in the hash map.
*/

import java.util.*;

class LC3488_ClosestElement {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        // store indices
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(nums[i], key -> new ArrayList<>()).add(i);
        }

        List<Integer> result = new ArrayList<>();
        for (int qi : queries) {
            int element = nums[qi];
            List<Integer> vec = map.get(element);

            int size = vec.size();

            if (size == 1) {
                result.add(-1);
                continue;
            }
            int pos = Collections.binarySearch(vec, qi);
            int res = Integer.MAX_VALUE;

            // right side
            int right = vec.get((pos + 1) % size);
            int d = Math.abs(qi - right);
            int CircularDist = n - d;
            res = Math.min(res, Math.min(d, CircularDist));

            // left side
            int left = vec.get((pos - 1 + size) % size);
            d = Math.abs(qi - left);
            CircularDist = n - d;
            res = Math.min(res, Math.min(d, CircularDist));

            result.add(res);
        }
        return result;
    }

    public static void main(String args[]) {
        LC3488_ClosestElement obj = new LC3488_ClosestElement();
        int[] nums = { 1, 2, 3, 4, 2 };
        int[] queries = { 0, 1, 2, 3, 4 };
        List<Integer> result = obj.solveQueries(nums, queries);
        System.out.println(result);
    }
}