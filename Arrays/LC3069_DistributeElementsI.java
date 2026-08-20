/*
Leetcode 3069 - Distribute Elements Into Two Arrays I
Appraoch : Use two arrays to store the elements based on the condition. Iterate through the input array and compare the last elements of both arrays to decide where to place the current element. Finally, combine both arrays into a result array.
Time Complexity: O(n) for iterating through the input array.
Space Complexity: O(n) for storing the two arrays and the result array.
*/

class LC3069_DistributeElementsI {
    public int[] resultArray(int[] nums) {
        int n = nums.length;
        int left[] = new int[n];
        int right[] = new int[n];
        int x = 0, y = 0;
        left[x++] = nums[0];
        right[y++] = nums[1];
        for (int i = 2; i < n; i++) {
            if (left[x - 1] > right[y - 1]) {
                left[x++] = nums[i];
            } else {
                right[y++] = nums[i];
            }
        }

        int res[] = new int[n];
        int k = 0;
        for (int i = 0; i < x; i++) {
            res[k++] = left[i];
        }
        for (int i = 0; i < y; i++) {
            res[k++] = right[i];
        }
        return res;
    }

    public static void main(String[] args) {
        LC3069_DistributeElementsI obj = new LC3069_DistributeElementsI();
        int[] nums = { 1, 2, 3, 4, 5 };
        int[] result = obj.resultArray(nums);
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}
