/*
LeetCode 3756 - Concatenate Non-zero Digits and multiply by sum II
Approach: Use prefix sums to calculate the number formed by non-zero digits and the sum of digits in the given range. For each query, we can compute the result using these prefix sums.

Time Complexity: O(n + q) where n is the length of the string s and q is the number of queries. We preprocess the prefix sums in O(n) and answer each query in O(1).
Space Complexity: O(n) for storing prefix sums and counts.
*/

class LC3756_ConcatinateDigitsII {
    static final long MOD = 1000000007;

    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();

        int[] nonZeroCount = new int[n]; // non-zero digits count in s[0..i]
        long[] numberUpTo = new long[n]; // number formed from non-zero digits in s[0..i]
        long[] digitSumUpTo = new long[n]; // digit sum of s[0..i]
        long[] pow10 = new long[n + 1]; // 10^i

        pow10[0] = 1;
        for (int i = 1; i <= n; i++)
            pow10[i] = (pow10[i - 1] * 10) % MOD;

        nonZeroCount[0] = (s.charAt(0) != '0') ? 1 : 0;
        numberUpTo[0] = s.charAt(0) - '0';
        digitSumUpTo[0] = s.charAt(0) - '0';

        for (int i = 1; i < n; i++) {
            int digit = s.charAt(i) - '0';
            nonZeroCount[i] = nonZeroCount[i - 1] + (digit != 0 ? 1 : 0);
        }

        for (int i = 1; i < n; i++) {
            int digit = s.charAt(i) - '0';
            if (digit != 0)
                numberUpTo[i] = (numberUpTo[i - 1] * 10 + digit) % MOD;
            else
                numberUpTo[i] = numberUpTo[i - 1];
        }

        for (int i = 1; i < n; i++) {
            digitSumUpTo[i] = digitSumUpTo[i - 1] + (s.charAt(i) - '0');
        }

        int q = queries.length;
        int[] result = new int[q];

        for (int i = 0; i < q; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            int startCount = (l == 0) ? 0 : nonZeroCount[l - 1];
            long numBefore = (l == 0) ? 0 : numberUpTo[l - 1];

            int endCount = nonZeroCount[r];
            int subStrLen = endCount - startCount;

            if (subStrLen == 0) {
                result[i] = 0;
                continue;
            }

            long x = (numberUpTo[r] - (numBefore * pow10[subStrLen] % MOD) + MOD) % MOD;
            long sum = digitSumUpTo[r] - ((l == 0) ? 0 : digitSumUpTo[l - 1]);

            result[i] = (int) ((x * sum) % MOD);

        }
        return result;
    }

    public static void main(String[] args) {
        LC3756_ConcatinateDigitsII obj = new LC3756_ConcatinateDigitsII();
        String s = "123045";
        int[][] queries = {{0, 2}, {1, 4}, {0, 5}};
        int[] result = obj.sumAndMultiply(s, queries);
        System.out.println("The results for the queries are: " + Arrays.toString(result));
    }
}