class LC3740_GoodTuplesI {
    public int minimumDistance(int[] nums) {
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] == nums[j] && nums[j] == nums[k]) {
                        res = Math.min(res, 2 * (k - i));
                    }
                }
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public static void main(String[] args) {
        LC3740_GoodTuplesI solution = new LC3740_GoodTuplesI();
        int[] nums = { 1, 2, 3, 1, 2, 3, 1 };
        System.out.println(solution.minimumDistance(nums)); // Output: 4
    }
}
