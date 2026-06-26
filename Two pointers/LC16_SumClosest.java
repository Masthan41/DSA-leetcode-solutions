/*
LeetCode 16 - 3Sum Closest
Approach: Two Pointers after sorting the array and looking for the closest sum to the target by comparing the absolute difference between the current sum and the target
Time Complexity: O(n^2) because of the nested loops and the sorting step
Space Complexity: O(1) as we are using constant space for variables and not using any additional data structures
*/


import java.util.*;

class LC16_SumClosest {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length; i++) {
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (Math.abs(target - sum) < Math.abs(target - closestSum)) {
                    closestSum = sum;
                }

                if (sum < target) {
                    j++;
                } else if (sum > target) {
                    k--;
                } else {
                    return target;
                }
            }
        }
        return closestSum;
    }

    public static void main(String[] args) {
        LC16_SumClosest obj = new LC16_SumClosest();
        int[] nums = { -1, 2, 1, -4 };
        int target = 1;
        int res = obj.threeSumClosest(nums, target);
        System.out.println(res);
    }
}
