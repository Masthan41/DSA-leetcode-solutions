class LC2833_FursthestPoint{
    public int furthestDistanceFromOrigin(String moves) {
        int left = 0, right = 0, dash = 0;
        for (char ch : moves.toCharArray()) {
            if (ch == 'L') {
                left++;
            } else if (ch == 'R') {
                right++;
            } else {
                dash++;
            }
        }
        return Math.abs(left - right) + dash;
    }
    public static void main(String[] args) {
        LC2833_FursthestPoint sol = new LC2833_FursthestPoint();
        String moves = "LLRRRUDUDU";
        int result = sol.furthestDistanceFromOrigin(moves);
        System.out.println("Furthest distance from origin: " + result);
    }
}