/*
LeetCode 3867 - Sum of GCD of formed pairs
Approach: To calculate the sum of GCDs of all pairs formed by the elements of the array, we can use a prefix approach to efficiently compute the GCDs.
Time Complexity: O(n log(max(nums))) where n is the length of the input array and max(nums) is the maximum value in the array. The log(max(nums)) factor comes from the GCD computation.
Space Complexity: O(n) for storing the prefix GCDs.
*/

import java.util.*;

class LC3867_SumOfGCD {
    public int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    public long gcdSum(int[] nums) {

        int n = nums.length;
        int prefix[] = new int[n];

        int max = 0;

        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
            prefix[i] = gcd(nums[i], max);
        }

        Arrays.sort(prefix);

        int i = 0, j = n - 1;
        long sum = 0;

        while (i < j) {
            sum += gcd(prefix[i], prefix[j]);
            i++;
            j--;
        }

        return sum;
    }

    public static void main(String[] args) {
        LC3867_SumOfGCD obj = new LC3867_SumOfGCD();
        int[] nums = { 12, 15, 18 };
        long result = obj.gcdSum(nums);
        System.out.println("Sum of GCDs: " + result);
    }
}