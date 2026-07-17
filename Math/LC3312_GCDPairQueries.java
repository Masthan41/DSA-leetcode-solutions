/*
LeetCode 3312 - Sorted GCD Pair Queries
Approach: To solve the problem of finding the GCD of pairs in an array based on queries, we can use a frequency array to count occurrences of each number. We then calculate the number of pairs whose GCD is exactly g for each possible GCD value. This is done by counting how many numbers are divisible by g and using combinatorial counting to find the number of pairs. We also maintain a prefix sum array to efficiently answer the queries.

Time Complexity: O(n log(max(nums))) where n is the length of the input array and max(nums) is the maximum value in the array. The log(max(nums)) factor comes from the GCD computation and the binary search for queries.
Space Complexity: O(max(nums)) for storing frequency and prefix arrays.
*/

class LC3312_GCDPairQueries {
    public int[] gcdValues(int[] nums, long[] queries) {
        int max = 0;

        // Find maximum value
        for (int num : nums) {
            max = Math.max(max, num);
        }

        // Frequency of each number
        int[] freq = new int[max + 1];

        for (int num : nums) {
            freq[num]++;
        }

        // exact[g] = number of pairs whose GCD is exactly g
        long[] exact = new long[max + 1];

        // Process GCD values from large to small
        for (int g = max; g >= 1; g--) {

            // Count numbers divisible by g
            long count = 0;

            for (int multiple = g; multiple <= max; multiple += g) {
                count += freq[multiple];
            }

            // All pairs where both numbers are divisible by g
            exact[g] = count * (count - 1) / 2;

            // Remove pairs whose GCD is a multiple of g
            for (int multiple = 2 * g; multiple <= max; multiple += g) {
                exact[g] -= exact[multiple];
            }
        }

        // Prefix sum:
        // prefix[g] = number of pairs having GCD <= g
        long[] prefix = new long[max + 1];

        for (int g = 1; g <= max; g++) {
            prefix[g] = prefix[g - 1] + exact[g];
        }

        int[] answer = new int[queries.length];

        // Find the GCD at queries[i] position
        for (int i = 0; i < queries.length; i++) {
            long query = queries[i];

            int left = 1;
            int right = max;

            while (left < right) {
                int mid = left + (right - left) / 2;

                // query is 0-indexed
                if (prefix[mid] > query) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            answer[i] = left;
        }
        return answer;
    }

    public static void main(String[] args) {
        LC3312_GCDPairQueries solution = new LC3312_GCDPairQueries();
        int[] nums = { 2, 3, 4, 6 };
        long[] queries = { 0, 1, 2, 3 };
        int[] result = solution.gcdValues(nums, queries);
        for (int val : result) {
            System.out.print(val + " ");
        }
    }
}