/*
LeetCode 136 - Single Number
Approach: XOR cancellation
Time complexity: O(n)
Space complexity: O(1)
*/

class LC136_SingleNumber {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res = res ^ nums[i];
        }
        return res;
    }
}
