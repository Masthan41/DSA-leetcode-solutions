/*
LeetCode 3731 - Find Missing Elements in an Array
Approach: Using a HashSet for O(1) lookup after finding the smallest and largest elements in the array
Time Complexity: O(n) where n is the length of the array
Space Complexity: O(n) for the HashSet
*/

import java.util.*;

class LC3731_FindMissingElement {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        int smallest = Integer.MAX_VALUE;
        int largest = Integer.MIN_VALUE;
        for (int num : nums) {
            smallest = Math.min(smallest, num);
            largest = Math.max(largest, num);
            set.add(num);
        }

        for (int i = smallest; i <= largest; i++) {
            if (!set.contains(i)) {
                list.add(i);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        LC3731_FindMissingElement solution = new LC3731_FindMissingElement();
        int[] nums = { 3, 7, 1, 2, 8, 4, 5 };
        List<Integer> missingElements = solution.findMissingElements(nums);
        System.out.println(missingElements); // Output: [6]
    }
}
