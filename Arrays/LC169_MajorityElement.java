/*
Leetcode 169 - Majority Element
Approach - Boyer-Moore Voting Algorithm

Time Complexity: O(n)
Space Complexity: O(1)
*/

class LC169_MajorityElement {
    public int majorityElement(int[] nums) {
        int ans = nums[0];
        int c = 0;
        for (int i = 0; i < nums.length; i++) {
            if (c == 0) {
                ans = nums[i];
            }

            if (nums[i] == ans) {
                c++;
            } else {
                c--;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        LC169_MajorityElement obj = new LC169_MajorityElement();
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(obj.majorityElement(nums));
    }
}