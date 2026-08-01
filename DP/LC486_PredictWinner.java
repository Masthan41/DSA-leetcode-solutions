class LC486_PredictWinner {
    int dp[][] = new int[21][21];

    public int solve(int nums[], int i, int j) {
        if (i > j) {
            return 0;
        }

        if (i == j) {
            return nums[i];
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int take_i = nums[i] - solve(nums, i + 1, j);

        int take_j = nums[j] - solve(nums, i, j - 1);

        return dp[i][j] = Math.max(take_i, take_j);
    }

    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;

        for (int row[] : dp) {
            Arrays.fill(row, -1);
        }
        return solve(nums, 0, n - 1) >= 0;
    }

    public static void main(String[] a) {
        LC486_PredictWinner obj = new LC486_PredictWinner();
        int[] nums = { 1, 5, 2 };
        System.out.println(obj.predictTheWinner(nums));
    }
}