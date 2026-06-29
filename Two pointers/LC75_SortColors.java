/*
LeetCode 75 - Sort Colors with 0s, 1s and 2s
Approach: Dutch National Flag Algorithm (3-way partitioning)
Time complexity: O(n) - We traverse the array once.
Space complexity: O(1) - We use only a constant amount of extra space for the pointers.
*/

class LC75_SortColors {
    public void swap(int nums[], int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;
        while (mid <= high) {
            if (nums[mid] == 0) {
                swap(nums, low, mid);
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                swap(nums, mid, high);
                high--;
            }
        }
    }

    public static void main(String[] args) {
        LC75_SortColors obj = new LC75_SortColors();
        int nums[] = { 2, 0, 2, 1, 1, 0 };
        obj.sortColors(nums);
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }
}
