/*
LeetCode 3336 - find the Number of Valid Subsequences with equal GCD
Approach: Use dynamic programming to count the number of valid subsequence pairs. For each element, update the counts based on the GCD of the elements.
Time Complexity: O(n * maxEl^2), where n is the number of elements and maxEl is the maximum element in the array.
Space Complexity: O(maxEl^2) - For storing the DP table.
*/

class LC3336_EqualGCD {
    int MOD = 1_000_000_007;

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public int subsequencePairCount(int[] nums) {
        int n = nums.length;

        int maxEl = -1;
        for (int x : nums)
            maxEl = Math.max(maxEl, x);

        // prev = layer i+1, curr = layer i (2D instead of 3D)
        int[][] prev = new int[maxEl + 1][maxEl + 1];

        // Base case
        for (int first = maxEl; first >= 0; first--) {
            for (int second = maxEl; second >= 0; second--) {
                boolean bothNonEmpty = (first != 0 && second != 0);
                boolean gcdsMatch = (first == second);
                prev[first][second] = (bothNonEmpty && gcdsMatch) ? 1 : 0;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            int[][] curr = new int[maxEl + 1][maxEl + 1];
            for (int first = maxEl; first >= 0; first--) {
                for (int second = maxEl; second >= 0; second--) {

                    // Skip this index entirely
                    int skip = prev[first][second];

                    // Include this index in seq1
                    int take1 = prev[gcd(first, nums[i])][second];

                    // Include this index in seq2
                    int take2 = prev[first][gcd(second, nums[i])];

                    curr[first][second] = (int) ((0L + skip + take1 + take2) % MOD);
                }
            }
            prev = curr;
        }
        return prev[0][0];
    }

    public static void main(String[] args) {
        LC3336_EqualGCD solution = new LC3336_EqualGCD();
        int[] nums = { 2, 3, 4, 6 };
        int result = solution.subsequencePairCount(nums);
        System.out.println("Number of valid subsequence pairs: " + result);
    }
}
