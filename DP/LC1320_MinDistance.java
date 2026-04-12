/*
LeetCode 1320 - Minimum Distance to Type a Word Using Two Fingers

Approach: Use dynamic programming to store the minimum distance to type the remaining characters of the word given the current positions of the two fingers. We can represent the positions of the fingers as indices from 0 to 25 (for letters A-Z) and 26 for the initial position (not on any key). The dp state can be defined as dp[i][f1][f2], where i is the current index in the word, f1 is the position of finger 1, and f2 is the position of finger 2. We will iterate through all possible positions of the fingers and calculate the minimum distance for each state.

Time Complexity: O(n * 27 * 27) = O(n) where n is the length of the word and m is the number of possible positions for the fingers (27 in this case). This is because we have to fill a 3D dp table of size n x 27 x 27.

Space Complexity: O(n * 27 * 27) = O(n) for the dp table. However, we can optimize it to O(27 * 27) = O(1) by only keeping track of the current and next states instead of the entire table.
*/

class LC1320_MinDistance {
    public int[] getCoordinate(int pos) {
        return new int[] { pos / 6, pos % 6 };
    }

    public int getDist(int pos1, int pos2) {
        if (pos1 == 26 || pos2 == 26)
            return 0;

        int c1[] = getCoordinate(pos1);
        int c2[] = getCoordinate(pos2);

        int x1 = c1[0], y1 = c1[1];
        int x2 = c2[0], y2 = c2[1];
        return Math.abs(x2 - x1) + Math.abs(y2 - y1);
    }

    public int minimumDistance(String word) {
        int n = word.length();
        int dp[][][] = new int[n + 1][27][27];

        for (int i = n - 1; i >= 0; i--) {
            int curr = word.charAt(i) - 'A';
            for (int f1 = 0; f1 < 27; f1++) {
                for (int f2 = 0; f2 < 27; f2++) {

                    // none of them are used
                    if (f1 == 26 && f2 == 26) {
                        dp[i][f1][f2] = dp[i + 1][curr][f2];
                    }

                    // f2 is used
                    if (f2 == 26) {
                        int moveF2 = dp[i + 1][f1][curr];
                        int moveF1 = getDist(f1, curr) + dp[i + 1][curr][f2];

                        dp[i][f1][f2] = Math.min(moveF1, moveF2);
                        continue;
                    }

                    // both are used
                    int moveF1 = getDist(f1, curr) + dp[i + 1][curr][f2];
                    int moveF2 = getDist(f2, curr) + dp[i + 1][f1][curr];

                    dp[i][f1][f2] = Math.min(moveF1, moveF2);
                }
            }
        }
        return dp[0][26][26];
    }

    public static void main(String[] args) {
        LC1320_MinDistance obj = new LC1320_MinDistance();
        String word = "CAKE";
        System.out.println(obj.minimumDistance(word));
    }
}
