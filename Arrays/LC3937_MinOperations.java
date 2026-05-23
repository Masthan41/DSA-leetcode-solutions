/*
LeetCode 3937 - Minimum operations to make array elements equal modulo k
Approach: We iterate through all possible pairs of target remainders (x, y) for even and odd indexed elements respectively. For each pair, we calculate the total number of operations needed to convert each element in the array to the target remainder based on its index parity. The number of operations for each element is determined by the minimum cyclic distance between its current remainder and the target remainder. We keep track of the minimum operations across all pairs of target remainders.
Time Complexity: O(k^2 * n) due to the nested loops iterating over k and the single pass through the array for each pair of target remainders.
Space Complexity: O(n) for storing the input array, but O(1) additional space for the operations calculation.
*/

class LC3937_MinOperations {
    public int minOperations(int[] nums, int k) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;

        for (int x = 0; x < k; x++) {

            for (int y = 0; y < k; y++) {

                if (x == y)
                    continue;

                int operations = 0;

                for (int i = 0; i < n; i++) {

                    int rem = nums[i] % k;

                    int target = (i % 2 == 0) ? x : y;

                    int diff = Math.abs(rem - target);

                    // cyclic minimum distance
                    operations += Math.min(diff, k - diff);
                }

                ans = Math.min(ans, operations);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        LC3937_MinOperations obj = new LC3937_MinOperations();
        int[] nums = { 1, 2, 3, 4, 5 };
        int k = 3;
        System.out.println(obj.minOperations(nums, k)); // Output: 4
    }
}
