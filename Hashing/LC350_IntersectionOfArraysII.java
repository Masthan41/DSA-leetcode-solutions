/*
LeetCode 350 - Intersection of Two Arrays II
Approach: Use two pointers after sorting both arrays
Time Complexity: O(m log m + n log n) where m and n are the lengths of the two arrays
Space Complexity: O(1) excluding the space used for output array
*/

import java.util.*;

class LC350_IntersectionOfArraysII {
     public int[] intersect(int[] nums1, int[] nums2) {
        
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0, j = 0;
        List<Integer> res = new ArrayList<>();

        while (i < nums1.length && j < nums2.length) {

            if (nums1[i] < nums2[j]) {
                i++;
            } 
            else if (nums1[i] > nums2[j]) {
                j++;
            } 
            else {
                res.add(nums1[i]);
                i++;
                j++;
            }
        }

        // Convert List to Array
        int arr[] = new int[res.size()];
        for (int k = 0; k < res.size(); k++) {
            arr[k] = res.get(k);
        }
        return arr;
    }
    public static void main(String[] args) {
        LC350_IntersectionOfArraysII obj = new LC350_IntersectionOfArraysII();
        int nums1[] = { 1, 2, 2, 1 };
        int nums2[] = { 2, 2 };
        int res[] = obj.intersect(nums1, nums2);
        for (int i : res) {
            System.out.print(i + " ");
        }
    }
}
