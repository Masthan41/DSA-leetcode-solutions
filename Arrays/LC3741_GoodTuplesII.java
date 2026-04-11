/*
LeetCode 3741 - Minimum Distance between three equal Elements II

Approach: Optimized approach using a HashMap to store the indices of each element in the array. As we iterate through the array, we check if the current element has appeared at least three times before. If it has, we calculate the distance between the current index and the index of the third last occurrence of that element, and update the result accordingly.

Time Complexity: O(n) due to the single pass through the
Space Complexity: O(n) in the worst case if all elements are unique, as we may store all indices in the HashMap.
*/

import java.util.*;

class LC3741_GoodTuplesII {
    public int minimumDistance(int[] nums) {
        int res = Integer.MAX_VALUE;
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int k = 0; k < nums.length; k++) {
            map.putIfAbsent(nums[k], new ArrayList<>());
            map.get(nums[k]).add(k);

            if (map.get(nums[k]).size() >= 3) {
                List<Integer> list = map.get(nums[k]);
                int i = list.get(list.size() - 3);
                res = Math.min(res, 2 * (k - i));
            }
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public static void main(String[] args) {
        LC3741_GoodTuplesII solution = new LC3741_GoodTuplesII();
        int[] nums = { 1, 2, 3, 1, 2, 3, 1 };
        System.out.println(solution.minimumDistance(nums)); // Output: 12
    }
}
