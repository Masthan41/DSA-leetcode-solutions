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
    public static void main(String[] args) {
        LC136_SingleNumber obj = new LC136_SingleNumber();
        int[] nums = { 2, 2, 1 };
        System.out.println(obj.singleNumber(nums)); // 1

        nums = new int[] { 4, 1, 2, 1, 2 };
        System.out.println(obj.singleNumber(nums)); // 4
    }
}
