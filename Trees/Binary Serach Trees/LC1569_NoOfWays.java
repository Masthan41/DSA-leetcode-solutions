/*
LeetCode 1569 - Number of Ways to Reorder Array to Get Same BST
Approach: We can solve this problem using a recursive approach. The idea is to recursively divide the array into left and right subtrees based on the root (the first element of the array). For each subtree, we calculate the number of ways to reorder the elements while maintaining the BST property. We use Pascal's triangle to compute the combinations of elements in the left and right subtrees. The final result is obtained by multiplying the number of ways for the left and right subtrees and the combinations.

Time Complexity: O(n^2) where n is the length of the input array, due to the recursive division of the array and the computation of combinations using Pascal's triangle.
Space Complexity: O(n^2) for storing Pascal's triangle and the recursive call stack.
*/

import java.util.*;

class LC1569_NoOfWays {
    private static final long MOD = 1_000_000_007L;
    private long[][] PT;

    private long solve(List<Integer> nums) {
        int m = nums.size();

        if (m < 3) {
            return 1;
        }

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        int root = nums.get(0);
        for (int i = 1; i < m; i++) {
            if (nums.get(i) < root) {
                left.add(nums.get(i));
            } else {
                right.add(nums.get(i));
            }
        }

        long leftWays = solve(left) % MOD;
        long rightWays = solve(right) % MOD;

        return (((leftWays * rightWays) % MOD) * PT[m - 1][left.size()]) % MOD;
    }

    public int numOfWays(int[] nums) {
        int n = nums.length;

        // Build Pascal's triangle for nCr under modulo
        PT = new long[n + 1][];
        for (int i = 0; i <= n; i++) {
            PT[i] = new long[i + 1];
            Arrays.fill(PT[i], 1);

            for (int j = 1; j < i; j++) {
                PT[i][j] = (PT[i - 1][j - 1] + PT[i - 1][j]) % MOD;
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int x : nums) {
            list.add(x);
        }

        return (int) ((solve(list) - 1 + MOD) % MOD);
    }

    public static void main(String[] args) {
        LC1569_NoOfWays obj = new LC1569_NoOfWays();
        int[] nums = { 3, 1, 2, 5, 4, 6 };
        System.out.println(obj.numOfWays(nums));
    }
}
