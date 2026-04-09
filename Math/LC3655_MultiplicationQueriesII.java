/*
LeetCode 3655 - XOR after Multiplication Queries II
Approach: We can optimize the multiplication queries by grouping them based on the value of k. For small values of k (less than sqrt(n)), we can directly apply the multiplications to the nums array. For larger values of k, we can use a difference array to keep track of the multiplications and apply them in a single pass after processing all queries.

Time Complexity: O(m * sqrt(n) + n) where m is the number of queries and n is the length of the nums array. The first part accounts for processing the queries, and the second part accounts for applying the multiplications to the nums array.

Space Complexity: O(n + sqrt(n)) for the difference array and the groups of queries based on k.
*/

import java.util.*;

class LC3655_MultiplicationQueriesII {
    final int mod = 1000000007;

    long power(long base, long exp) {
        long res = 1;
        base %= mod;
        while (exp > 0) {
            if (exp % 2 == 1)
                res = (res * base) % mod;
            base = (base * base) % mod;
            exp /= 2;
        }
        return res;
    }

    public int xorAfterQueries(int[] nums, int[][] queries) {
        int n = nums.length;
        int T = (int) Math.sqrt(n);

        List<int[]>[] groups = new ArrayList[T];
        for (int i = 0; i < T; i++)
            groups[i] = new ArrayList<>();

        for (int[] q : queries) {
            int l = q[0], r = q[1], k = q[2], v = q[3];
            if (k < T) {
                groups[k].add(new int[] { l, r, v });
            } else {
                for (int i = l; i <= r; i += k) {
                    nums[i] = (int) ((1L * nums[i] * v) % mod);
                }
            }
        }

        long[] dif = new long[n + T];
        for (int k = 1; k < T; k++) {
            if (groups[k].isEmpty())
                continue;
            Arrays.fill(dif, 1L);
            for (int[] q : groups[k]) {
                int l = q[0], r = q[1], v = q[2];
                dif[l] = (dif[l] * v) % mod;
                int R = ((r - l) / k + 1) * k + l;
                dif[R] = (dif[R] * power(v, mod - 2)) % mod;
            }
            for (int i = k; i < n; i++) {
                dif[i] = (dif[i] * dif[i - k]) % mod;
            }
            for (int i = 0; i < n; i++) {
                nums[i] = (int) ((1L * nums[i] * dif[i]) % mod);
            }
        }

        int ans = 0;
        for (int x : nums)
            ans ^= x;
        return ans;
    }

    public static void main(String[] args) {
        LC3655_MultiplicationQueriesII lc = new LC3655_MultiplicationQueriesII();
        System.out.println(lc.xorAfterQueries(new int[] { 1, 2, 3, 4, 5 },
                new int[][] { { 0, 4, 1, 2 }, { 0, 3, 2, 2 }, { 0, 1, 1, 2 } }));
    }
}
