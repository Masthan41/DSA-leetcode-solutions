/*
LeetCode 189 - Rotate Array
Approach: Reverse the array and then reverse the first k elements and the remaining elements
Time complexity: O(n+n+n) => O(n) as we need to traverse the array three times
Space complexity: O(1)
*/

class LC189_RotateArray {
    public void swap(int nums[], int i, int j) {
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;

            i++;
            j--;
        }
    }

    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        swap(nums, 0, n - 1);
        swap(nums, 0, k - 1);
        swap(nums, k, n - 1);
    }
    public static void main(String[] args){
        LC189_RotateArray solution = new LC189_RotateArray();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;
        solution.rotate(nums, k);
        System.out.print("Rotated array: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
