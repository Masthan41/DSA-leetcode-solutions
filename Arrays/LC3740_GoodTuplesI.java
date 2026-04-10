/*
LeetCode 3740 - Minimum Distance between three equal Elements I
Approach: brute force naive approach of 3 for loops to find the minimum distance between three equal elements in the array.

Time Complexity: O(n^3) due to the three nested loops iterating through the array.
Space Complexity: O(1) as we are using only a constant amount of extra space to store the result.
*/

/*Optimized version of this problem is in LC3741 */

class LC3740_GoodTuplesI {
    public int minimumDistance(int[] nums) {
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] == nums[j] && nums[j] == nums[k]) {
                        res = Math.min(res, 2 * (k - i));
                    }
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public static void main(String[] args) {
        LC3740_GoodTuplesI solution = new LC3740_GoodTuplesI();
        int[] nums = { 1, 2, 3, 1, 2, 3, 1 };
        System.out.println(solution.minimumDistance(nums)); // Output: 4
    }
}
