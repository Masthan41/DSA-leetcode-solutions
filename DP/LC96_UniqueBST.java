/*
LeetCode 96 - Unique Binary Search Trees
Approach: Use dynamic programming to calculate the number of unique BSTs that can be formed with n nodes.

Time Complexity: O(n^2) where n is the number of nodes, as we need to compute the number of unique BSTs for each number of nodes from 1 to n.

Space Complexity: O(n) for the dp array.
*/

class LC96_UniqueBST {
    public int numTrees(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        LC96_UniqueBST obj = new LC96_UniqueBST();

        System.out.println(obj.numTrees(3));
        System.out.println(obj.numTrees(4));
    }
}
