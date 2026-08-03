/*
LeetCode 724 - Find Pivot Index
Approach: Calculate the total sum of the array, then iterate through the array while maintaining a cumulative sum. For each element, check if the cumulative sum equals the remaining sum.
Time Complexity: O(n) where n is the length of the array.
Space Complexity: O(1) as only a constant amount of extra space is used.
*/

class LC724_FindPivot {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
        }

        int Cumilative_Sum = 0;
        for (int i = 0; i < n; i++) {
            int leftSum = Cumilative_Sum;
            int rightSum = sum - Cumilative_Sum - nums[i];

            if (leftSum == rightSum) {
                return i;
            }
            Cumilative_Sum += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        LC724_FindPivot obj = new LC724_FindPivot();
        int[] nums = { 1, 7, 3, 6, 5, 6 };
        int result = obj.pivotIndex(nums);
        System.out.println(result); // Output: 3
    }
}
