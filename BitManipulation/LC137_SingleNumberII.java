/*
LeetCode 137 - Single Number II
Approach: Bit manipulation using bit counting
Time complexity: O(n) as we need to traverse the array once
Space complexity: O(1)
*/

class LC137_SingleNumberII{
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int sum = 0;
            for (final int num : nums) {
                sum += num >> i & 1;
                
            }
            sum %= 3;
            ans |= sum << i;
        }
        return ans;
    }
    public static void main(String[] args){
        LC137_SingleNumberII solution = new LC137_SingleNumberII();
        int[] nums = {2, 2, 3, 2};
        System.out.println(solution.singleNumber(nums));
    }
}