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
