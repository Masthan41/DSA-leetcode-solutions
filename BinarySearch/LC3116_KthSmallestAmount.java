/*
LeetCode 3116 - Kth Smallest Amount with single denomination combination
Approach: To solve the problem of finding the kth smallest amount, we can use a binary search approach. We search for the kth smallest amount in the range [1, maxCoin * k]. For each candidate amount, we count how many valid amounts are smaller than it using the inclusion-exclusion principle. The number of valid amounts is calculated by considering all possible combinations of coins and their least common multiples.
Time Complexity: O(log(maxCoin * k) * 2^n * n * log(maxCoin)) where n is the number of coins.
Space Complexity: O(1) as we are using a constant amount of extra space.    
*/


class LC3116_KthSmallestAmount {
    private long countSmaller(long mid, int[] coins) {
        long correctedCount = 0;
        int n = coins.length;

        // 2^n * n * log(maxCoin)
        for (int expressions = 1; expressions <= (1 << n) - 1; expressions++) { // 2^n-1 expressions
            long lcm = 0;
            long order = 0; // even or odd order of expressions

            for (int i = 0; i < n; i++) {
                if ((expressions & (1 << i)) != 0) {
                    order++; // we have taken ith coin

                    if (lcm == 0) {
                        lcm = coins[i];
                    } else {
                        lcm = lcm * coins[i] / gcd(lcm, coins[i]);
                    }
                }
            }

            if (order % 2 == 0) { // even then subtract
                correctedCount -= mid / lcm;
            } else {
                correctedCount += mid / lcm;
            }
        }

        return correctedCount;
    }

    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public long findKthSmallest(int[] coins, int k) {
        long result = -1;

        int maxCoin = 0;
        for (int c : coins)
            maxCoin = Math.max(maxCoin, c);

        long l = 1;
        long r = (long) maxCoin * k;

        // log(maxCoin * k) * 2^n * n * log(maxCoin)
        while (l <= r) {
            long mid = l + (r - l) / 2;

            if (countSmaller(mid, coins) >= k) { // left side me we can find kth smallest element
                result = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        LC3116_KthSmallestAmount solution = new LC3116_KthSmallestAmount();
        int[] coins = { 1, 2, 3 };
        int k = 5;
        long kthSmallestAmount = solution.findKthSmallest(coins, k);
        System.out.println("The " + k + "th smallest amount is: " + kthSmallestAmount);
    }
}
