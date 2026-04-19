/*
LeetCode 1855 - Maximum Distance Between Elements
Approach: Use two pointers to traverse both arrays and find the maximum distance between elements where i <= j and nums1[i] <= nums2[j].

Time Complexity: O(m + n) where m and n are the lengths of the two arrays.
Space Complexity: O(1) as we only use a constant amount of extra space.
*/

class LC1855_MaxDistance{
    public int maxDistance(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int i = 0; // nums1 pointer
        int j = 0; // nums2 pointer

        int result = 0;

        while (i < m && j < n) {
            if (nums1[i] > nums2[j]) {
                i++;
            } else {
                result = Math.max(result, j - i);
                j++;
            }
        }

        return result;
    }
    public static void main(String[] args) {
        LC1855_MaxDistance obj = new LC1855_MaxDistance();
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {3, 4, 5};
        System.out.println("Maximum Distance: " + obj.maxDistance(nums1, nums2));
    }
}