/*
LeetCode 1594 - Maximum Product of a Path in a Grid
Approach: Use dynamic programming to track the maximum and minimum products at each cell.
Time Complexity: O(m*n) 
Space Complexity: O(m*n)
*/


//Custom Pair class (Not needed in leetcode, but used here for clarity)
class Pair<K, V> {
    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}

class LC1594_MaxPositiveProduct {
    final int MOD = 1000000007;

    public int maxProductPath(int[][] grid) {
        // Initialize the DP table
        Pair<Long, Long>[][] t = new Pair[grid.length][grid[0].length];

        // Base case: starting point
        t[0][0] = new Pair<>((long) grid[0][0], (long) grid[0][0]);

        for (int j = 1; j < grid[0].length; j++) {
            t[0][j] = new Pair<>(t[0][j - 1].getKey() * grid[0][j], t[0][j - 1].getValue() * grid[0][j]);
        }

        for (int i = 1; i < grid.length; i++) {
            t[i][0] = new Pair<>(t[i - 1][0].getKey() * grid[i][0], t[i - 1][0].getValue() * grid[i][0]);
        }

        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[0].length; j++) {
                long upMax = t[i - 1][j].getKey();
                long upMin = t[i - 1][j].getValue();

                long leftMax = t[i][j - 1].getKey();
                long leftMin = t[i][j - 1].getValue();

                t[i][j] = new Pair<>(
                        Math.max(Math.max(upMax * grid[i][j], upMin * grid[i][j]),
                                Math.max(leftMax * grid[i][j], leftMin * grid[i][j])),
                        Math.min(Math.min(upMax * grid[i][j], upMin * grid[i][j]),
                                Math.min(leftMax * grid[i][j], leftMin * grid[i][j])));
            }
        }
        // Get the result from the bottom-right corner
        long maxProd = t[grid.length - 1][grid[0].length - 1].getKey();

        // If the result is negative, return -1, otherwise return the result modulo MOD
        return maxProd < 0 ? -1 : (int) (maxProd % MOD);
    }

    public static void main(String[] args) {
        LC1594_MaxPositiveProduct solution = new LC1594_MaxPositiveProduct();
        int[][] grid = { { -1, -2, -3 }, { -2, -3, -3 }, { -3, -3, -2 } };
        System.out.println(solution.maxProductPath(grid)); // Output: 216
    }
}