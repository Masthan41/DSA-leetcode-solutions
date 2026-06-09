/*
LeetCode 3689 - Maximum Total Value of K subarrays
Approach: To maximize the total value of K subarrays, we need to find the maximum and minimum elements in the array. The maximum total value can be calculated as (maxEle - minEle) * k, where maxEle is the maximum element in the array and minEle is the minimum element in the array.
Time Complexity: O(n) as we need to traverse the array once to find the maximum and minimum elements.
Space Complexity: O(1) as we use only a constant amount of extra space.
*/

class LC3689_MaxValueI {
    public long maxTotalValue(int[] nums, int k) {
        int maxEle = Integer.MIN_VALUE;
        int minEle = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            maxEle = Math.max(nums[i], maxEle);
            minEle = Math.min(nums[i], minEle);
        }
        return (long) (maxEle - minEle) * k;
    }

    public static void main(String[] args) {
        LC3689_MaxValueI obj = new LC3689_MaxValueI();
        int[] nums = { 1, 2, 3, 4, 5 };
        int k = 2;
        System.out.println(obj.maxTotalValue(nums, k)); // 8
    }
}
