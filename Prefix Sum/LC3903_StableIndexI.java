class LC3903_StableIndexI {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int j = i;
            int leftmax = Integer.MIN_VALUE;
            while (j >= 0) {
                leftmax = Math.max(leftmax, nums[j]);
                j--;
            }
            j = i;
            int rightmin = Integer.MAX_VALUE;
            while (j < n) {
                rightmin = Math.min(rightmin, nums[j]);
                j++;
            }
            if (leftmax - rightmin <= k) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        LC3903_StableIndexI solution = new LC3903_StableIndexI();
        int[] nums = { 1, 3, 2, 4, 5 };
        int k = 2;
        int result = solution.firstStableIndex(nums, k);
        System.out.println("First stable index: " + result);
    }
}
