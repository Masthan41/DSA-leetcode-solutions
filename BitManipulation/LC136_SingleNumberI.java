/*
LeetCode 136 - Single Number I
Approach: Bit manipulation using XOR
Time complexity: O(n) as we need to traverse the array once
Space complexity: O(1)
*/

class LC136_SingleNumberI{
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res = res ^ nums[i];
        }
        return res;
    }
    public static void main(String[] args){
        LC136_SingleNumberI solution = new LC136_SingleNumberI();
        int[] nums = {2, 2, 1};
        System.out.println(solution.singleNumber(nums));
    }
}