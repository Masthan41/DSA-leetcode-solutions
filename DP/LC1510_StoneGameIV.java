/*
LeetCode 1510 - Stone Game IV
Approach: Use Dynamic Programming to determine if the first player can win given n stones. We create a boolean array t where t[i] indicates whether the first player can win with i stones. We iterate through all possible square numbers that can be taken and check if the opponent is left in a losing position (t[i - (k * k)] == false). If so, we mark t[i] as true, indicating that the first player can force a win.
Time Complexity: O(n * sqrt(n)) where n is the number of stones, as we check all square numbers up to n for each stone count.
Space Complexity: O(n) for the boolean array t.
*/

class LC1510_StoneGameIV {
    public boolean winnerSquareGame(int n) {
        boolean[] t = new boolean[n + 1]; // defaults to all false
        // Base case . n == 0, return false
        t[0] = false; // base case
        for (int i = 1; i < n + 1; i++) {
            for (int k = 1; k * k <= i; k++) {
                if (t[i - (k * k)] == false) {
                    t[i] = true;
                    break;
                }
            }
        }
        return t[n]; // return solve(n)
    }

    public static void main(String[] args) {
        LC1510_StoneGameIV obj = new LC1510_StoneGameIV();
        System.out.println(obj.winnerSquareGame(1)); // true
        System.out.println(obj.winnerSquareGame(2)); // false
        System.out.println(obj.winnerSquareGame(4)); // true
        System.out.println(obj.winnerSquareGame(7)); // false
        System.out.println(obj.winnerSquareGame(17)); // true
    }
}
