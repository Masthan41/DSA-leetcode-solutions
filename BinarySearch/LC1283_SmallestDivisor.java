/*
LeetCode 1283 - Smallest Divisor Given a Threshold
Approach: We can use binary search to find the smallest divisor. The search space is from 1 to the maximum element in the array. For each mid value, we calculate the sum of divisions and adjust our search space accordingly.
Time Complexity: O(n * log(max(nums))) where n is the length of the nums array and max(nums) is the maximum element in the array.
Space Complexity: O(1) as we only use a constant amount of extra space.
*/

class LC1283_SmallestDivisor {
    public int sumOfDivisor(int nums[], int mid) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += (nums[i] + mid - 1) / mid;
        }
        return sum;
    }

    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1, high = 0;
        int ans = 0;
        for (int i : nums) {
            high = Math.max(high, i);
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (sumOfDivisor(nums, mid) <= threshold) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LC1283_SmallestDivisor obj = new LC1283_SmallestDivisor();
        int[] nums = { 1, 2, 5, 9 };
        int threshold = 6;
        int result = obj.smallestDivisor(nums, threshold);
        System.out.println("Smallest Divisor: " + result);
    }
}
