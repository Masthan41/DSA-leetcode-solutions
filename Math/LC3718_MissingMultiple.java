class LC3718_MissingMultiple {
    public int missingMultiple(int[] nums, int k) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int i = k;
        while (set.contains(i)) {
            i += k;
        }
        return i;
    }

    public static void main(String[] args) {
        LC3718_MissingMultiple solution = new LC3718_MissingMultiple();
        int[] nums = { 1, 2, 3, 4, 5 };
        int k = 2;
        int result = solution.missingMultiple(nums, k);
    }
}