/*
LeetCode 1848 - Minimum Distance to the Target Element
Approach: Brute Force Search 
          Iterate through the array to find all target occurrences and minimize the absolute distance.

Time complexity: O(n) as we traverse the array once.
Space complexity: O(1) as we use only a constant amount of space to store the result.
*/

class LC1848_MinAbsValue {
    public int getMinDistance(int[] nums, int target, int start) {
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                res = Math.min(res, Math.abs(i - start));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LC1848_MinAbsValue sol = new LC1848_MinAbsValue();
        int[] nums = { 1, 2, 3, 4, 5 };
        System.out.println(sol.getMinDistance(nums, 5, 3));
    }
}