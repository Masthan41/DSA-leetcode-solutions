/*
LeetCode 2055 - Plates Between Candles
Approach: Use prefix sum and arrays to find the nearest candles on both
sides of each query, then calculate the number of plates between them.

Time Complexity: O(n + q) - preprocess the string once and answer each query in O(1).
Space Complexity: O(n) - for prefix sum and candle position arrays.
*/

class LC2055_PlatesBWCandles {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length();
        int m = queries.length;
        int res[] = new int[m];
        int left[] = new int[n];
        int right[] = new int[n];
        int prefix[] = new int[n];

        int lastCandle = -1;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '|') {
                lastCandle = i;
            }
            left[i] = lastCandle;
        }

        int lastCandle2 = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '|') {
                lastCandle2 = i;
            }
            right[i] = lastCandle2;
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '*') {
                count++;
            }
            prefix[i] = count;
        }

        for (int i = 0; i < m; i++) {
            int leftq = queries[i][0];
            int rightq = queries[i][1];

            int L = right[leftq];
            int R = left[rightq];

            if (L == -1 || R == -1 || L >= R) {
                res[i] = 0;
            } else {
                res[i] = prefix[R] - prefix[L];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LC2055_PlatesBWCandles solution = new LC2055_PlatesBWCandles();
        String s = "**|**|***|";
        int[][] queries = { { 2, 5 }, { 5, 9 } };
        int[] result = solution.platesBetweenCandles(s, queries);
        System.out.println("Number of plates between candles for each query: " + Arrays.toString(result));
    }
}
