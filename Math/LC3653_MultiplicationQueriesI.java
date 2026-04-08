public class LC3653_MultiplicationQueriesI {
    final int M = 1000000007;

    public int xorAfterQueries(int[] nums, int[][] queries) {
        for (int i[] : queries) {
            int l = i[0];
            int r = i[1];
            int k = i[2];
            int v = i[3];

            while (l <= r) {
                nums[l] = (int) ((1L * nums[l] * v) % M);
                l += k;
            }
        }
        int res = 0;
        for (int i : nums) {
            res = res ^ i;
        }
        return res;
    }

    public static void main(String[] args) {
        LC3653_MultiplicationQueriesI lc = new LC3653_MultiplicationQueriesI();
        System.out.println(lc.xorAfterQueries(new int[] { 1, 2, 3, 4, 5 },
                new int[][] { { 0, 4, 1, 2 }, { 0, 3, 2, 2 }, { 0, 1, 1, 2 } }));
    }
}
