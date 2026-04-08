/*
Leetcode 657: Return to Origin
Approach: Simulate the movements and check if the final position is the origin
Time Complexity: O(n) - where n is the length of the moves string
Space Complexity: O(1) - we are using a constant amount of space to track the position
*/

class LC657_ReturnToOrigin {
    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;
        for (int i = 0; i < moves.length(); i++) {
            if (moves.charAt(i) == 'U') {
                y++;
            } else if (moves.charAt(i) == 'D') {
                y--;
            } else if (moves.charAt(i) == 'L') {
                x--;
            } else {
                x++;
            }
        }
        return x == 0 && y == 0;
    }

    public static void main(String[] args) {
        LC657_ReturnToOrigin solution = new LC657_ReturnToOrigin();
        String moves = "UD";
        boolean result = solution.judgeCircle(moves);
        System.out.println(result); // Output: true
    }
}
