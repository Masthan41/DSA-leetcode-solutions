/*
LeetCode 1588 - Sum of All Odd Length Subarrays
Approach: For each element, calculate the number of odd-length subarrays that include it and add its contribution to the total sum.
Time complexity: O(n) where n is the input number
Space complexity: O(1) for the in-place modification
*/

class LC1588_OddSubarray {
    public int sumOddLengthSubarrays(int[] arr) {
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {

            // total subarrays containing arr[i];
            int total = (i + 1) * (arr.length - i);

            // total odd length subarrays
            int odd = (total + 1) / 2;

            ans += arr[i] * odd;
        }
        return ans;
    }

    public static void main(String[] args) {
        LC1588_OddSubarray obj = new LC1588_OddSubarray();
        int[] arr = { 1, 4, 2, 5, 3 };
        System.out.println(obj.sumOddLengthSubarrays(arr));
    }
}
