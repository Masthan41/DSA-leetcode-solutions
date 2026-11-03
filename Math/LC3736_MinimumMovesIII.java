/*
LeetCode 3736 - Minimum Moves to Equal Array Elements III
Approach: Find the maximum element in the array and calculate the difference between each element and the maximum. The sum of these differences will give the minimum number of moves required to make all elements equal.

Time Complexity: O(n) where n is the number of elements in the array, as we need to iterate through the array to find the maximum and calculate the moves.
Space Complexity: O(1) as we are using a constant amount of space for variables.                                                        
*/

class LC3736_MinimumMovesIII {
    public int minMoves(int[] nums) {
        int maxEle = 0;
        for (int num : nums) {
            maxEle = Math.max(maxEle, num);
        }
        int moves = 0;
        for (int num : nums) {
            moves += (maxEle - num);
        }
        return moves;
    }

    public static void main(String[] args) {
        LC3736_MinimumMovesIII solution = new LC3736_MinimumMovesIII();
        // Test case 1
        int[] nums = { 1, 2, 3 };
        System.out.println("Minimum moves to equal array elements: " + solution.minMoves(nums)); // Output: 2

        // Test case 2
        int[] nums2 = { 5, 6, 8 };
        System.out.println("Minimum moves to equal array elements: " + solution.minMoves(nums2)); // Output: 3

        // Test case 3
        int[] nums3 = { 1, 1, 1 };
        System.out.println("Minimum moves to equal array elements: " + solution.minMoves(nums3)); // Output: 0

        // Test case 4
        int[] nums4 = { 1, 2, 3, 4 };
        System.out.println("Minimum moves to equal array elements: " + solution.minMoves(nums4)); // Output: 4

        // Test case 5
        int[] nums5 = { 1, 2, 3, 4, 5 };
        System.out.println("Minimum moves to equal array elements: " + solution.minMoves(nums5)); // Output: 6

    }
}