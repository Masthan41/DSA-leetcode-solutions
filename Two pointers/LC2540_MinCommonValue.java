/*
LeetCode 2540 - Minimum Common Value
Approach: Use two pointers to traverse both arrays and find the minimum common value.
Time Complexity: O(m + n) where m and n are the lengths of the two arrays.
Space Complexity: O(1) as we only use a constant amount of extra space.
*/

class LC2540_MinCommonValue {
    public int getCommon(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                return nums1[i];
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LC2540_MinCommonValue solution = new LC2540_MinCommonValue();
        int[] nums1 = { 1, 2, 3 };
        int[] nums2 = { 2, 4 };
        System.out.println(solution.getCommon(nums1, nums2)); // Output: 2
    }
}
