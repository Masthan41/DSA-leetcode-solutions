/*
LeetCode 453 - Minimum Moves to Equal Array Elements
Approach: The minimum number of moves to make all array elements equal can be calculated by finding the sum of the differences between each element and the minimum element in the array. Each move consists of incrementing n - 1 elements by 1, which is equivalent to decrementing one element by 1. Therefore, the total number of moves required is the sum of all elements minus n times the minimum element.

Time Complexity: O(N) where N is the number of elements in the array, as we need to iterate through the array to find the minimum element and calculate the sum of all elements.
Space Complexity: O(1) as we are using a constant amount of extra space for variables.
*/

class LC453_MinimumMoves {
    public int minMoves(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int minEle = Integer.MAX_VALUE;

        for (int num : nums) {
            minEle = Math.min(num, minEle);
            sum += num;
        }
        return sum - (n * minEle);
    }

    public static void main(String[] args) {
        LC453_MinimumMoves solution = new LC453_MinimumMoves();
        // Test case 1
        int[] nums = { 1, 2, 3 };
        System.out.println("Minimum moves to equal array elements: " + solution.minMoves(nums)); // Output: 3

        // Test case 2
        int[] nums2 = { 5, 6, 8 };
        System.out.println("Minimum moves to equal array elements: " + solution.minMoves(nums2)); // Output: 5

        // Test case 3
        int[] nums3 = { 1, 1, 1 };
        System.out.println("Minimum moves to equal array elements: " + solution.minMoves(nums3)); // Output: 0

        // Test case 4
        int[] nums4 = { 1, 2, 3, 4 };
        System.out.println("Minimum moves to equal array elements: " + solution.minMoves(nums4)); // Output: 6

        // Test case 5
        int[] nums5 = { 1, 2, 3, 4, 5 };
        System.out.println("Minimum moves to equal array elements: " + solution.minMoves(nums5)); // Output: 10
    }
}
