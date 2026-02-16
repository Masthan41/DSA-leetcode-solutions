/*
Leetcode 88 - Merge Sorted Array
Approach: Two Pointers

Time Complexity: O(m + n)
Space Complexity: O(1)
*/

public class LC88_Merge_Two_sorted_arr {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
        // copy remaining nums2 elements
        while (j >= 0) {

            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }
    public static void main(String[] args) {
        LC88_Merge_Two_sorted_arr s = new LC88_Merge_Two_sorted_arr();
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;
        s.merge(nums1, m, nums2, n);
        for (int num : nums1) {
            System.out.print(num + " ");
        }
    }
}
