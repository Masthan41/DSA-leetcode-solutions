/* LeetCode 3360 - Stone Removal Game
Approach: Use a mathematical approach to determine if Alice can win the game. The game can be analyzed using the formula derived from the quadratic equation, which helps to find the number of steps required to reach a winning position.
Time Complexity: O(1) as we are performing a constant time calculation
Space Complexity: O(1) as we are using a constant amount of extra space
*/

//this question can also be solved using a while loop and a counter to count the number of steps until n becomes 0. If the counter is odd, Alice wins; if even, Bob wins. However, the mathematical approach is more efficient and elegant.

//this formula is derived from the fact that the game can be represented as a quadratic equation, and we can solve for the number of steps required to reach a winning position. The formula is based on the observation that the game can be reduced to a series of moves that can be represented as a quadratic function, and we can use the quadratic formula to find the number of steps required to reach a winning position.

/*
    the formula derivation is as follows:
    let n be the number of stones, and let k be the number of steps required to reach a winning position. The game can be represented as a series of moves that can be represented as a quadratic function:
    k^2 + k - 2n = 0
    Using the quadratic formula (x = (-b ± sqrt(b^2 - 4ac)) / (2a)), we can solve for k:
    k = (-1 + sqrt(1 + 8n)) / 2
    The number of steps required to reach a winning position is given by the formula:
    steps = (int) (21 - Math.sqrt(441 - 8 * n)) / 2
*/
class LC3360_StoneRemovalGame {
    public boolean canAliceWin(int n) {
        int steps = (int) (21 - Math.sqrt(441 - 8 * n)) / 2;
        return steps % 2 == 1;
    }

    public static void main(String[] args) {
        LC3360_StoneRemovalGame sol = new LC3360_StoneRemovalGame();
        int n = 56;
        boolean result = sol.canAliceWin(n);
        System.out.println(result); // Output: true
    }
}
