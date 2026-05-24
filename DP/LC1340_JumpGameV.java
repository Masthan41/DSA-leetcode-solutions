/*
LeetCode 1340 - Jump Game V
Approach: We can use dynamic programming to solve this problem. We create an array `t` where `t[i]` represents the maximum number of jumps that can be made starting from index `i`. We sort the indices of the array based on their values, and then for each index, we check both left and right directions for possible jumps. We update our `t` array accordingly based on the conditions given in the problem.
Time Complexity: O(n log n) due to sorting the indices, and O(n * d) for the nested loops, resulting in O(n log n + n * d).
Space Complexity: O(n) for the `t` array and the sorted indices array.
*/

import java.util.*;

class LC1340_JumpGameV {
    public int maxJumps(int[] arr, int d) {
        int n = arr.length;
        // t[i] = maximum jumps starting from index i
        int[] t = new int[n];
        Arrays.fill(t, 1);

        int[][] vec = new int[n][2];
        for (int i = 0; i < n; i++) {
            vec[i][0] = arr[i];
            vec[i][1] = i;
        }
        Arrays.sort(vec, (a, b) -> a[0] - b[0]);

        for (int[] it : vec) {
            int i = it[1];

            // move left
            for (int j = i - 1; j >= Math.max(0, i - d); j--) {
                // same breaking condition
                if (arr[j] >= arr[i])
                    break;
                t[i] = Math.max(t[i], 1 + t[j]);
            }

            // move right
            for (int j = i + 1; j <= Math.min(n - 1, i + d); j++) {
                // same breaking condition
                if (arr[j] >= arr[i])
                    break;
                t[i] = Math.max(t[i], 1 + t[j]);
            }
        }
        return Arrays.stream(t).max().getAsInt();
    }

    public static void main(String[] args) {
        LC1340_JumpGameV solution = new LC1340_JumpGameV();
        int[] arr = { 6, 4, 14, 6, 8, 13, 9, 7, 10, 6, 12 };
        int d = 2;
        System.out.println(solution.maxJumps(arr, d)); // Output: 4
    }
}
