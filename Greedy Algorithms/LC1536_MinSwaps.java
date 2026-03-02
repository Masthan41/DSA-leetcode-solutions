/*
LeetCode 1536 - Minimum Swaps to Arrange a Binary Grid
Approach: Greedy approach to place rows in correct positions
Time Complexity: O(n^2)
Space Complexity: O(n)
*/

class LC1536_MinSwaps {
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int zeros[] = new int[n];

        // first count no. of trailing zeroes
        for (int i = 0; i < n; i++) {
            int c = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 0) {
                    c++;
                } else {
                    break;
                }
            }
            zeros[i] = c;
        }
        int swaps = 0;

        // second place correct row at each position
        for (int i = 0; i < n; i++) {
            int req = n - 1 - i;
            int j = i;

            while (j < n && zeros[j] < req) {
                j++;
            }

            if (j == n)
                return -1;

            while (j > i) {
                int temp = zeros[j];
                zeros[j] = zeros[j - 1];
                zeros[j - 1] = temp;

                swaps++;
                j--;
            }
        }
        return swaps;
    }

    public static void main(String[] args) {
        LC1536_MinSwaps obj = new LC1536_MinSwaps();
        int grid[][] = { { 0, 0, 1 }, { 1, 1, 0 }, { 1, 0, 0 } };
        System.out.println(obj.minSwaps(grid));
    }
}
