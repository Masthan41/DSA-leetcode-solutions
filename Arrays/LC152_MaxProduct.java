/*
LeetCode 152 - Maximum Product Subarray
Approach: Two-pass algorithm
Time complexity: O(n) as we traverse the array twice
Space complexity: O(1) as we use only a constant amount of extra space
*/

class LC152_MaxProduct {
    public int maxProduct(int[] nums) {
        int left = 1, right = 1;
        int res = nums[0];
        
        for (int i = 0; i < nums.length; i++) {

            left = (left == 0 ? 1 : left);
            right = (right == 0 ? 1 : right);

            left *= nums[i];
            right *= nums[nums.length - i - 1];

            res = Math.max(res, Math.max(left, right));
        }
        return res;
    }
    public static void main(String[] args){
        LC152_MaxProduct sol = new LC152_MaxProduct();
        int[] nums = {2,3,-2,4};
        System.out.println(sol.maxProduct(nums)); // Output: 6
    }
}
