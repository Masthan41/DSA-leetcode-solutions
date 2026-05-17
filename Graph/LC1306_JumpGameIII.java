/*
LeetCode 1306 - Jump Game III
Approach: We use Depth First Search (DFS) to explore all possible jumps from the starting index. We mark visited indices by negating the value at that index to avoid cycles. The DFS continues until we either find a zero (success) or exhaust all possibilities (failure).

Time Complexity: O(n) - we visit each index at most once.
Space Complexity: O(n) - for the recursion stack in the worst case.
*/

class LC1306_JumpGameIII {
    private boolean dfs(int arr[], int i) {
        if (i < 0 || i >= arr.length || arr[i] < 0) {
            return false;
        }
        if (arr[i] == 0) {
            return true;
        }
        arr[i] *= -1;
        boolean left = dfs(arr, i - arr[i]);
        boolean right = dfs(arr, i + arr[i]);

        return left || right;
    }

    public boolean canReach(int[] arr, int start) {
        return dfs(arr, start);
    }

    public static void main(String[] args) {
        LC1306_JumpGameIII solution = new LC1306_JumpGameIII();
        int[] arr = { 4, 2, 3, 0, 3, 1, 2 };
        int start = 5;
        boolean result = solution.canReach(arr, start);
        System.out.println(result); // Output: true
    }
}