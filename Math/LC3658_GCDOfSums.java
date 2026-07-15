/*
LeetCode 3658 - GCD of odd and even Sums
Approach: Since the sum of the first n odd numbers is n² and the sum of the first n even numbers is n(n+1), we can compute the GCD of these two sums. The GCD of n² and n(n+1) simplifies to n, as n is a common factor in both expressions.
Time Complexity: O(1) since we can directly compute the result.
Space Complexity: O(1) as we only use a constant amount of extra space.
*/

class LC3658_GCDOfSums {
    public int gcdOfOddEvenSums(int n) {
        // Sum of first n odd numbers = n²
        // Sum of first n even numbers = n(n+1)
        // gcd(n², n(n+1)) = n
        return n;
    }

    public static void main(String[] args) {
        LC3658_GCDOfSums obj = new LC3658_GCDOfSums();
        int n = 5; // Example input
        int result = obj.gcdOfOddEvenSums(n);
        System.out.println("GCD of sums for n = " + n + " is: " + result);
    }
}