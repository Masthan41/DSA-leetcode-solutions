/*
LeetCode 3702 - Longest Subsequence with non zero XOR
Approach: The approach to solve this problem is based on the observation that if the XOR of all elements in the input array is zero, then we can remove one element to make the XOR non-zero. If the XOR is already non-zero, then we can take all elements as part of the subsequence. Additionally, if all elements are zero, then the longest subsequence with non-zero XOR is zero.
Time Complexity: O(n) since we are iterating through the input array to calculate the XOR of all elements and check if all elements are zero.
Space Complexity: O(1) since we are using a constant amount of space to store the XOR value and the boolean flag for checking if all elements are zero.
*/

class LC3702_LongestSubSequence {
    public int longestSubsequence(int[] nums) {
        int n = nums.length;

        int resultXor = 0;
        boolean allZeroes = true;

        for (int num : nums) {
            resultXor = (resultXor ^ num);

            if (num != 0) {
                allZeroes = false;
            }
        }
        if (allZeroes) {
            return 0;
        }
        return resultXor == 0 ? n - 1 : n;
    }

    public static void main(String[] args) {
        LC3702_LongestSubSequence solution = new LC3702_LongestSubSequence();
        int[] nums = { 1, 2, 3, 4 };
        int result = solution.longestSubsequence(nums);
        System.out.println("Longest Subsequence Length: " + result);
    }
}
