/*
LeetCode 260 - Single Number III
Approach: Bit manipulation using XOR and bit masking
Time complexity: O(n+n) => O(n) as we need to traverse the array twice
Space complexity: O(1)
*/

class LC260_SingleNumberIII{
    public int[] singleNumber(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        long mask = res & -res;

        int first_unique = 0, second_unique = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((nums[i] & mask) == 0) {
                first_unique ^= nums[i];
            } else {
                second_unique ^= nums[i];
            }
        }
        return new int[] { first_unique, second_unique };
    }
    public static void main(String[] args){
        LC260_SingleNumberIII solution = new LC260_SingleNumberIII();
        int[] nums = {1, 2, 1, 3, 2, 5};
        int[] result = solution.singleNumber(nums);
        System.out.println("The two single numbers are: " + result[0] + " and " + result[1]);
    }
}