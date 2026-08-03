/*
LeetCode 303 - Range Sum Query - Immutable
Approach: Precompute prefix sums to allow constant-time range sum queries.
Time Complexity: O(n) for preprocessing, O(1) for each query.
Space Complexity: O(n) for the prefix sum array.
*/

class LC303_RangeSumQueries {
    int prefix[];

    public LC303_RangeSumQueries(int[] nums) {
        int n = nums.length;
        prefix = new int[n];

        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = nums[i] + prefix[i - 1];
        }
    }

    public int sumRange(int left, int right) {
        if (left == 0) {
            return prefix[right];
        }
        return prefix[right] - prefix[left - 1];
    }

    public static void main(String[] args) {
        int[] nums = { -2, 0, 3, -5, 2, -1 };
        LC303_RangeSumQueries obj = new LC303_RangeSumQueries(nums);
        System.out.println(obj.sumRange(0, 2)); // Output: 1
        System.out.println(obj.sumRange(2, 5)); // Output: -1
        System.out.println(obj.sumRange(0, 5)); // Output: -3
    }
}
