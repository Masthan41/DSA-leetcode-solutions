/*
LeetCode 3700 - Number of zigzag arrays I
Approach: Dynamic Programming using prefix sums to count the number of zigzag arrays of length n with values in the range [l, r].

Time complexity: O(n * m) where n is the length of the array and m is the range size (r - l + 1). We iterate through lengths from 3 to n and for each length, we compute prefix sums for both "up" and "down" arrays, which takes O(m) time.

Space complexity: O(m) for storing the "up" and "down" arrays, as well as their prefix sums. We only need to keep track of the current length's arrays, so we can reuse space for previous lengths.
*/

class LC3700_ZigZagArraysII {
    private static final long MOD = 1_000_000_007L;

    private long[][] multiply(long[][] A, long[][] B) {
        int n = A.length;
        long[][] C = new long[n][n];

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {
                if (A[i][k] == 0)
                    continue;

                long aik = A[i][k];
                for (int j = 0; j < n; j++) {
                    if (B[k][j] == 0)
                        continue;

                    C[i][j] = (C[i][j] + aik * B[k][j]) % MOD;
                }
            }
        }
        return C;
    }

    private long[][] power(long[][] base, long exp) {
        int n = base.length;
        long[][] res = new long[n][n];

        for (int i = 0; i < n; i++) {
            res[i][i] = 1;
        }

        while (exp > 0) {
            if ((exp & 1) == 1) {
                res = multiply(res, base);
            }
            base = multiply(base, base);
            exp >>= 1;
        }

        return res;
    }

    private long[] multiplyMatVec(long[][] A, long[] v) {
        int n = A.length;
        long[] res = new long[n];

        for (int i = 0; i < n; i++) {
            long cur = 0;
            for (int j = 0; j < n; j++) {
                cur = (cur + A[i][j] * v[j]) % MOD;
            }
            res[i] = cur;
        }

        return res;
    }

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;
        int N = 2 * m;

        long[][] T = new long[N][N];

        // Upper-right block:
        // U_new[v] = sum(D[u]) for u < v
        for (int v = 0; v < m; v++) {
            for (int u = 0; u < v; u++) {
                T[v][m + u] = 1;
            }
        }

        // Lower-left block:
        // D_new[v] = sum(U[u]) for u > v
        for (int v = 0; v < m; v++) {
            for (int u = v + 1; u < m; u++) {
                T[m + v][u] = 1;
            }
        }

        // State for length = 2
        long[] state = new long[N];

        for (int v = 1; v <= m; v++) {
            state[v - 1] = v - 1; // U2[v]
            state[m + v - 1] = m - v; // D2[v]
        }

        long[][] P = power(T, n - 2);
        long[] result = multiplyMatVec(P, state);

        long ans = 0;
        for (long x : result) {
            ans = (ans + x) % MOD;
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        LC3700_ZigZagArraysII obj = new LC3700_ZigZagArraysII();
        int n = 3, l = 1, r = 3;
        int res = obj.zigZagArrays(n, l, r);
        System.out.println(res);
    }
}