/*
LeetCode 1524 - Number of Sub-arrays With Odd Sum
Approach: Use a prefix sum to keep track of the sum of elements up to each index. Count the number of sub-arrays with odd sums by checking the parity of the prefix sums.
Time complexity: O(n) where n is the length of the array
Space complexity: O(n) for the prefix sum array
*/

class LC1524_OddSumSubarrays {
    public int numOfSubarrays(int[] arr) {
        int n = arr.length;

        int prefix[] = new int[n];
        prefix[0] = arr[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + arr[i];
        }

        int sub = 0;
        int odd = 0, even = 1; // since 0 is an even number
        for (int i = 0; i < n; i++) {
            if (prefix[i] % 2 != 0) {
                sub = (sub + even) % 1000000007;
                odd++;
            } else {
                sub = (sub + odd) % 1000000007;
                even++;
            }
        }
        return sub;
    }

    public static void main(String[] args) {
        LC1524_OddSumSubarrays obj = new LC1524_OddSumSubarrays();
        int[] arr = { 1, 3, 5 };
        System.out.println(obj.numOfSubarrays(arr)); // Output: 4
    }
}