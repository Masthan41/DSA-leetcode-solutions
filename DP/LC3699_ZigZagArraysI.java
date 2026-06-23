/*
LeetCode 3699 - Number of zigzag arrays I
Approach: Dynamic Programming using prefix sums to count the number of zigzag arrays of length n with values in the range [l, r].

Time complexity: O(n * m) where n is the length of the array and m is the range size (r - l + 1). We iterate through lengths from 3 to n and for each length, we compute prefix sums for both "up" and "down" arrays, which takes O(m) time.

Space complexity: O(m) for storing the "up" and "down" arrays, as well as their prefix sums. We only need to keep track of the current length's arrays, so we can reuse space for previous lengths.
*/

class LC3699_ZigZagArraysI {
    private static final long MOD = 1_000_000_007L;

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;

        if (n == 1) {
            return m;
        }

        long[] up = new long[m];
        long[] down = new long[m];

        // Length = 2
        for (int v = 0; v < m; v++) {
            up[v] = v; // previous value is smaller
            down[v] = m - 1 - v; // previous value is larger
        }

        // Build lengths 3..n
        for (int len = 3; len <= n; len++) {

            long[] prefUp = new long[m + 1];
            long[] prefDown = new long[m + 1];

            for (int i = 0; i < m; i++) {
                prefUp[i + 1] = (prefUp[i] + up[i]) % MOD;
                prefDown[i + 1] = (prefDown[i] + down[i]) % MOD;
            }

            long totalUp = prefUp[m];

            long[] newUp = new long[m];
            long[] newDown = new long[m];

            for (int v = 0; v < m; v++) {

                // Current move is UP => previous move must be DOWN
                newUp[v] = prefDown[v];

                // Current move is DOWN => previous move must be UP
                newDown[v] = (totalUp - prefUp[v + 1] + MOD) % MOD;
            }

            up = newUp;
            down = newDown;
        }

        long ans = 0;

        if (n == 2) {
            for (int v = 0; v < m; v++) {
                ans = (ans + up[v] + down[v]) % MOD;
            }
        } else {
            for (int v = 0; v < m; v++) {
                ans = (ans + up[v] + down[v]) % MOD;
            }
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        LC3699_ZigZagArraysI obj = new LC3699_ZigZagArraysI();
        int n = 3, l = 1, r = 3;
        int res = obj.zigZagArrays(n, l, r);
        System.out.println(res); // Output: 6
    }
}