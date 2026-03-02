/*
LeetCode 349 - Intersection of Two Arrays
Approach: Use HashSet to store elements of one array and check for common elements in the second array
Time Complexity: O(m + n) where m and n are the lengths of the two arrays
Space Complexity: O(min(m, n)) for storing elements in the HashSet
*/

import java.util.*;

class LC349_IntersectionOfArrays {
     public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            if (set1.contains(i)) {
                set.add(i);
            }
        }
        int res[] = new int[set.size()];
        int i = 0;
        for (int num : set) {
            res[i++] = num;
        }
        return res;
    }
    public static void main(String[] args) {
        LC349_IntersectionOfArrays obj = new LC349_IntersectionOfArrays();
        int nums1[] = { 1, 2, 2, 1 };
        int nums2[] = { 2, 2 };
        int res[] = obj.intersection(nums1, nums2);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }
}
