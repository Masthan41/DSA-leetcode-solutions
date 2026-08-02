import java.util.Arrays;

class LC877_StoneGame {
    int dp[][] = new int[501][501];

    public int solve(int i, int j, int arr[]) {
        if (i > j)
            return 0;
        if (i == j)
            return arr[i];

        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int take_i = arr[i] + Math.min((solve(i + 2, j, arr)), solve(i + 1, j - 1, arr));
        int take_j = arr[j] + Math.min((solve(i, j - 2, arr)), solve(i + 1, j - 1, arr));

        return dp[i][j] = Math.max(take_i, take_j);
    }

    public boolean stoneGame(int[] piles) {

        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }
        int total = 0;
        for (int pile : piles) {
            total += pile;
        }

        int alice = solve(0, piles.length - 1, piles);
        return alice > total / 2;
    }

    public static void main(String[] args) {
        LC877_StoneGame obj = new LC877_StoneGame();
        int[] piles = { 3, 9, 1, 2 };
        boolean result = obj.stoneGame(piles);
        System.out.println(result); // Output: true
    }
}
