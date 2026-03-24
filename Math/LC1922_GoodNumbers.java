/*
LeetCode 1922 - Count Good Numbers
Approach: Use Fast Exponentiation to calculate the number of good numbers based on the positions of even and odd indices.

Time Complexity: O(log n) as we are using fast exponentiation to calculate the powers of 5 and 4.
Space Complexity: O(1) as we are using a constant amount of space to store variables and the result.
*/

class LC1922_GoodNumbers {
    final int MOD = 1000000007;

    public long findpow(long a, long b) {
        if (b == 0)
            return 1;

        long half = findpow(a, b / 2);
        long res = (half * half) % MOD;

        if (b % 2 == 1) {
            res = (res * a) % MOD;
        }

        return res;
    }

    public int countGoodNumbers(long n) {

        long res = (findpow(5, (n + 1) / 2) * findpow(4, n / 2)) % MOD;
        return (int) res;
    }

    public static void main(String[] args) {
        LC1922_GoodNumbers obj = new LC1922_GoodNumbers();
        int result = obj.countGoodNumbers(4);
        int result2 = obj.countGoodNumbers(456);
        System.out.println(result); // Output: 400
        System.out.println(result2); // Output: 790023880
    }
}
