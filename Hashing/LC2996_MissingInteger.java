/*
LeetCode 2996 - Find Smallest missing Integer in Array
Approach: Use a HashSet to store all elements in the array. Then, starting from the first element, keep adding consecutive integers until we find one that's not in the set.
Time Complexity: O(n) where n is the length of the array.
Space Complexity: O(n) for the HashSet.
*/

import java.util.*;

class LC2996_MissingInteger {
    public int missingInteger(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int seq = nums[0];
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] == nums[j - 1] + 1) {
                seq += nums[j];
            } else {
                break;
            }
        }

        while (set.contains(seq)) {
            seq++;
        }
        return seq;
    }

}
