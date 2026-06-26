/*
LeetCode 3739 - Count Subarrays With Majority Element II
Approach: Prefix Sum and HashMap
Time Complexity: O(n) where n is the length of the array
Space Complexity: O(n) for the HashMap
*/


import java.util.*;

class LC3739_CountSubarraysII {
    public long countMajoritySubarrays(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        long result = 0;
        long validLeftPoints = 0;
        int currSum = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                validLeftPoints += map.getOrDefault(currSum, 0);
                currSum++;
            } else {
                currSum--;
                validLeftPoints -= map.getOrDefault(currSum, 0);
            }
            map.merge(currSum, 1, Integer::sum);
            result += validLeftPoints;
        }
        return result;
    }

    public static void main(String[] args) {
        LC3739_CountSubarraysII solution = new LC3739_CountSubarraysII();
        int[] nums = { 1, 2, 3, 2, 2 };
        int target = 2;
        long result = solution.countMajoritySubarrays(nums, target);
        System.out.println("Number of majority subarrays: " + result);
    }
}
