/*
LeetCode 2161 - Partition Array Around Pivot
Approach: Count elements less than and equal to the pivot, then place them in the correct positions.
Time Complexity: O(n) where n is the length of the input array.
Space Complexity: O(1) excluding output array
*/

class LC2161_PartitionArray {
    public int[] pivotArray(int[] nums, int pivot) {
        int res[] = new int[nums.length];
        int lessElement = 0, equalElement = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < pivot) {
                lessElement++;
            } else if (nums[i] == pivot) {
                equalElement++;
            }
        }

        int i = 0;
        int j = lessElement;
        int k = lessElement + equalElement;

        for (int num : nums) {
            if (num < pivot) {
                res[i] = num;
                i++;
            } else if (num == pivot) {
                res[j] = num;
                j++;
            } else {
                res[k] = num;
                k++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LC2161_PartitionArray solution = new LC2161_PartitionArray();
        int[] nums = { 9, 12, 5, 10, 14, 3, 10 };
        int pivot = 10;
        int[] result = solution.pivotArray(nums, pivot);
        System.out.print("Output: [");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            if (i < result.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
