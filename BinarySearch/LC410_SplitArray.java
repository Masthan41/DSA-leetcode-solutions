/*
LeetCode 410 - Split Array Largest Sum
Approach: Use binary search to find the minimum largest sum. The search space is between the maximum element in the array and the sum of all elements. For each mid value, check if it's possible to split the array into k subarrays with each subarray's sum not exceeding mid.
Time Complexity: O(n log s), where n is the number of elements and s is the sum of all elements.
Space Complexity: O(1) - For storing variables and no additional data structures are used.
*/

class LC410_SplitArray {
    public int find(int nums[], int mid) {
        int count = 1;
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] + sum <= mid) {
                sum += nums[i];
            } else {
                count++;
                sum = nums[i];
            }
        }
        return count;
    }

    public int splitArray(int[] nums, int k) {
        int low = 0, high = 0;
        for (int num : nums) {
            low = Math.max(num, low);
            high += num;
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (find(nums, mid) > k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        LC410_SplitArray solution = new LC410_SplitArray();
        int[] nums = { 7, 2, 5, 10, 8 };
        int k = 2;
        int result = solution.splitArray(nums, k);
        System.out.println("The minimum largest sum after splitting the array into " + k + " subarrays is: " + result);
    }
}
